package com.locknlock.locknlocks.locknlocks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.locknlock.locknlocks.locknlocks.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);
  
  Boolean existsByEmail(String email);
  Boolean existsByPhone(String phone);
  
  User findUserById(long id);
  
	@Query(value = "SELECT * "
			+ "FROM users "
			+ "WHERE trash = false "
			+ "AND email LIKE ?1 "
			+ "ORDER BY id DESC", nativeQuery = true)
  User findUserByEmail(String email);
  
	@Query(value = "SELECT "
			+ "* "
			+ "FROM users "
			+ "WHERE trash = false "
			+ "ORDER BY id DESC",
			nativeQuery = true)
	List<User> findListUser();
	
	@Query(value = "SELECT "
			+ "* "
			+ "FROM users "
			+ "WHERE trash = true "
			+ "ORDER BY id DESC", nativeQuery = true)
	List<User> findTrashUser();
}
