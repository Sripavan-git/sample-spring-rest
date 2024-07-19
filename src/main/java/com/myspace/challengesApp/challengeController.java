package com.myspace.challengesApp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class challengeController {
    private List<Challenge> challenges = new ArrayList<>();
    public challengeController(){
        Challenge challenge1 = new Challenge(1L,"January", "Sample description");
        challenges.add(challenge1);
    }
    public Optional<Challenge> findById(long id) {
        return challenges.stream().filter(challenge -> challenge.getId() == id).findFirst();
    }
    @GetMapping("/challenges")
    public List<Challenge>  getAllChanllenges(){
        return this.challenges;
    }

    @PostMapping("/challenges")
    public String  addChallenge(@RequestBody Challenge challenge){
        challenges.add(challenge);
        return "Challenge added Succesfully";
    }

    @GetMapping("/challenges/{id}")
    public Optional<Challenge> getChallenge(@PathVariable("id") long id){
        return challenges.stream().filter(challenge -> challenge.getId() == id).findFirst();
    }

    @PutMapping("/challenges/{id}")
    public String updateChallenge(@PathVariable("id") long id, @RequestBody Challenge newchallenge){
        Optional<Challenge> existingChallenge = findById(id);
        if(existingChallenge.isPresent()){
            Challenge challengeInst = existingChallenge.get();
            challengeInst.setMonth(newchallenge.getMonth());
            challengeInst.setDescription(newchallenge.getDescription());
            return "Update Successfull";
        }
        return "There is an issue with the Request, Please check the logs ";
    }
}

