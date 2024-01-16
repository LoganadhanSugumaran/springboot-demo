package com.JavaSpringDeveloper.demo.controller;
import com.JavaSpringDeveloper.demo.model.Candidate;
import com.JavaSpringDeveloper.demo.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestAPIController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/entercandidate")
    public void enterCandidate(@RequestParam String name) {

        if(candidateRepository.existsById(name)){
            System.out.println("Candidate already exists");
        }else{
            Candidate c = new Candidate(name, 0);
            candidateRepository.save(c);
        }
    }

    @GetMapping("/castvote")
    public void castVote(@RequestParam String name) {

        if(candidateRepository.existsById(name)){
            candidateRepository.castVote(name);
        }else{
            System.out.println("Candidate does not exist. Cannot cast vote");
        }
    }

    @GetMapping("/countvote")
    public int countVote(@RequestParam String name) {

        int vote = 0;
        if(candidateRepository.existsById(name)){
            vote = candidateRepository.countVote(name);
        }else{
            System.out.println("Candidate does not exist. Cannot count vote");
        }
        return vote;


    }

    @GetMapping("/listvote")
    public List<Candidate> listVotes() {

        return candidateRepository.findAll();
    }

    @GetMapping("/getwinner")
    public Candidate getWinner() {
        if (candidateRepository.count() > 0)
        return candidateRepository.getWinner();
        return null;
    }
}
