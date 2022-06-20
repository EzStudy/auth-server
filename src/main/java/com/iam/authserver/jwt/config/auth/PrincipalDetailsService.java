package com.iam.authserver.jwt.config.auth;

import com.iam.authserver.jwt.entity.User;
import com.iam.authserver.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(username);
        logger.info("user :: {}", user);

        if(user!=null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            String roles[] = user.getRole().split(",");
            for(String role : roles){
                authorities.add(new SimpleGrantedAuthority(role));
            }
            logger.info("*********************");
            return new PrincipalDetails(user);  //SecurityContext의 authentication에 등록되어 인증정보를 가진다.
        }else{
            throw new UsernameNotFoundException(user.getUserName());
        }
    }
}

