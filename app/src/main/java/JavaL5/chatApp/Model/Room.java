package JavaL5.chatApp.Model;


import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private boolean available = true;
}
