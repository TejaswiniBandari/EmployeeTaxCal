package com.example.EmployeeTaxCal1.Controller;

import com.example.EmployeeTaxCal1.Entity.Employee;
import com.example.EmployeeTaxCal1.Entity.TaxDetails;
import com.example.EmployeeTaxCal1.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/{employeeId}/tax-deduction")
    public ResponseEntity<TaxDetails> calculateTax(@PathVariable String employeeId) {
        TaxDetails taxDetails = employeeService.calculateTax(employeeId);
        return ResponseEntity.ok(taxDetails);
    }

}
