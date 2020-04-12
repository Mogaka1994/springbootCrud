/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogaka.polycarp.controller;


import com.mogaka.polycarp.Exception.ResourceNotFoundException;
import com.mogaka.polycarp.Repository.FriendsRepository;
import com.mogaka.polycarp.entity.Friends;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author moha
 */

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FriendsController {
    @Autowired
    private FriendsRepository friendsrepository;

    @GetMapping("/friends")
    public List<Friends> getAllFriends() {
        return friendsrepository.findAll();
    }

    @GetMapping("/getfriend/{id}")
    public ResponseEntity<Friends> getFriendById(@PathVariable(value = "id") Long friendId)
        throws ResourceNotFoundException {
        Friends friend = friendsrepository.findById(friendId)
          .orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + friendId));
        return ResponseEntity.ok().body(friend);
    }
    
    @PostMapping("/friend")
    public Friends createFriend(@Valid @RequestBody Friends friend) {
        return friendsrepository.save(friend);
    }

    @DeleteMapping("/delfriend/{id}")
    public Map<String, Boolean> deleteFriend(@PathVariable(value = "id") Long friendId)
         throws ResourceNotFoundException {
        Friends friend = friendsrepository.findById(friendId)
       .orElseThrow(() -> new ResourceNotFoundException("Friend not present for the id :: " + friendId));

        friendsrepository.delete(friend);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/updatefriend/{id}")
    public ResponseEntity<Friends>updateFriend(@PathVariable(value = "id") Long friendId,
         @Valid @RequestBody Friends friendDetails) throws    ResourceNotFoundException {
        Friends friend = friendsrepository.findById(friendId)
        .orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + friendId));

        friend.setEmail(friendDetails.getEmail());
        friend.setLname(friendDetails.getLname());
        friend.setFname(friendDetails.getFname());
        final Friends updatedEmployee = friendsrepository.save(friend);
        return ResponseEntity.ok(updatedEmployee);
    }
}
