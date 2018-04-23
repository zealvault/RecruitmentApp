import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import controller.CandidateController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import repository.MongoRepository;
import java.net.UnknownHostException;

public class RecruitmentApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new RecruitmentApplication().run(args);
    }

    @Override
    public String getName() {
        return "recruitment-application";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws UnknownHostException {
        String mongoClientUriPath = "mongodb://localhost:27017";
        String databaseName = "database";
        DB db = new MongoClient(new MongoClientURI(mongoClientUriPath)).getDB(databaseName);
        MongoRepository repo = new MongoRepository(db,"recruiters");
        final CandidateController candidateController = new CandidateController(repo);
        environment.jersey().register(candidateController);
    }
}
