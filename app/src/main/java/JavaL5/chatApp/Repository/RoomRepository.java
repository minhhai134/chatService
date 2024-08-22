package JavaL5.chatApp.Repository;

import JavaL5.chatApp.Model.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    Room findByIdAndAvailable(int roomID, boolean available);

    @Transactional
    @Modifying
    @Query("update Room set available = :status where id = :id")
    void setRoomStatus(@Param(value="id") int roomID, @Param(value="status") boolean status);



}
