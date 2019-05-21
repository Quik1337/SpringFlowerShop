package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.businessLogic.LoginLogic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {
    
    private final LoginLogic loginLogic;

    public LoginRestController(LoginLogic loginLogic) {
        this.loginLogic = loginLogic;
    }
    
    @GetMapping("login")
    private Object login(@RequestParam(value="email") String email,
                         @RequestParam(value="password") String password){
        return loginLogic.checkUserType(email, password);
    }
}