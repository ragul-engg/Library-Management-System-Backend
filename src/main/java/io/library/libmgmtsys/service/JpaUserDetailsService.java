// package io.library.libmgmtsys.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import io.library.libmgmtsys.model.SecurityUser;
// import io.library.libmgmtsys.repository.UserMgmtRepo;

// @Service
// public class JpaUserDetailsService implements UserDetailsService {

// @Autowired
// UserMgmtRepo userMgmtRepo;

// @Override
// public UserDetails loadUserByUsername(String userName) throws
// UsernameNotFoundException {
// return userMgmtRepo.findByUserName(userName)
// .map(SecurityUser::new)
// .orElseThrow(() -> new UsernameNotFoundException("User Not found " +
// userName));
// }

// }