package com.example.EmployeeTaxCal1.Exceptions;

public class ResourceNotFoundException extends Exception{
private String message;
    public ResourceNotFoundException(String message) {
    super(message);
    }

   public ResourceNotFoundException(){
        super();
   }

}
