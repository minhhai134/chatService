package JavaL5.chatApp.Controller;

import JavaL5.chatApp.Common.AuthenticationFilter;
import JavaL5.chatApp.Model.App;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;


    /*
    Buoc nay duoc thuc hien sau khi request da di qua Filter, da duoc authenticate
    */
    protected App getAuthenticatedApp(){
        return (App) request.getAttribute(AuthenticationFilter.APP_ATTRIBUTE);
    }

}
