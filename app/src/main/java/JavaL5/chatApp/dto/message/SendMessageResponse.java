package JavaL5.chatApp.dto.message;

import JavaL5.chatApp.model.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMessageResponse {
    private Message message;
}
