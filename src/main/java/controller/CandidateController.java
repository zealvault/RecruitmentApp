package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import model.Candidate;
import model.Recruiter;
import repository.MongoRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;


@Path("/recruiter")
@Produces(MediaType.APPLICATION_JSON)
public class CandidateController {

    private final MongoRepository collectionRepo;
    private ObjectMapper mapper = Jackson.newObjectMapper();

    public CandidateController(MongoRepository collectionRepo) {
        this.collectionRepo = collectionRepo;
    }

    @GET
    @Path("/{id}")
    public Recruiter getRecruiter(@PathParam("id") String recruiterId) {
        return collectionRepo.getRecruiter(recruiterId);
    }

    @PUT
    @Path("/{id}")
    public Response addCandidate(@PathParam("id") String recruiterId, Candidate candidate) {
        collectionRepo.addCandidateToRecruiter(recruiterId, candidate);
        return Response.noContent().build();
    }

    @POST
    public Response addRecruiter(Recruiter recruiter) throws URISyntaxException {
        collectionRepo.persist(recruiter);
        return Response.created(new URI("/recruiter/")).build();
    }
}
