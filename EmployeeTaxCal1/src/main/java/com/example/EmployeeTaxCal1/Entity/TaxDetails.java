package com.example.EmployeeTaxCal1.Entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxDetails {
    private String employeeId;
    private String firstName;
    private String lastName;
    private Double yearlySalary;
    private Double taxAmount;
    private Double cessAmount;

    @Override
    public String toString() {
        return "TaxDetails{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearlySalary=" + yearlySalary +
                ", taxAmount=" + taxAmount +
                ", cessAmount=" + cessAmount +
                '}';
    }
}
