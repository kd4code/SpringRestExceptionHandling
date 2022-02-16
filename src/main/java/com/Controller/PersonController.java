package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.PersonDAO;
import com.Entity.Person;
import com.ExceptionClasses.IDExistException;
import com.ExceptionClasses.NotValidAgeException;

@RestController
public class PersonController {
    @Autowired
	PersonDAO pd;
    
    @PostMapping("/register") 
    public ResponseEntity resgister(@RequestBody Person p)throws IDExistException,NotValidAgeException
    {
    	
//**********With Try Catch***********    	
//      try{
//    	  int id=pd.register(p);
//    	  return ResponseEntity.ok("Record Registered Successfully");
//      }catch(IDExistException ie)
//       {
//         return new ResponseEntity(ie.getMessage(),HttpStatus.CONFLICT);
//       }
//       catch(NotValidAgeException ne)
//       {
//           return new ResponseEntity(ne.getMessage(),HttpStatus.NOT_ACCEPTABLE);
//       }
       
    	int id=pd.register(p);
   	    return ResponseEntity.ok("Record Registered Successfully");
    }
    
//    @ExceptionHandler(value=IDExistException.class)
//    public ResponseEntity HandleException(IDExistException ie)
//    {
//      return new ResponseEntity(ie.getMessage(),HttpStatus.CONFLICT);	
//    }
//    
//    @ExceptionHandler(value=NotValidAgeException.class)
//    public ResponseEntity HandleException(NotValidAgeException ne)
//    {
//      return new ResponseEntity(ne.getMessage(),HttpStatus.NOT_ACCEPTABLE);	
//    }
}