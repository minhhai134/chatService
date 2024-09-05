package JavaL5.chatApp.dto.channel;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateChannelRequest {

    @NotEmpty
    private String channelName;

    @NotEmpty
    private String appId;

    @NotEmpty
    private String clientChannelId;

}
