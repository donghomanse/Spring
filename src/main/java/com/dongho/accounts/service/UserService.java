package com.dongho.accounts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dongho.accounts.entity.UserInfo;
import com.dongho.accounts.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserInfo create(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		
		return userRepository.save(userInfo);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userRepository.findByUsername(username);

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		
		return new User(userInfo.getUsername(), userInfo.getPassword(), grantedAuthorities);
		
//		UserDetails userDetails = new UserDetails() {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public Collection<? extends GrantedAuthority> getAuthorities() {
//				List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//				grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//				return grantedAuthorities;
//			}
//
//			@Override
//			public String getPassword() {
//				return user.getPassword();
//			}
//
//			@Override
//			public String getUsername() {
//				return user.getUsername();
//			}
//
//			@Override
//			public boolean isAccountNonExpired() {
//				return true;
//			}
//
//			@Override
//			public boolean isAccountNonLocked() {
//				return true;
//			}
//
//			@Override
//			public boolean isCredentialsNonExpired() {
//				return true;
//			}
//
//			@Override
//			public boolean isEnabled() {
//				return true;
//			}
//		};
//		
//		return userDetails;
	}

}
