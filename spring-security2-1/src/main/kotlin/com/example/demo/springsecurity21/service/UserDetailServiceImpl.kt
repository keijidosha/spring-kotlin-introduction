package com.example.demo.springsecurity21.service

import com.example.demo.springsecurity21.model.SiteUser
import com.example.demo.springsecurity21.repository.SiteUserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(private val userRepository: SiteUserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if(username == null) {
            throw UsernameNotFoundException("username is null")
        }

        val user = userRepository.findByUsername(username)
        if(user == null) {
            throw UsernameNotFoundException(username + " not found")
        }

        return createUserDetail(user)
    }

    private fun createUserDetail(user: SiteUser): UserDetails {
        val grantedAutorities = HashSet<GrantedAuthority>()
        grantedAutorities.add(SimpleGrantedAuthority(user.authority?.name ?: ""))

        return User(user.username, user.password, grantedAutorities)
    }

}