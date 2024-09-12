package JavaL5.chatApp.service;

import JavaL5.chatApp.dto.message.SendMessageRequest;
import JavaL5.chatApp.exception.UserNotFoundException;
import JavaL5.chatApp.model.App;
import JavaL5.chatApp.model.Message;
import JavaL5.chatApp.model.User;
import JavaL5.chatApp.repository.ChannelRepository;
import JavaL5.chatApp.repository.MessageRepository;
import JavaL5.chatApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public Message sendMessage(App app, String channelId, SendMessageRequest request) {
//        log.info("{} ---", request.getClientUserId());
        User user = userRepository.findByAppIdAndClientUserId(app.getId(),request.getClientUserId())
                .orElseThrow(()-> new UserNotFoundException());
//        log.info("{} ---", channelRepository.getReferenceById(channelId));
        Message message = messageRepository.save(Message.builder().
                channel(channelRepository.getReferenceById(channelId)).
                user(user).
                message(request.getMessage()).
                sentTime(Instant.now()).
                build());

        return message;
    }
}
