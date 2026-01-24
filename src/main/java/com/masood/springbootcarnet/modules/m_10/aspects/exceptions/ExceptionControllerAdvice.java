package com.masood.springbootcarnet.modules.m_10.aspects.exceptions;


import com.masood.springbootcarnet.modules.m_10.exceptions.NotEnoughMoneyException;
import com.masood.springbootcarnet.modules.m_10.models.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetail> exceptionNotEnoughMoneyHandler(NotEnoughMoneyException notEnoughMoneyException) {

       ErrorDetail ed = new ErrorDetail();
       ed.setMessage("Insufficient Balance");

       return ResponseEntity
               .badRequest()
               .header("message",notEnoughMoneyException.getMessage())
               .body(ed);

    }

}
