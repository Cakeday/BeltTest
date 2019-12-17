package com.whatever.javabelt.repositories;

import java.util.List;

import com.whatever.javabelt.models.Show;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ShowRepository
 */
@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
	List<Show> findAll();
}
