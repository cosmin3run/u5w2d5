package cosminpetrea.u5w2d5.controllers;

import cosminpetrea.u5w2d5.entities.Employee;
import cosminpetrea.u5w2d5.exceptions.BadRequestException;
import cosminpetrea.u5w2d5.payloads.NewEmployeeDTO;
import cosminpetrea.u5w2d5.payloads.NewEmployeeResponseDTO;
import cosminpetrea.u5w2d5.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    //GET
    @GetMapping
    public Page<Employee> getEmployee(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "name") String sortBy){
        return employeeService.getEmployees(page,size,sortBy);
    }

    //POST

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody @Validated NewEmployeeDTO payload, BindingResult validation) throws Exception{
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }
        return this.employeeService.saveEmployee(payload);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable UUID id) {return this.employeeService.findById(id);}


    @PutMapping("/{id}")
    public Employee FindByIdAndUpdate(@PathVariable UUID id, @RequestBody NewEmployeeDTO updatedEmployee){
        return this.employeeService.findByIdAndUpdate(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {this.employeeService.findByIDAndDelete(id);}
}
