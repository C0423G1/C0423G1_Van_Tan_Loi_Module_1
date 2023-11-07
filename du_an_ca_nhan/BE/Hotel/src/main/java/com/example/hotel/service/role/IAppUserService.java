package com.example.hotel.service.role;

import com.example.hotel.model.user.role.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends UserDetailsService {
    Boolean existsByUsername(String userName);

    Boolean createNewAppUser(AppUser appUser, String role);

    Boolean logout(String userName);
    Long findAppUserIdByUserName(String userName);
}
