package JavaL5.chatApp.Model;


import jakarta.persistence.*;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public Booking(int roomID, int userID) {
        this.roomID = roomID;
        this.userID = userID;
    }

    private int roomID;
    private int userID;
}
