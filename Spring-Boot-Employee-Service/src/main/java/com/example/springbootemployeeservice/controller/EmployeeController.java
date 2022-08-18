package com.example.springbootemployeeservice.controller;

import com.example.springbootemployeeservice.domain.Employee;
import com.example.springbootemployeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private final EmployeeRepository empRepo;

    @GetMapping("getallemployees")
    public List<Employee> getAllEmployee(){
        log.info("Getting all employees");
        return empRepo.findAll();
    }

    @GetMapping("getemployee")
    public Optional<Employee> getEmployee(@RequestParam("id") Integer id){
        log.info("Getting employee");
        return empRepo.findById(id);
    }

    @PostMapping("addemployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
        log.info("Adding employee");
        empRepo.save(emp);
        return ResponseEntity.ok("Employee added");
    }

    @PutMapping("editemployee")
    public ResponseEntity<String> editEmployee(@RequestBody Employee emp){
        log.info("Editting employee");
        empRepo.save( emp);
        return ResponseEntity.ok("Employee " + emp.getId() + " edited");
    }

    @DeleteMapping("deleteemployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value="id") Integer id){
        log.info("Removing employee");
        empRepo.deleteById(id);
        return ResponseEntity.ok("Employee id: "+ id + " deleted");
    }
}
