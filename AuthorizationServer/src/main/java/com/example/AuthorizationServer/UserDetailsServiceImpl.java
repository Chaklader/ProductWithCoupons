package com.example.AuthorizationServer;



import com.example.AuthorizationServer.models.User;
import com.example.AuthorizationServer.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 * @author chaklader on @date 11/11/21
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email);

        if (user == null) {
//            throw new RuntimeException("User is not found using the email address " + email);
            System.out.println("Invalid email address " + email);
        }

        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
        return userDetails;
    }
}
