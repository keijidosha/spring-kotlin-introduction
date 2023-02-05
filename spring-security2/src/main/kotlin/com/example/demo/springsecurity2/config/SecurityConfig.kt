package com.example.demo.springsecurity2.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests().apply {
            requestMatchers(
                "/css/**",
                "/img/**",
                "/webjars/**"
            ).permitAll()
            requestMatchers("/login").permitAll()
            anyRequest().authenticated()
        }
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .and()
            .logout()
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .and()
            .rememberMe()

        return http.build()
    }

    @Bean
    fun userDetailService(): UserDetailsService {
        val manager = InMemoryUserDetailsManager()
        manager.createUser(
            User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .authorities("ADMIN")
                .build()
        )
        manager.createUser(
            User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .authorities("USER")
                .build()
        )

        return manager
    }

//    @Bean
//    fun userDetailsService(): UserDetailsService {
//        val user = User
//            .withUsername("user")
//            .password("\$2a\$10\$GSVmY7rf0S8fmJ/xuLmZB.2V9i0VSTxU7nhWETl8j01gQwIKNKRkS")
//            .authorities("USER")
//            .build()
//        val admin = User
//            .withUsername("admin")
//            .password("\$2a\$10\$lqrM4SVtS95fr8DY447eD.piM1wARsG8XgFWsecGfr6tZHPUUPqCe")
//            .authorities("ADMIN")
//            .build()
//        return InMemoryUserDetailsManager(user, admin)
//    }
}