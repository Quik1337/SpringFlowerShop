package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.businessLogic.LoginLogic;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginRestController {
    
    private final LoginLogic loginLogic;

    public LoginRestController(LoginLogic loginLogic) {
        this.loginLogic = loginLogic;
    }
    
    @GetMapping("login")
    private Object login(@RequestParam(value="email") String email,
                         @RequestParam(value="password") String password){
        System.out.println(loginLogic.checkUserType(email, password).toString());
        return loginLogic.checkUserType(email, password);
    }
}