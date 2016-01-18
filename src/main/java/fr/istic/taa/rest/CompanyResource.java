package fr.istic.taa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.domain.Company;
import fr.istic.taa.repository.CompanyRepository;
import io.swagger.annotations.Api;

@Path("/company")
@Api(value="/company", description = "Company resource")
public class CompanyResource {

    private CompanyRepository companyRepository = new CompanyRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
