package com.example.resume.dynamic_resume_builder.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static final String RESUME = "/resume";
	public static final String GET_BY_EXPERIENCE_WORK_EXPERIENCE = "/getByExperience/{workExperience}";
	public static final String GET_BY_SKILLS_SKILLS = "/getBySkills/{skills}";
	public static final String DELETE_ID_ID = "/deleteId/{id}";
	public static final String UPDATE_ID_ID = "/updateId/{id}";
	public static final String GET_BY_ID_ID = "/getById/{id}";
	public static final String GET_ALL_DETAILS = "/getAllDetails";
	public static final String ADD_DETAIL = "/addDetail";
}
