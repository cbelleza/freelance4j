package com.redhat.freelance4j.freelancer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.redhat.freelance4j.freelancer.model.Freelancer;

/**
 * Freelancer service
 */
@Component
public class FreelancerServiceImpl implements FreelancerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Freelancer getFreelacer(final String freelancerId) {
        final Freelancer freelancer = entityManager.find(Freelancer.class, freelancerId);
        return freelancer;
    }

    @Override
    public List<Freelancer> getFreelancers() {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Freelancer> cq = cb.createQuery(Freelancer.class);
        final Root<Freelancer> root = cq.from(Freelancer.class);

        final CriteriaQuery<Freelancer> select = cq.select(root);
        select.orderBy(cb.asc(root.get("freelancerId")));

        final List<Freelancer> result = entityManager.createQuery(select).getResultList();

        return result;
    }
}