package com.example.Transport.schedule.service;


import com.example.Transport.schedule.config.UserDetailsImpl;
import com.example.Transport.schedule.models.ApplicationUser;
import com.example.Transport.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return UserDetailsImpl.fromApplicationUser(
                repository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("User not found!"))
        );
    }

//    public ApplicationUser registerUser(ApplicationUser user) {
//        return repository.save(user);
//    }

}

