package JavaL5.chatApp.service;

import JavaL5.chatApp.model.App;
import JavaL5.chatApp.model.Channel;
import JavaL5.chatApp.repository.ChannelRepository;
import JavaL5.chatApp.dto.channel.CreateChannelRequest;
import JavaL5.chatApp.exception.ChannelExistedException;
import JavaL5.chatApp.exception.ChannelNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
@Slf4j
public class ChannelServiceImp implements ChannelService {

    private static final int REQUEST_LIMIT = 2;
    private static final int TIME_WINDOW = 1;

    @Autowired
    private ChannelRepository channelRepository;

    /*
    Su dung tam thoi truoc khi trien khai AOP
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Channel createChannel(App app, CreateChannelRequest request) {
//         if(!checkLimit(app,TIME_WINDOW)) return null;

         if(channelRepository.findByAppIdAndClientChannelId(app.getId(), request.getClientChannelId())
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

    @Override
    public boolean checkLimit(App app, int timeWindow) {
        String api_key = app.getAppApiKey();
        for(int i=1;i<=REQUEST_LIMIT;i++){
            String key = String.format("%s:%d",api_key,i);
            if(redisTemplate.getExpire(key)<0) {
                redisTemplate.opsForValue().set(key, key, Duration.ofSeconds(timeWindow));
                log.info("Redis - Request - {}", i);
                return true;
            }

        }
        log.info("Limit");
        return false;

//        redisTemplate.opsForValue().set(api_key,api_key,Duration.ofSeconds(60));
//        String str = redisTemplate.opsForValue().get(api_key).toString();


    }


}
