package JavaL5.chatApp.service;

import JavaL5.chatApp.dto.message.SendMessageRequest;
import JavaL5.chatApp.model.App;
import JavaL5.chatApp.model.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    Message sendMessage(App app, String channelId, SendMessageRequest request);
}
