package JavaL5.chatApp.controller;

import JavaL5.chatApp.dto.message.SendMessageRequest;
import JavaL5.chatApp.dto.message.SendMessageResponse;
import JavaL5.chatApp.model.Message;
import JavaL5.chatApp.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/messages")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/{channelId}")
    public ResponseEntity<SendMessageResponse> sendMessage(@PathVariable String channelId,
            @Valid @RequestBody SendMessageRequest request){

        Message message = messageService.sendMessage(getAuthenticatedApp(),channelId,request);

        return ResponseEntity.ok(SendMessageResponse.builder().message(message).build());
    }
}
