package com.whatever.javabelt.services;

import java.util.List;
import java.util.Optional;

import com.whatever.javabelt.models.Show;
import com.whatever.javabelt.repositories.ShowRepository;

import org.springframework.stereotype.Service;

/**
 * ShowService
 */
@Service
public class ShowService {

    private final ShowRepository showRepository;
// The below constructor must match the classname!!!
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    // creates and updates a show
    public Show createShow(Show b) {
        return showRepository.save(b);
    }

    // returns all the shows
    public List<Show> allShows() {
        return showRepository.findAll();
    }

    // retrieves a show
    public Show findShow(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        if(optionalShow.isPresent()) {
            return optionalShow.get();
        } else {
            return null;
        }
    }



    // deletes a show
    public void deleteShow(long id) {
    	showRepository.deleteById(id);
    }
}