package com.redhat.freelance4j.gateway;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

@RunWith(Arquillian.class)
public class RestApiTest {

    private static String port = "18080";

    private Client client;

    @CreateSwarm
    public static Swarm newContainer() throws Exception {
        final Properties properties = new Properties();
        properties.put("swarm.http.port", port);
        return new Swarm(properties);
    }

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class).addPackages(true, RestApplication.class.getPackage())
                .addAsResource("project-local.yml", "project-local.yml");
    }

    @Before
    public void before() throws Exception {
        client = ClientBuilder.newClient();
    }

    @After
    public void after() throws Exception {
        client.close();
    }

    @Test
    @RunAsClient
    public void testHealthCheck() throws Exception {
        final WebTarget target = client.target("http://localhost:" + port).path("/health");
        final Response response = target.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), equalTo(new Integer(200)));
        final JsonObject value = Json.parse(response.readEntity(String.class)).asObject();
        assertThat(value.getString("outcome", ""), equalTo("UP"));
    }

    @Test
    @RunAsClient
    public void testGetFreelancers() throws Exception {
        final WebTarget target = client.target("http://localhost:" + port).path("/gateway").path("/freelancers");
        final Response response = target.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), equalTo(new Integer(404)));
    }

    @Test
    @RunAsClient
    public void testGetProjects() throws Exception {
        final WebTarget target = client.target("http://localhost:" + port).path("/gateway").path("/projects");
        final Response response = target.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), equalTo(new Integer(404)));
    }

}
