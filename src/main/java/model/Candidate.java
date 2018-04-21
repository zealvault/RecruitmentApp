package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class Candidate {

    public Candidate(@JsonProperty("name") String name,@JsonProperty("email") String email) {
        this.name = name;
        this.email = email;
    }

    @NotNull
    private String name;

    @Email @NotNull
    private  String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
