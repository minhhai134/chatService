package JavaL5.chatApp;

import JavaL5.chatApp.Model.Room;
import JavaL5.chatApp.Repository.RoomRepository;
import JavaL5.chatApp.Service.*;
import JavaL5.chatApp.Repository.UserRepository;
import JavaL5.chatApp.Service.DistributedLockBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromFormData;
//exclude = {DataSourceAutoConfiguration.class }


// **********************  CHAT SERVICE  *******************************
@Slf4j
@SpringBootApplication
public class AppApplication {

	private static int ROOM_QUANTITY = 1;
	private static int USER_QUANTITY = 10;

	private static int THREAD_QUANTITY = 1;
	// Neu de so thread la 10 se gay ra van de Timeout

	public static class RequestThread implements Runnable{

		//@Autowired -> Vi sao lai null?

		private int userID;
		private int roomID;

		private DistributedLockBookingService service;


		public RequestThread(DistributedLockBookingService service, int userID, int roomID) {
			this.userID = userID;
            this.roomID = roomID;
			this.service = service;

		}

		@Override
		public void run() {

			WebClient client = WebClient.create("http://localhost:8081");
//			WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.post();
//			WebClient.RequestBodySpec bodySpec = uriSpec.uri("http://localhost:8081/booking/pessimisticLockingBook");

//			client.post()
//					.uri("/booking/pessimisticLockingBook")
//					.body(fromFormData("roomID", String.valueOf(roomID)).with("userID", String.valueOf(userID)))
//					.retrieve()
//			;
			log.info("thread run, userID ={}", userID);
//			for(int i=1; i<=10;i++){ service.receivedRequest(userID);}
			service.distributedLockBooking(userID,roomID);


		}
	}


	public static void main(String[] args) throws InterruptedException {


		ApplicationContext context = SpringApplication.run(AppApplication.class, args);


		UserRepository userRepo = context.getBean(UserRepository.class);
		DistributedLockBookingService service = context.getBean(DistributedLockBookingService.class);
		RoomRepository roomRepo = context.getBean(RoomRepository.class);

		for(int i=1; i<=ROOM_QUANTITY;i++){
			roomRepo.save(new Room());
		}
//
//		for(int i=1; i<=USER_QUANTITY;i++){
//			userRepo.save(new User());
//		}

		List<Thread> allThreads = new ArrayList<>();
		for(int i=1; i<=THREAD_QUANTITY;i++){
			Thread thread = new Thread(new RequestThread(service,i,1));
			thread.start();
			allThreads.add(thread);

		}

		for(Thread t: allThreads){
			t.join();
		}


		log.info("end");





//		User user = userRepo.save(new User());
//
//		System.out.println("User vừa lưu có ID: " + user.getId());
	}

}
