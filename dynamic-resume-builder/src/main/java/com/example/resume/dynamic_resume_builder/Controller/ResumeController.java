package com.example.resume.dynamic_resume_builder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume.dynamic_resume_builder.Config.AppConfig;
import com.example.resume.dynamic_resume_builder.Pojo.ResumePojo;
import com.example.resume.dynamic_resume_builder.ServiceInterfaces.ResumeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(AppConfig.RESUME)
public class ResumeController {
    
    
	@Autowired
    ResumeService resumeService;
    
    @PostMapping(AppConfig.ADD_DETAIL)
    public ResumePojo addResume(@Valid @RequestBody ResumePojo resumePojo) {
        return resumeService.createResume(resumePojo);
    }
    
    @GetMapping(AppConfig.GET_ALL_DETAILS)
    public List<ResumePojo> getDetails() {
        return resumeService.fetchAllDetails();
    }
    
    @GetMapping(AppConfig.GET_BY_ID_ID)
    public ResumePojo getById(@PathVariable long id) {
        return resumeService.fetchById(id);
    }
    
    @PutMapping(AppConfig.UPDATE_ID_ID)
    public ResumePojo update(@RequestBody ResumePojo resumePojo, @PathVariable long id) {
        return resumeService.updateResumebyID(resumePojo, id);
    }
    
    @DeleteMapping(AppConfig.DELETE_ID_ID)
    public String delete(@PathVariable long id) {
        return resumeService.deleteResumebyID(id);
    }
    
    @GetMapping(AppConfig.GET_BY_SKILLS_SKILLS)
    public List<ResumePojo> getBySkills(@PathVariable String skills) {
        return resumeService.getResumebySkills(skills);
    }
    
    @GetMapping(AppConfig.GET_BY_EXPERIENCE_WORK_EXPERIENCE)
    public List<ResumePojo> getByExperience(@PathVariable String workExperience) {
        return resumeService.getbyWorkExperience(workExperience);
    }
}
