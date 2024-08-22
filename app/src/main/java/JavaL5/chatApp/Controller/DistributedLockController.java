package JavaL5.chatApp.Controller;


import JavaL5.chatApp.dto.ApiRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("api")
public class DistributedLockController {




    @PostMapping("/request")
    public void apiRequest(@RequestBody ApiRequest apiRequest){


    }


}
