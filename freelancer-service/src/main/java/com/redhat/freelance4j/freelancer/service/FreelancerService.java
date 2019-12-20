package com.redhat.freelance4j.freelancer.service;

import java.util.List;

import com.redhat.freelance4j.freelancer.model.Freelancer;

public interface FreelancerService {

    public Freelancer getFreelacer(String freelancerId);

    public List<Freelancer> getFreelancers();
}