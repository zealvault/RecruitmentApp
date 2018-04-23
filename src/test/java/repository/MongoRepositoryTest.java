package repository;

import com.github.fakemongo.Fongo;
import com.mongodb.DB;
import model.Candidate;
import model.Recruiter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MongoRepositoryTest {

    static MongoRepository repository;

    @BeforeClass
    public static void setup() {
        Fongo fongo = new Fongo("some fake server");
        DB fakeDb = fongo.getDB("my-fake-db");
        repository = new MongoRepository(fakeDb, "fake collection");
    }

    @Test
    public void givenARecruiter_ShouldBeAbleToAddItOnlyIfAlreadyDoesNotExist() {
        Recruiter aRecruiter = new Recruiter("recruiter-id","Alfred Pennyworht");
        Candidate aCandidate = new Candidate("BatMan","batman@dc.com");
        repository.persist(aRecruiter);
        assertEquals(0,repository.getCollection().count());
    }

}