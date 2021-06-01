package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobSeekerForRegisterDto extends UserDto {
	private String firstName;
	private String lastName;
	private String nationalityIdentity;
	private LocalDate dateOfBirth;
	private String email;
	private String password;
}
