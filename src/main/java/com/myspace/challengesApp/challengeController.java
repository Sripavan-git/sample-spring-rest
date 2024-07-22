package com.myspace.challengesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class challengeController {
    @Autowired
    private ChallengeRepository challengeRepository;

    @GetMapping("/challenges")
    public List<Challenge>  getAllChanllenges(){
        return challengeRepository.findAll();
    }

    @PostMapping("/challenges")
    public String  addChallenge(@RequestBody Challenge challenge){
        challengeRepository.save(challenge);
        return "Challenge added Succesfully";
    }

    @GetMapping("challenges/{id}")
    public Optional<Challenge> getChallenge(@PathVariable("id") long id){
        return challengeRepository.findById(id);
    }

    @PutMapping("challenges/{id}")
    public String updateChallenge(@PathVariable("id") long id, @RequestBody Challenge challenge){
        Optional<Challenge> existingChallenge = challengeRepository.findById(id);
        if(existingChallenge.isPresent()){
            Challenge challenge1 = existingChallenge.get();
            challenge1.setMonth(challenge.getMonth());
            challenge1.setDescription(challenge.getDescription());
            challengeRepository.save(challenge1);
            return "Update Successfull";
        }

        return "Challenge not found";
    }

    @DeleteMapping("challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable("id") long id){
        Optional<Challenge> optionalChallenge = challengeRepository.findById(id);
        if(optionalChallenge.isPresent()){
            challengeRepository.deleteById(id);
            return ResponseEntity.ok("Challenge Deleted Successfully");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}

