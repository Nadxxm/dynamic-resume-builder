package com.example.resume.dynamic_resume_builder.ServiceInterfaces;

import java.util.List;

import com.example.resume.dynamic_resume_builder.Pojo.ResumePojo;

public interface ResumeService {
	
    ResumePojo createResume(ResumePojo resumePojo);

    List<ResumePojo> fetchAllDetails();

    ResumePojo fetchById(long id);

    ResumePojo updateResumebyID(ResumePojo resumePojo, long id);

    String deleteResumebyID(long id);

    List<ResumePojo> getResumebySkills(String skills);

    List<ResumePojo> getbyWorkExperience(String workExperience);
}

