package fr.istic.taa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.domain.Department;
import fr.istic.taa.domain.Person;
import fr.istic.taa.repository.DepartmentRepository;
import fr.istic.taa.repository.PersonRepository;
import io.swagger.annotations.Api;

@Path("/person")
@Api(value="/person", description = "Person resource")
public class PersonResource {

    private PersonRepository personRepository = new PersonRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
