package com.example.demo;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") Long id) {
        Person person = personRepository.findById(id);
        if (person != null) {
            return Response.ok(person).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Transactional
    public Person createPerson(Person person) {
        personRepository.persist(person);
        return person;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updatePerson(@PathParam("id") Long id, Person person) {
        Person existingPerson = personRepository.findById(id);
        if (existingPerson != null) {
            existingPerson.name = person.name;
            personRepository.persist(existingPerson);
            return Response.ok(existingPerson).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletePerson(@PathParam("id") Long id) {
        Person existingPerson = personRepository.findById(id);
        if (existingPerson != null) {
            personRepository.deleteById(id);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/health")
    public Response health() {
        return Response.ok("API is running!").build();
    }
} 