package JavaL5.chatApp.Service;


import JavaL5.chatApp.Model.Channel;
import JavaL5.chatApp.dto.channel.CreateChannelRequest;
import org.springframework.stereotype.Service;

@Service
public interface ChannelService {

    Channel createChannel(CreateChannelRequest request);

    Channel getChannelById(String id);

    Channel getChannelByReferenceID(String refId);
}
