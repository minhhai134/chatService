package JavaL5.chatApp.Repository;

import JavaL5.chatApp.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends JpaRepository<Message,String> {
}
