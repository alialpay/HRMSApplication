package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/employee")
public class SystemEmployeesController {
    private final SystemEmployeeService systemEmployeeService;

    public SystemEmployeesController(SystemEmployeeService systemEmployeeService) {
        this.systemEmployeeService = systemEmployeeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody SystemEmployee employee){
        return systemEmployeeService.add(employee);
    }
    @GetMapping("/getall")
    public DataResult<List<SystemEmployee>> getAll(){
        return systemEmployeeService.getAll();
    }
}
