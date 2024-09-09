package DBApplication.example.DBex.controller;


import DBApplication.example.DBex.model.User;
import DBApplication.example.DBex.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private  final UserServices userServices;


    public UserRestController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> getalluser(){
        return userServices.getalluser();
    }

    @PostMapping
    public ResponseEntity<User> createuser(@RequestBody User user){
        User saveduser= userServices.createuser(user);
        return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getuserbyid(@PathVariable (value = "id") long id){
        User user= userServices.getuserbyid(id);
        return new  ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteuser(@PathVariable (value = "id") long id){
        userServices.deleteuser(id);
    }

    @PutMapping("/{id}")
    public User updateuser(@PathVariable (value = "id") long id,@RequestBody User user){
        return userServices.updateuser(id,user);
    }
}
