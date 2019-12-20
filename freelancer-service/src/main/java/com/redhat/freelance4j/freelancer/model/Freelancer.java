package com.redhat.freelance4j.freelancer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FREELANCER", uniqueConstraints = @UniqueConstraint(columnNames = "freelancer_id"))
public class Freelancer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @Column(name = "freelancer_id")
    private String freelancerId;

    /**
     * first name
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * last name
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * freelancer's email address
     */
    @Column(name = "email_address")
    private String emailAddress;

    /**
     * freelancer's skills
     */
    @Column(name = "skills")
    private String skills;

    public Freelancer() {
    }

    public Freelancer(final String freelancerId, final String firstName, final String lastName,
            final String emailAddress, final String skills) {
        super();
        this.freelancerId = freelancerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.skills = skills;
    }

    /**
     * gets freelancer id
     *
     * @return freelancer id
     */
    public String getFreelancerId() {
        return freelancerId;
    }

    /**
     * sets freelancer id
     *
     * @param freelancerId
     */
    public void setFreelancerId(final String freelancerId) {
        this.freelancerId = freelancerId;
    }

    /**
     * gets first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets firtst name
     *
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets last name
     *
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets email address
     *
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * sets email adress
     *
     * @param emailAddress
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * gets skills
     *
     * @return skills
     */
    public String getSkills() {
        return skills;
    }

    /**
     * sets skill
     *
     * @param skills
     */
    public void setSkills(final String skills) {
        this.skills = skills;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public String toString() {
        return "Freelancer [" + "freelancerId=" + freelancerId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", emailAddress=" + emailAddress + ", skills=" + skills + "]";
    }

}
