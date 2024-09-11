package JavaL5.chatApp.repository;

import JavaL5.chatApp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends JpaRepository<Message,String> {
}
