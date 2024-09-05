package JavaL5.chatApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Entity
@Table(name = "Message")
@AllArgsConstructor
@Data
@Builder
@Slf4j
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String messageId;

    private String channelId;

    private String userId;

    private int serialNumber;

    private String content;

    private Date sentTime;
}
