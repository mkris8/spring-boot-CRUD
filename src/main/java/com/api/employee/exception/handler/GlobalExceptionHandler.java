package com.api.employee.exception.handler;

import com.api.employee.exception.EmployeeAlreadyExistsException;
import com.api.employee.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(employeeNotFoundException.getMessage());
    }

    @ExceptionHandler({EmployeeAlreadyExistsException.class})
    public ResponseEntity<Object> handleEmployeeAlreadyExists(EmployeeAlreadyExistsException employeeAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(employeeAlreadyExistsException.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(runtimeException.getMessage());
    }

}
