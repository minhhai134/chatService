package JavaL5.chatApp.Service;

import JavaL5.chatApp.Model.Booking;
import JavaL5.chatApp.Model.Room;
import JavaL5.chatApp.Repository.BookingRepository;
import JavaL5.chatApp.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class DistributedLockBookingServiceImp implements DistributedLockBookingService {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;
    @Autowired
    private BookingRepository bkRepo;

    @Autowired
    private RoomRepository roomRepo;


    @Override
    public void distributedLockBooking(int userID, int roomID) {
          String key = String.format("abcde",roomID);
          boolean availableBooking = template.opsForValue().setIfAbsent(key,userID);
          log.info("key: {} - A:{}- {}",key,availableBooking, template.opsForValue().get(key));
          if(availableBooking){
              Room room = roomRepo.findByIdAndAvailable(roomID,true);
              if(Objects.isNull(room)){
                  log.info("Room {} not available",roomID);
              }
              else{
                  roomRepo.setRoomStatus(roomID,false);
                  bkRepo.save(new Booking(roomID,userID));
                  log.info("Room {} booked by user {}",roomID, userID);
              }


          }
        log.info("{} - {}", template.opsForValue().get(key), template.opsForValue().get("mykey") );

//        template.opsForValue().getAndDelete(key);

    }
}
