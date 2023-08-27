package com.masaischool.service.SerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masaischool.entity.User;
import com.masaischool.repository.UserRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	private UserRepository ur;

	@Autowired
	public JWTUserDetailsService(UserRepository ur) {
		super();
		this.ur = ur;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Integer ID = Integer.parseInt(username);
		System.out.println(username);
		Optional<User> opt = ur.findByAadharNo(username);

		if (opt.isPresent()) {

			User user = opt.get();

			System.out.println(user.getEmail() + " " + user.getRole());

			List<GrantedAuthority> authorities = new ArrayList<>();

			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole());
			authorities.add(sga);

			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);

		} else
			throw new BadCredentialsException("User Details not found with this username: " + username);

	}

}
