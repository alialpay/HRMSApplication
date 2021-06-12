package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="created_at")
	private LocalDate createdAt;

	@Column(name="application_deadline")
	private LocalDate applicationDeadline;

	@Column(name="is_active")
	private boolean isActive;
	
	@JsonIgnoreProperties({"id","webAddress","phoneNumber","password","email","createdAt"})
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
}
