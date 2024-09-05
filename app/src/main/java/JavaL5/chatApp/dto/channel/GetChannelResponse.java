package JavaL5.chatApp.dto.channel;


import JavaL5.chatApp.Model.Channel;
import JavaL5.chatApp.Service.ChannelService;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetChannelResponse {
     private Channel channel;
}
