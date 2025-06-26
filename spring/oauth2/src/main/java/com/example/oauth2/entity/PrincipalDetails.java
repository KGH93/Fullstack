package com.example.oauth2.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements UserDetails {
    //PrincipalDetails 클래스는 UserDetails 인터페이스를 구현하여 사용자 정보를 보유하고 있습니다.
    //Oauth2 로그인 혹은 일반 로그인 후, spring security의 인증 객체로 저장되는 핵심 클래스

    private final Users users;
    //직접 정의한 사용자 엔티티
    private final Map<String, Object> attributes;
    //oauth2로그인 시 받은 사용자 정보

    public PrincipalDetails(Users users, Map<String, Object> attributes) {
        this.users = users;
        //소셜로그인 시 oauth2 사용자정보(attribute)를 함께 저장
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 사용자의 권한을 반환하는 로직을 구현
        return null;
    }

    @Override
    public String getPassword() {
        return users.getUserPw();
    }

    @Override
    public String getUsername() {
        return users.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부를 반환하는 로직을 구현
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠금 여부를 반환하는 로직을 구현
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 자격 증명 만료 여부를 반환하는 로직을 구현
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성화 여부를 반환하는 로직을 구현
    }
}
