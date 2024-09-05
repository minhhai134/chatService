package JavaL5.chatApp.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "App")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Slf4j
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String appId;

    private String clientAppId;

    private String appName;

    @Column(name = "appApiKey", unique = true)
    private String appApiKey;
}
