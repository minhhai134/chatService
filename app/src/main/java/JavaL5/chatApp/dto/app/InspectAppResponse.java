package JavaL5.chatApp.dto.app;


import JavaL5.chatApp.Model.App;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InspectAppResponse {

    private App app;

}
