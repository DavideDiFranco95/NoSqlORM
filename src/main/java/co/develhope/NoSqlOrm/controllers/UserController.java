package co.develhope.NoSqlOrm.controllers;

import co.develhope.NoSqlOrm.entities.User;
import co.develhope.NoSqlOrm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public User createUser(@RequestBody User user){
        user.setId(null);
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    public User getUsers(@PathVariable String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }else{
            throw new Exception("User is not found");
        }
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) throws Exception{
        user.setId(id);
        if (!userRepository.existsById(id)) throw new Exception("User already exist");
        return userRepository.save(user);
    }
    @DeleteMapping("/{id}")
    public void destroyTheUser(@PathVariable String id){
        userRepository.deleteById(id);
    }
}
