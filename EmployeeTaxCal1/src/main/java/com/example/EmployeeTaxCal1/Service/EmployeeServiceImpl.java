package com.example.EmployeeTaxCal1.Service;

import com.example.EmployeeTaxCal1.Entity.Employee;
import com.example.EmployeeTaxCal1.Entity.TaxDetails;
import com.example.EmployeeTaxCal1.Exceptions.ResourceNotFoundException;
import com.example.EmployeeTaxCal1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public TaxDetails calculateTax(String employeeId) {
        try {
            Employee employee = employeeRepository.findByEmployeeId(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

            LocalDate startOfYear = LocalDate.of(LocalDate.now().getYear(), 4, 1);
            LocalDate doj = employee.getDateOfJoining();

            int monthsWorked = doj.isAfter(startOfYear)
                    ? Period.between(doj, LocalDate.now()).getMonths() + 1
                    : 12;

            double yearlySalary = employee.getMonthlySalary() * monthsWorked;

            double tax = 0;
            double cess = 0;

            if (yearlySalary > 250000) {
                tax += (Math.min(yearlySalary, 500000) - 250000) * 0.05;
            }
            if (yearlySalary > 500000) {
                tax += (Math.min(yearlySalary, 1000000) - 500000) * 0.10;
            }
            if (yearlySalary > 1000000) {
                tax += (yearlySalary - 1000000) * 0.20;
            }
            if (yearlySalary > 2500000) {
                cess = (yearlySalary - 2500000) * 0.02;
            }

            return new TaxDetails(
                    employeeId,
                    employee.getFirstName(),
                    employee.getLastName(),
                    yearlySalary,
                    tax,
                    cess
            );
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException("Error calculating tax for employee: " + employeeId, e);
        }
    }
}
