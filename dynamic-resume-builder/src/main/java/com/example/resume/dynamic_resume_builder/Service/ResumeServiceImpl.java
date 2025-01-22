package com.example.resume.dynamic_resume_builder.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.resume.dynamic_resume_builder.Pojo.ResumePojo;
import com.example.resume.dynamic_resume_builder.Repository.ResumeRepository;
import com.example.resume.dynamic_resume_builder.ServiceInterfaces.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

    ResumeRepository resumeRepository;
    ModelMapper modelMapper;
    
    public ResumeServiceImpl(ResumeRepository resumeRepository, ModelMapper modelMapper) {
        this.resumeRepository = resumeRepository;
        this.modelMapper = modelMapper;
    }
    
    @Override
    public ResumePojo createResume(ResumePojo resumePojo) {
        return resumeRepository.save(resumePojo);
    }

    @Override
    public List<ResumePojo> fetchAllDetails() {
        return resumeRepository.findAll();
    }

    @Override
    public ResumePojo fetchById(long id) {
        return resumeRepository.findById(id).orElse(null);
    }

    @Override
    public ResumePojo updateResumebyID(ResumePojo resumePojo, long id) {
        Optional<ResumePojo> existingResume = resumeRepository.findById(id);

        if (existingResume.isPresent()) {
            ResumePojo existing = existingResume.get();

            // Update fields of the existing resume
            existing.setFullName(resumePojo.getFullName());
            existing.setEmail(resumePojo.getEmail());
            existing.setPhone(resumePojo.getPhone());
            existing.setProfessionalSummary(resumePojo.getProfessionalSummary());
            existing.setEducationDetails(resumePojo.getEducationDetails());
            existing.setWorkExperience(resumePojo.getWorkExperience());
            existing.setSkills(resumePojo.getSkills());
            existing.setProjects(resumePojo.getProjects());
            existing.setLanguages(resumePojo.getLanguages());

            // Save the updated entity
            return resumeRepository.save(existing);
        } else {
            // Return null if the resume doesn't exist
            return null;
        }
    }

    @Override
    public String deleteResumebyID(long id) {
        if (resumeRepository.existsById(id)) {
            resumeRepository.deleteById(id);
            return "Resume with ID " + id + " has been deleted.";
        } else {
            return "Resume with ID " + id + " not found.";
        }
    }

    @Override
    public List<ResumePojo> getResumebySkills(String skills) {
        List<ResumePojo> bySkills = resumeRepository.findBySkillsContaining(skills); // Correct method name
        return (bySkills != null && !bySkills.isEmpty()) ? bySkills : new ArrayList<>();
    }

    @Override
    public List<ResumePojo> getbyWorkExperience(String workExperience) {
        List<ResumePojo> byWorkExperience = resumeRepository.findByWorkExperienceContaining(workExperience); // Correct method name
        return (byWorkExperience != null && !byWorkExperience.isEmpty()) ? byWorkExperience : new ArrayList<>();
    }
}
