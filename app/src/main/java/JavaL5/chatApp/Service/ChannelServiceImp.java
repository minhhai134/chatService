package JavaL5.chatApp.Service;

import JavaL5.chatApp.Model.Channel;
import JavaL5.chatApp.Repository.ChannelRepository;
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
    public Channel createChannel(CreateChannelRequest request) {

         if(channelRepository.findByAppIdAndClientChannelId(request.getAppId(),
                 request.getClientChannelId()).isPresent()){
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
