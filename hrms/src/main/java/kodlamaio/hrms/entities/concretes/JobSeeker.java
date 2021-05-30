package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import kodlamaio.hrms.core.entities.User;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@Table(name="job_seekers")

public class JobSeeker extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_identity")
    private String nationalIdentity;
    
    @Column(name="date_of_birth")
	private LocalDate dateOfBirth;
    
	@Column(name="is_confirm")
	private boolean isConfirm;    

}