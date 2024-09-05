package JavaL5.chatApp.dto.channel;


import JavaL5.chatApp.Model.Channel;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateChannelResponse {

    @NotEmpty
    private Channel channel;


}
