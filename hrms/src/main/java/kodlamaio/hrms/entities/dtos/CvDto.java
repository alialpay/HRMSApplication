package kodlamaio.hrms.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.Dto;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.SchoolInfo;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto implements Dto {
	
	 @JsonIgnore
	 private JobSeeker jobSeeker;
	 private List<@Valid SchoolInfo> schools;
	 private List<@Valid Language> languages;
	 private List<@Valid Skill> skills;
	 private List<@Valid SocialMedia> links;
	 private List<@Valid Experience> experiences;
	 private List<@Valid JobSeekerPhoto> images;
}
