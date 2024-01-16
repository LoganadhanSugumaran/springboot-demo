package com.JavaSpringDeveloper.demo.repository;
import com.JavaSpringDeveloper.demo.model.Candidate;
import org.springframework.context.annotation.Configuration;
//import jakarta.transaction.Transactional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;

import java.util.*;


//public interface CandidateRepository extends JpaRepository<Candidate, String>{
//
//    @Query( value = "SELECT * FROM Candidate WHERE VOTE = (SELECT MAX(VOTE) FROM CANDIDATE)", nativeQuery = true)
//    Candidate getWinner();
//
//    @Modifying
//    @Transactional
//    @Query( value = "UPDATE CANDIDATE SET VOTE = VOTE + 1 WHERE NAME = ?1", nativeQuery = true)
//    Integer castVote(String name);
//
//    @Query( value = "SELECT VOTE FROM CANDIDATE WHERE NAME = ?1", nativeQuery = true)
//    Integer countVote(String name);
//}

@Configuration
public class CandidateRepository {

    Map candidates = new HashMap<String, Candidate>();

   public boolean existsById(String name) {
        return candidates.containsKey(name);
    }

    public void save(Candidate c) {
        candidates.put(c.getCandidateName(), c);
    }

    public void castVote(String name) {
        Candidate c = (Candidate) candidates.get(name);
       c.setCandidateVote(c.getCandidateVote() + 1);
       candidates.put(name, c);
    }

    public int countVote(String name) {
        Candidate c = (Candidate) candidates.get(name);
         return c.getCandidateVote();
    }

    public Candidate getWinner(){
       Optional c =  candidates.values().stream().max(Comparator.comparing(Candidate::getCandidateVote));
       return (Candidate) c.get();
    }

    public List<Candidate> findAll() {
       return candidates.values().stream().toList();
    }

    public int count(){
       return candidates.size();
    }

}

