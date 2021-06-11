package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_positions")
@NoArgsConstructor
@AllArgsConstructor

public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_position_id")
	private int id;

	@Column(name = "title")
	private String title;
	
	@JsonIgnore 
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvertisement> jobAdvertisements;
}
