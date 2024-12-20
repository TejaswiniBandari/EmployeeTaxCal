package com.example.EmployeeTaxCal1.Service;

import com.example.EmployeeTaxCal1.Entity.Employee;
import com.example.EmployeeTaxCal1.Entity.TaxDetails;
import com.example.EmployeeTaxCal1.Exceptions.ResourceNotFoundException;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    TaxDetails calculateTax(String employeeId) throws ResourceNotFoundException;
}
