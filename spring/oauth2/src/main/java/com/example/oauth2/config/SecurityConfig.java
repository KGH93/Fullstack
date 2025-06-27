package com.example.oauth2.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 인증 인가 부여
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                // 요청에 따른 인가 설정
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/user/**", "/order/**", "/pay/**", "/cart/**", "/userEdit", "/myPage", "/qnas/create", "/qnas/edit", "qnas/new").authenticated() // 로그인성공한 사람만  user /밑에 모든  경로에 접근 가능 예를 들면 마이페이지 구매 진행 이런거
                        .requestMatchers("/admin/**") // 관리자로 저장된 회원만 admin / 아래 모든 모든곳에 접근 가능
                        .hasRole("ADMIN")
                        .anyRequest().permitAll() // 그 외에 는 접근 허용
                )
                .oauth2Login(oauth2Login ->
                                oauth2Login
                                        .loginPage("/login")  // 로그인 페이지 설정
//                                .defaultSuccessUrl("/userEdit", true) // 성공 시 이동할 페이지 설정
                                        .defaultSuccessUrl("/loginSuccess") // 성공 시 이동할 페이지 설정
                )
                .formLogin(login -> login
                        .usernameParameter("userId")
                        .passwordParameter("userPw")
                        .loginPage("/login") // 로그인 페이지 설정
                        .defaultSuccessUrl("/") // 성공 시 이동할 페이지 설정
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/") // 로그아웃 성공 시 메인페이지로 갈 수 있게
                        .invalidateHttpSession(true)) // 세션에 정보 삭제
//                .sessionManagement(session -> session
//                        .invalidSessionUrl("/login?invalid-session=true"))
        // http > https 설정
//                .requiresChannel(channel ->
//                        channel.anyRequest().requiresSecure()
//                );
        ;


        return http.build();
    }

    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private OAuth2AuthorizationRequestResolver customAuthorizationRequestResolver(ClientRegistrationRepository repo) {
        DefaultOAuth2AuthorizationRequestResolver defaultResolver =
                new DefaultOAuth2AuthorizationRequestResolver(repo, OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI);

        return new OAuth2AuthorizationRequestResolver() {
            @Override
            public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
                OAuth2AuthorizationRequest originalRequest = defaultResolver.resolve(request);
                return customizeRequestByProvider(request, originalRequest);
            }

            @Override
            public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
                OAuth2AuthorizationRequest originalRequest = defaultResolver.resolve(request, clientRegistrationId);
                return customizeRequestByProvider(request, originalRequest);
            }

            private OAuth2AuthorizationRequest customizeRequestByProvider(HttpServletRequest request, OAuth2AuthorizationRequest originalRequest) {
                if (originalRequest != null) {
                    String requestUri = request.getRequestURI();
                    String registrationId = requestUri.substring(requestUri.lastIndexOf("/") + 1);

                    Map<String, Object> extraParams = new HashMap<>(originalRequest.getAdditionalParameters());

                    // OAuth2 provider에 따라 파라미터 설정
                    if ("kakao".equals(registrationId)) {
                        extraParams.put("prompt", "login");
                    } else if ("google".equals(registrationId)) {
                        extraParams.put("prompt", "select_account");
                    }

                    return OAuth2AuthorizationRequest.from(originalRequest)
                            .additionalParameters(extraParams)
                            .build();
                }
                return originalRequest;
            }
        };
    }
}



