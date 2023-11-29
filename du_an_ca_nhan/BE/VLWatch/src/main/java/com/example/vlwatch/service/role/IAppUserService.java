package com.example.vlwatch.service.role;

import com.example.vlwatch.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends UserDetailsService {
    Boolean existsByUsername(String userName);

    Boolean createNewAppUser(AppUser appUser, String role);

    Boolean logout(String userName);
    Long findAppUserIdByUserName(String userName);
}
