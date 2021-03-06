package repository;

import com.mongodb.DB;
import model.Candidate;
import model.Recruiter;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class MongoRepository {

    private final MongoCollection collection;

    public MongoCollection getCollection() {
        return collection;
    }

    public MongoRepository( DB db,String collectionName) {
        Jongo jongo = new Jongo(db);
         this.collection = jongo.getCollection(collectionName);
    }

    public Recruiter getRecruiter(String recruiterId) {
        return collection.findOne("{id:#}",recruiterId).as(Recruiter.class);
    }

    public void addCandidateToRecruiter(String recruiterId, Candidate candidate) {
        collection.update("{id:#}",recruiterId).with("{$addToSet: {candidates: #}}",candidate);
    }

    public void persist(Recruiter recruiter) {
        collection.save(recruiter);
    }
}
