package kodlamaio.hrms.entities.concretes;
/*
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data 
@NoArgsConstructor
@AllArgsConstructor 
@Table(name="curriculum_vitaes")
@Entity
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jobSeeker_id")
	private JobSeeker jobSeeker;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jobSeekerPhoto_id")
	private JobSeekerPhoto jobSeekerPhoto;
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	private List<SocialMedia> links;
	
	@OneToMany(mappedBy = "cv")
	private List<CoverLetter> preWritings;
	
	@OneToMany(mappedBy = "cv")
	private List<SchoolInfo> schoolInfos;
	
	@OneToMany(mappedBy = "cv")
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "cv")
	private List<Experience> experiences;

}
*/