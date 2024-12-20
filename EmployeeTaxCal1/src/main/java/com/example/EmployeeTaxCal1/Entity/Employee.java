package com.example.EmployeeTaxCal1.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String employeeId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @NotNull
    private String email;

    @ElementCollection
    @NotNull
    private List<String> phoneNumbers;

    @NotNull
    private LocalDate dateOfJoining;

    @NotNull
    private Double monthlySalary;

    public @NotNull String getEmployeeId() {
        return employeeId;
    }

    public @NotNull String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public @NotNull String getLastName() {
        return lastName;
    }

    public @Email @NotNull String getEmail() {
        return email;
    }

    public @NotNull List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public @NotNull LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public @NotNull Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeId(@NotNull String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(@Email @NotNull String email) {
        this.email = email;
    }

    public void setPhoneNumbers(@NotNull List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setDateOfJoining(@NotNull LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setMonthlySalary(@NotNull Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
