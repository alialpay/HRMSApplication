package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto extends UserDto {
	
	private String companyName;
	private String webAddress;
	private String email;
	private String phoneNumber;
	private String password;
	private String passwordConfirm;
}
