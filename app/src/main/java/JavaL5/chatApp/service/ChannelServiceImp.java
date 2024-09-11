package JavaL5.chatApp.service;

import JavaL5.chatApp.model.App;
import JavaL5.chatApp.model.Channel;
import JavaL5.chatApp.repository.ChannelRepository;
import JavaL5.chatApp.dto.channel.CreateChannelRequest;
import JavaL5.chatApp.exception.ChannelExistedException;
import JavaL5.chatApp.exception.ChannelNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ChannelServiceImp implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public Channel createChannel(App app, CreateChannelRequest request) {

         if(channelRepository.findByAppIdAndClientChannelId(app.getAppId(), request.getClientChannelId())
                 .isPresent()){
             throw new ChannelExistedException();
         }

         Channel channel = Channel.builder()
                 .channelName(request.getChannelName())
                 .clientChannelId(request.getClientChannelId())
                 .build();

         Channel savedChannel = channelRepository.save(channel);

         return savedChannel;
    }

    @Override
    public Channel getChannelById(String id) {
        Optional<Channel> channel = channelRepository.findById(id);
        if(channel.isPresent()){ return  channel.get(); }
        else throw new  ChannelNotFoundException();
    }

    @Override
    public Channel getChannelByReferenceID(String refId) {
        return null;
    }
}
