package com.project.exemploDeSeguranca.Config;

import com.project.exemploDeSeguranca.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//UserdetailsService não esquece cara
public class UserConfigService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserConfigService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findbyUsername(username)
                .map(UserAuthenticated::new)
                .orElseThrow(()-> new UsernameNotFoundException("Not found"));
    }
}
