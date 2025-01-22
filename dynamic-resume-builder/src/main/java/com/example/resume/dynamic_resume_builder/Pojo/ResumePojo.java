package com.example.resume.dynamic_resume_builder.Pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entity class representing a Resume.
 * Maps to the "Resume" table in the database.
 */
@Entity
@Table(name = "Resume")
public class ResumePojo {

    // Logger instance for debugging and tracking
    private static final Logger logger = LoggerFactory.getLogger(ResumePojo.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal Information
    @NotBlank(message = "Full name is required")
    @Size(min = 5, max = 50, message = "Full name should be between 5 and 50 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;

    // Professional Summary
    @Size(max = 500, message = "Professional summary should not exceed 500 characters")
    private String professionalSummary;

    // Education
    @NotBlank(message = "Education details are required")
    private String educationDetails;

    // Work Experience
    @NotBlank(message = "Work experience is required")
    private String workExperience;

    // Skills
    @NotBlank(message = "Skills are required")
    private String skills;

    // Projects
    @Size(max = 1000, message = "Projects section should not exceed 1000 characters")
    private String projects;

    // Languages
    @NotBlank(message = "Languages are required")
    private String languages;

    @Override
    public String toString() {
        logger.info("Generating toString() for ResumePojo");
        return "ResumePojo [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
                + ", professionalSummary=" + professionalSummary + ", educationDetails=" + educationDetails
                + ", workExperience=" + workExperience + ", skills=" + skills + ", projects=" + projects
                + ", languages=" + languages + "]";
    }

    // Getters and setters
    public Long getId() {
        logger.debug("Getting ID: {}", id);
        return id;
    }

    public void setId(Long id) {
        logger.debug("Setting ID: {}", id);
        this.id = id;
    }

    public String getFullName() {
        logger.debug("Getting full name: {}", fullName);
        return fullName;
    }

    public void setFullName(String fullName) {
        logger.debug("Setting full name: {}", fullName);
        this.fullName = fullName;
    }

    public String getEmail() {
        logger.debug("Getting email: {}", email);
        return email;
    }

    public void setEmail(String email) {
        logger.debug("Setting email: {}", email);
        this.email = email;
    }

    public String getPhone() {
        logger.debug("Getting phone number: {}", phone);
        return phone;
    }

    public void setPhone(String phone) {
        logger.debug("Setting phone number: {}", phone);
        this.phone = phone;
    }

    public String getProfessionalSummary() {
        logger.debug("Getting professional summary");
        return professionalSummary;
    }

    public void setProfessionalSummary(String professionalSummary) {
        logger.debug("Setting professional summary");
        this.professionalSummary = professionalSummary;
    }

    public String getEducationDetails() {
        logger.debug("Getting education details");
        return educationDetails;
    }

    public void setEducationDetails(String educationDetails) {
        logger.debug("Setting education details");
        this.educationDetails = educationDetails;
    }

    public String getWorkExperience() {
        logger.debug("Getting work experience");
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        logger.debug("Setting work experience");
        this.workExperience = workExperience;
    }

    public String getSkills() {
        logger.debug("Getting skills");
        return skills;
    }

    public void setSkills(String skills) {
        logger.debug("Setting skills");
        this.skills = skills;
    }

    public String getProjects() {
        logger.debug("Getting projects");
        return projects;
    }

    public void setProjects(String projects) {
        logger.debug("Setting projects");
        this.projects = projects;
    }

    public String getLanguages() {
        logger.debug("Getting languages");
        return languages;
    }

    public void setLanguages(String languages) {
        logger.debug("Setting languages");
        this.languages = languages;
    }
}
