package model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RecruiterTest {

    @Test
    public void shouldHaveAnEmptyListOfCandidatesInitially() {
        String id = "id1";
        String name = "Alfred PennyWorth";
        Recruiter aRecruiter = new Recruiter(id, name);
        List<Candidate> candidates = aRecruiter.getCandidates();
        Assert.assertEquals(0,candidates.size());
    }

    @Test
    public void shouldBeAbleToAssignANewCandidateToThemselves() {
        String id = "r_id1";
        String name = "Alfred PennyWorth";
        Recruiter aRecruiter = new Recruiter(id, name);
        Candidate aCandidate = new Candidate("Robin", "robin@dc.com");
        aRecruiter.addCandidate(aCandidate);
        List<Candidate> candidates = aRecruiter.getCandidates();
        Assert.assertEquals(1, candidates.size());
    }

    @Test
    public void shouldNotAssignDuplicateCandidateToThemselves(){
        String id = "r_id1";
        String name = "Alfred PennyWorth";
        Recruiter aRecruiter = new Recruiter(id, name);
        Candidate aCandidate = new Candidate("Robin", "robin@dc.com");
        Candidate duplicateCandidate = new Candidate("otherThanRobin","robin@dc.com");
        aRecruiter.addCandidate(aCandidate);
        aRecruiter.addCandidate(duplicateCandidate);
        Assert.assertEquals(1,aRecruiter.getCandidates().size());
        Assert.assertEquals("robin@dc.com",aRecruiter.getCandidates().get(0).getEmail());
    }

}
