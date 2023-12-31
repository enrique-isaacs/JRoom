package com.enrique.JRoom.jRoom.entities.appuser;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.*;



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements  UserDetails {

    
    @SequenceGenerator(
        name = "user_id_seq",
        sequenceName = "user_id_seq",
        allocationSize = 1
    )
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_seq"
    )
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    @Enumerated(EnumType.STRING)
    private AppUserStatus activeStatus;
    
    private Boolean locked;
    private Boolean enabled;
    private Set<Long> chatRooms;
    private LocalDateTime accountCreatedAt;




    public AppUser(String username,
                   String email,
                   String password,
                   Set<Long> chatRooms,
                   AppUserRole appUserRole,
                   Boolean locked,
                   Boolean enabled,
                   LocalDateTime accountCreatedAt,
                   AppUserStatus activeStatus
                   ){


        this.username = username;
        this.email = email;
        this.password = password;
        this.chatRooms = chatRooms;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
        this.activeStatus = activeStatus;
  
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return enabled;
    }



}