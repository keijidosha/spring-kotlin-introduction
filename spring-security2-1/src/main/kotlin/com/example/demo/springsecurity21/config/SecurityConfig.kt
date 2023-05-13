package com.example.demo.springsecurity21.config

import com.example.demo.springsecurity21.util.Authority
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.authorizeHttpRequests{ auth ->
            auth.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            auth.requestMatchers("/register", "/login").permitAll()
            auth.requestMatchers("/admin/**").hasAuthority(Authority.ADMIN.name)
            auth.anyRequest().authenticated()
        }
        .formLogin{ login ->
            login.loginPage("/login")
            login.defaultSuccessUrl("/")
            login.permitAll()
        }
        .logout{ logout ->
            logout.logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            logout.permitAll()
        }
        .rememberMe().key("Unique and Secret")

        return http.build()
    }
}