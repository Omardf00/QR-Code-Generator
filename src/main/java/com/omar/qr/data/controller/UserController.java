package com.omar.qr.data.controller;

import com.omar.qr.data.entity.User;
import com.omar.qr.data.response.UserCreateResponse;
import com.omar.qr.data.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/qr/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){

        Map<String, Object> response = new HashMap<>();

        try {
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("ERROR", "There was an error trying to access the database");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("ERROR", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id){

        Map<String, Object> response = new HashMap<>();
        User user = new User();

        try{
            user = userService.findById(id);

            if (user == null){
                response.put("MESSAGE", "There is no user in the database with the id: " + id);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("ERROR", "There was an error trying to access the database");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("ERROR", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable("name") String name){

        Map<String, Object> response = new HashMap<>();
        User user = new User();

        try{
            user = userService.findByName(name);

            if (user == null){
                response.put("MESSAGE", "There is no user in the database with the UserName: " + name);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("ERROR", "There was an error trying to access the database");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            response.put("ERROR", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<>(user, HttpStatus.OK);

    }

}
