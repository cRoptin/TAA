package fr.istic.taa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.domain.Department;
import fr.istic.taa.domain.Material;
import fr.istic.taa.repository.DepartmentRepository;
import fr.istic.taa.repository.MaterialRepository;
import io.swagger.annotations.Api;

@Path("/material")
@Api(value="/material", description = "Material resource")
public class MaterialResource {

    private MaterialRepository materialRepository = new MaterialRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Material> getAll() {
        return materialRepository.findAll();
    }
}
