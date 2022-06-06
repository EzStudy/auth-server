package com.iam.authserver.jwt.config.auth;

import com.iam.authserver.jwt.model.User;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
* Spring Secuity가 /login.do 요청이 들어오면
 * 로그인이 완료되면 Spring Session을 생성한다. (SecurityHolder)
 * Object Type => Authentication타입 객체
 * Authentication안에 User 정보가 있어야 함.
 * User Object Type => UserDetails Type 객체
 *
 * Secuirty Session -> Authentication -> UserDetails(PrincipalDetails)
 * */
@SuppressWarnings("serial")//노란줄 경고 없애는 어노테이션, 직렬화 가능 클래스에 대한 누락된 serialVersionUID필드와 관련된 경고를 억제한다.
public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authlist = new ArrayList<>();
        authlist.add(new SimpleGrantedAuthority(user.getRole()));
        return authlist;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
