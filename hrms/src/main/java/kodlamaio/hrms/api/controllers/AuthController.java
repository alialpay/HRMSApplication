package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.concretes.AuthManager;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegisterDto;


@RestController
@RequestMapping("api/")
public class AuthController {
	
	private AuthManager authManager;

	public AuthController(AuthManager authManager) {
		this.authManager = authManager;
	}
	
	@PostMapping("jobseekers/register")
	public Result jobSeekerRegister(
			@RequestBody JobSeekerForRegisterDto jobSeekerDto) {
		return this.authManager.jobSeekerRegister(jobSeekerDto);
	}
	
	
	@PostMapping("employers/register")
	public Result companyRegister(
			@RequestBody EmployerForRegisterDto employerDto) {
		return this.authManager.employerRegister(employerDto);
	}
	
	

}
