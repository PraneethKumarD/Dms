package com.cye.dms.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExcepptionHandller extends ResponseEntityExceptionHandler{

    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatusCode status, WebRequest request )
    {
        Map<String, String> validationerrormessage = new HashMap<String, String>();
        List<ObjectError> validationerrorlist = ex.getBindingResult().getAllErrors();

       validationerrorlist.forEach((error) -> {
                        String fieldName = ((FieldError) error).getField();
                        String validationMsg = error.getDefaultMessage();
                        validationerrormessage.put(fieldName, validationMsg);
                });
 
                return new ResponseEntity<>(validationerrormessage, HttpStatus.BAD_REQUEST);
        }


         @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Internal server error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DmsFormConfigNotFoundException.class)
    public ResponseEntity<String> handleDmsForConfigNotFoundException(DmsFormConfigNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DmsFieldMasterDataNotFoundException.class)
    public ResponseEntity<String> handleDmsFieldMasterDataNotFoundException(DmsFieldMasterDataNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    }





