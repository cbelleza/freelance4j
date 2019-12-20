package com.redhat.freelance4j.gateway.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.freelance4j.gateway.model.Freelancer;
import com.redhat.freelance4j.gateway.model.Project;
import com.redhat.freelance4j.gateway.service.FreelancerService;
import com.redhat.freelance4j.gateway.service.ProjectService;

@Path("/gateway")
@RequestScoped
public class GatewayResource {

    @Inject
    private FreelancerService freelancerService;

    @Inject
    private ProjectService projectService;

    @GET
    @Path("/projects/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProject(@PathParam("projectId") final String projectId) {
        final Project project = projectService.getProject(projectId);
        if (project == null) {
            throw new NotFoundException();
        } else {
            return project;
        }
    }

    @GET
    @Path("/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjects() {
        final List<Project> projectLst = projectService.getProjects();
        return projectLst;
    }

    @GET
    @Path("/projects/status/{theStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjectsByStatus(@PathParam("theStatus") final String status) {
        final List<Project> projectLst = projectService.getProjectsByStatus(status);
        return projectLst;
    }

    @GET
    @Path("/freelancers/{freelancerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Freelancer getFreelancer(@PathParam("freelancerId") final String freelancerId) {
        final Freelancer freelancer = freelancerService.getFreelancer(freelancerId);
        if (freelancer == null) {
            throw new NotFoundException();
        } else {
            return freelancer;
        }
    }

    @GET
    @Path("/freelancers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Freelancer> getFreelancers() {
        final List<Freelancer> freelancerLst = freelancerService.getFreelancers();
        return freelancerLst;
    }
}
