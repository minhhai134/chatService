package JavaL5.chatApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Slf4j
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "appId", nullable = false)
    @JsonIgnore
    private App app;

    private String clientUserId;

    private String userName;
}
