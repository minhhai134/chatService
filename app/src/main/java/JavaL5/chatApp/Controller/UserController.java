package JavaL5.chatApp.Controller;


import JavaL5.chatApp.Model.User;
import JavaL5.chatApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUser")
    public @ResponseBody List<User> getAllUser(){
        return userRepository.findAll();

    }

    @GetMapping("/createUser")
    public void createUser(){
         User user = new User();
         User user2 = userRepository.save(user);
         System.out.println(user2.getId());
    }
}
