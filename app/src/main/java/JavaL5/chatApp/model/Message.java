package JavaL5.chatApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.Instant;

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

    /*
    Khong dung String channelId, String userId
    -> Thay vao do dung cac anotation sau
     */
    @ManyToOne
    @JoinColumn(name = "channelId", nullable = false)
    @JsonIgnore()
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore()
    private User user;


    /*
    STT cua tin nhan trong cuoc tro chuyen
     */
//  private int serialNumber; -> Thu dung cach khac

    private String message;

    /*
    Su dung @CreationTimesStamp va Instant type
     */
    @CreationTimestamp
    private Instant sentTime;
}
