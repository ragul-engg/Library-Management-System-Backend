// package io.library.libmgmtsys.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import
// org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import io.library.libmgmtsys.service.JpaUserDetailsService;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity
// public class WebSecurityConfig {

// @Autowired
// private JpaUserDetailsService jpaUserDetailsService;
// @Autowired
// private PasswordEncoder passwordEncoder;

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
// throws Exception {
// httpSecurity.authorizeHttpRequests((authorize) -> authorize
// .requestMatchers("/api/login", "/api/signup").permitAll()
// .requestMatchers("/api/admin").authenticated());
// return httpSecurity.build();
// }

// @Bean
// public DaoAuthenticationProvider authenticationProvider() {
// DaoAuthenticationProvider daoAuthenticationProvider = new
// DaoAuthenticationProvider();
// daoAuthenticationProvider.setUserDetailsService(jpaUserDetailsService);
// daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
// return daoAuthenticationProvider;
// }
// // @Bean
// // public PasswordEncoder bCryptPasswordEncoder() {
// // return new BCryptPasswordEncoder();
// // }
// }