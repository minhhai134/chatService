package JavaL5.chatApp.Service;

import org.springframework.stereotype.Service;

@Service
public interface DistributedLockBookingService {

    public void distributedLockBooking(int userID, int roomID);
}
