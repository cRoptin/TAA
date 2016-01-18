/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.istic.taa;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import fr.istic.taa.domain.Company;
import fr.istic.taa.domain.Department;
import fr.istic.taa.domain.Employee;
import fr.istic.taa.domain.Material;
import fr.istic.taa.domain.Person;
import fr.istic.taa.rest.SwaggerResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.undertow.Undertow;

import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {

	public static void main(String[] args) {
		UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(new TestApplication());

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("0.0.0-alpha");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("fr.istic.taa.rest");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);

        server.start(Undertow.builder().addHttpListener(8081, "0.0.0.0"));
	}
	
    @Override
    public Set<Class<?>> getClasses() {

    	final Set<Class<?>> resources = new HashSet<Class<?>>();

        // REST endpoints
        resources.add(Department.class);
        resources.add(Employee.class);
        resources.add(Company.class);
        resources.add(Material.class);
        resources.add(Person.class);

        // SWAGGER endpoints
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        resources.add(SwaggerResource.class);

        return resources;
    	
    }

}
