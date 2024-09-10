package JavaL5.chatApp.Controller;


import JavaL5.chatApp.Model.App;
import JavaL5.chatApp.dto.app.InspectAppResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AppController extends BaseController {

    @GetMapping("/inspect")
    public ResponseEntity<InspectAppResponse> inspectApp(){ // parameter: (HttpServletRequest request)
        App app = this.getAuthenticatedApp();
        log.info("Class = {}, App = {}", app.getClass(), app);
        return ResponseEntity.ok(InspectAppResponse.builder().app(app).build());
    }
}
