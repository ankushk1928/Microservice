package com.adk.user.service.repositories;

import com.adk.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ankushk
 */

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
