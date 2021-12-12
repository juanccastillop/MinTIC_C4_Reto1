package co.edu.usa.lasartenreto1.reto1_lasarten.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.lasartenreto1.reto1_lasarten.models.User;
import co.edu.usa.lasartenreto1.reto1_lasarten.services.UserService;
/**
* Anotaciones e Inicio clase principal y marcador service
*/ 
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    /**
    * Anotacion de Autowired para inyeccion de dependencias
    */ 
    @Autowired
    private UserService userService;
    /**
    * Metodo get all
    */ 
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
    * Metodo post para guardar usuario
    */ 
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    /**
    * Metodo get por medio de email y password
    */ 
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    /**
    * metodo get por email
    */ 
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }   
}
