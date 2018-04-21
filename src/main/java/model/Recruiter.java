package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Recruiter {

    private String id;

    private String name;

    private List<Candidate> candidates;

    public Recruiter() {
    }

    public Recruiter(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
        this.candidates = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public Boolean addCandidate(Candidate aCandidate) {
        if(candidates.stream().filter( candidate -> candidate.getEmail() == aCandidate.getEmail()).findFirst().isPresent()){
            return false;
        }
        candidates.add(aCandidate);
        return true;
    }
}
