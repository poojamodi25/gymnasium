package com.gym.repository.gimnasium;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.model.gimnasium.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {

}
