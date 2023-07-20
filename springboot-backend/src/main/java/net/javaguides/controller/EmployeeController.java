package net.javaguides.controller;

import net.javaguides.exception.ResourceNotFound;
import net.javaguides.model.Employee;
import net.javaguides.repositary.EmployeeRepositary;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepositary employeeRepositary;

    @GetMapping
    public List<Employee> getALLEmployee(){
        return employeeRepositary.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp){
        return employeeRepositary.save(emp);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmpByID(@PathVariable Long id){
        Employee empl = employeeRepositary.findById(id).orElseThrow(()->new ResourceNotFound("Emp not exists"+id));
        return ResponseEntity.ok(empl);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmpList(@PathVariable Long id, @RequestBody Employee emp){
        Employee updateEmp = employeeRepositary.findById(id).orElseThrow(()-> new ResourceNotFound("Unable to update "+id));
        updateEmp.setFirstN(emp.getFirstN());
        updateEmp.setLastN(emp.getLastN());
        updateEmp.setEmail(emp.getEmail());
        employeeRepositary.save(updateEmp);
        return ResponseEntity.ok(updateEmp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpRequest> deleteEmp(@PathVariable Long id){
        Employee deleteEmp = employeeRepositary.findById(id).orElseThrow(()-> new ResourceNotFound("Unable to update "+id));
        employeeRepositary.delete(deleteEmp);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
