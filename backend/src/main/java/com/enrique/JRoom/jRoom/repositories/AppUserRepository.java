package com.enrique.JRoom.jRoom.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enrique.JRoom.jRoom.entities.appuser.AppUser;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository {
    
    Optional<AppUser> findByEmail(String email);

}
