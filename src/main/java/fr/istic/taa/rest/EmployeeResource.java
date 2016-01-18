package fr.istic.taa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.domain.Employee;
import fr.istic.taa.repository.EmployeeRepository;
import io.swagger.annotations.Api;

@Path("/employee")
@Api(value="/employee", description = "Employee resource")
public class EmployeeResource {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
