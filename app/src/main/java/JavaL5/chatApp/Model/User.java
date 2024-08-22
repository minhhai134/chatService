package JavaL5.chatApp.Model;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "user")
//@Slf4j
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

//    public User() {
//    }
//
//    public User(Integer id) {
//        this.id = id;
//    }

    public Integer getId() {
        return id;
    }
}
