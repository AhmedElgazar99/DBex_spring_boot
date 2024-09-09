package DBApplication.example.DBex.controller;


import DBApplication.example.DBex.model.User;
import DBApplication.example.DBex.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    private  final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public String getalluser(Model model){
        model.addAttribute("users",userServices.getalluser());
        return "index";
    }
    @PostMapping("/createuser")
    public String createuser(@ModelAttribute("user") User user){
         userServices.createuser(user);
         return "redirect:/users";

    }
    @GetMapping("/shownewuserform")
    public String shownewuserform(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "newemployeeform";
    }

    @GetMapping("/{id}")
    public String getuserbyid(@PathVariable (value = "id") long id,Model model){
         User user=userServices.getuserbyid(id);
         model.addAttribute("user",user);
        return "onlyuser";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable (value = "id") long id){
        userServices.deleteuser(id);
        return "redirect:/users";

    }

    @GetMapping("/updateuser/{id}")
    public String updateuser(@PathVariable (value = "id") long id,Model model){
        User user=userServices.getuserbyid(id);
        model.addAttribute("user",user);
        return "updateuser";
    }
}
