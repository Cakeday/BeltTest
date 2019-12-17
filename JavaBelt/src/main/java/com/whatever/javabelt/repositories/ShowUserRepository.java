package com.whatever.javabelt.repositories;

import java.util.List;

import com.whatever.javabelt.models.ShowUser;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ShowUserRepository
 */
@Repository
public interface ShowUserRepository extends CrudRepository<ShowUser, Long> {
	List<ShowUser> findAll();

	@Query(value="SELECT * FROM shows_users ORDER BY rating DESC", nativeQuery = true)
	List<ShowUser> allOrderedByRating();
}