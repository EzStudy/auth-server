package com.iam.authserver.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(name = "user")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String    userName;
    private String    password;
    private String    email;
    private String    role;          // ROLE_USER, ROLE_ADMIN
    @CreationTimestamp
    private Timestamp createDate;

    public void setRole(String role){
        this.role = role;
    }

    public List<String> getRoles(){
        if(this.role.length() > 0 ){
            return Arrays.asList(this.role.split(","));
        }

        return new ArrayList<>();
    }

}
