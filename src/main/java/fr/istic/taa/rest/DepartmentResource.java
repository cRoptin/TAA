package fr.istic.taa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.domain.Department;
import fr.istic.taa.repository.DepartmentRepository;
import io.swagger.annotations.Api;

@Path("/department")
@Api(value="/department", description = "Department resource")
public class DepartmentResource {

    private DepartmentRepository departmentRepository = new DepartmentRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
