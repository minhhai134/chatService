package JavaL5.chatApp.service;


import JavaL5.chatApp.model.App;
import JavaL5.chatApp.model.Channel;
import JavaL5.chatApp.dto.channel.CreateChannelRequest;
import org.springframework.stereotype.Service;

@Service
public interface ChannelService {

    Channel createChannel(App app, CreateChannelRequest request);

    Channel getChannelById(String id);

    Channel getChannelByReferenceID(String refId);

    boolean checkLimit(App app, int timeWindow);
}
