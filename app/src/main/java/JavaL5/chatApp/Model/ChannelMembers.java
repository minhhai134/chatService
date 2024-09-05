package JavaL5.chatApp.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Entity
@Table(name = "ChannelMembers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Slf4j
public class ChannelMembers {

    private String channelId;

    private String userId;

    private Date lastSeen;
}
