package com.whatever.javabelt.services;

import java.util.List;
import java.util.Optional;

import com.whatever.javabelt.models.ShowUser;
import com.whatever.javabelt.repositories.ShowUserRepository;

import org.springframework.stereotype.Service;

/**
 * ShowUserService
 */
@Service
public class ShowUserService {

    private final ShowUserRepository showUserRepository;
// The below constructor must match the classname!!!
    public ShowUserService(ShowUserRepository showUserRepository) {
        this.showUserRepository = showUserRepository;
    }

    // creates and updates a showUser
    public ShowUser createShowUser(ShowUser b) {
        return showUserRepository.save(b);
    }

    // returns all the showUsers
    public List<ShowUser> allShowUsers() {
        return showUserRepository.findAll();
    }

    // retrieves a showUser
    public ShowUser findShowUser(Long id) {
        Optional<ShowUser> optionalShowUser = showUserRepository.findById(id);
        if(optionalShowUser.isPresent()) {
            return optionalShowUser.get();
        } else {
            return null;
        }
    }



    // deletes a showUser
    public void deleteShowUser(long id) {
    	showUserRepository.deleteById(id);
    }
}