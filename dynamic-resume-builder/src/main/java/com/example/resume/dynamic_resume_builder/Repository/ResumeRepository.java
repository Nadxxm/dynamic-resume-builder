package com.example.resume.dynamic_resume_builder.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.resume.dynamic_resume_builder.Pojo.ResumePojo;

/**
 * ResumeRepository is a Spring Data JPA repository interface for managing {@link ResumePojo} entities.
 * It contains custom query methods for filtering resumes based on skills and work experience.
 */
public interface ResumeRepository extends JpaRepository<ResumePojo, Long> {

    /**
     * Finds resumes that contain the specified skills.
     *
     * @param skills the skills to search for in resumes
     * @return a list of resumes containing the specified skills
     */
    List<ResumePojo> findBySkillsContaining(String skills); // Corrected method name

    /**
     * Finds resumes that contain the specified work experience.
     *
     * @param workExperience the work experience to search for in resumes
     * @return a list of resumes containing the specified work experience
     */
    List<ResumePojo> findByWorkExperienceContaining(String workExperience); // Corrected method name
}
