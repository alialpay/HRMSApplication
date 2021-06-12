package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="employer_id")
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})

public class Employer extends User {

    @Column(name="company_name")
    private String companyName;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="phone_number")
    private String phoneNumber;
    
    @Column(name="is_active")
	private boolean isActive;
    
    @OneToMany(mappedBy= "employer")
	private List<JobAdvertisement> jobAdvertisements;
    
}
