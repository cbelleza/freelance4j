package com.redhat.freelance4j.freelancer.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.redhat.freelance4j.freelancer.model.Freelancer;

/**
 * Validate freelancer service
 */
@ActiveProfiles("dev")
public class FreelancerServiceControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getFreelancerList() throws Exception {
        final String uri = "/freelancers";
        final MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        final int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        final String content = mvcResult.getResponse().getContentAsString();
        final Freelancer[] freelancerlist = super.mapFromJson(content, Freelancer[].class);
        assertTrue(freelancerlist.length > 0);
    }

    @Test
    public void getFreelancer() throws Exception {
        final String uri = "/freelancers/1";
        final MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        final int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        final String content = mvcResult.getResponse().getContentAsString();
        final Freelancer freelancer = super.mapFromJson(content, Freelancer.class);
        assertNotNull(freelancer);
        assertEquals(freelancer.getFreelancerId(), "1");
    }

    @Test
    public void getFreelancerNotExists() throws Exception {
        final String uri = "/freelancers/2000001";
        final MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        final int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        final String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "");
    }
}
