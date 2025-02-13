package com.hamzi.hnia.dz.SecurityConfig;

import com.hamzi.hnia.dz.Models.Users;
import com.hamzi.hnia.dz.Repositorys.usersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustumuserDetailService implements UserDetailsService {
    private usersRepository findusersDetail;

    public CustumuserDetailService(usersRepository findusersDetail) {
        this.findusersDetail = findusersDetail;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findusersDetail.findByUsername(username);
        return new custumuserDetails(user);
    }
}
