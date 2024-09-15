package JavaL5.chatApp;


import JavaL5.chatApp.controller.ChannelController;
import JavaL5.chatApp.dto.channel.CreateChannelRequest;
import JavaL5.chatApp.model.App;
import JavaL5.chatApp.repository.AppRepository;
import JavaL5.chatApp.service.ChannelService;
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

@SpringBootApplication
@Slf4j
public class AppApplication {

	private  static final int TRANSACTIONS_PER_MACHINE = 20;
	public static class Client implements Runnable{
		private App app;
		private ChannelService service;

		private int channelClientId;



		public Client(App app, ChannelService service,int id){
			this.app = app;
			this.service = service;
			this.channelClientId = id;
			log.info("ID - {}", id);
		}

		@Override
		public void run() {
//			String url = "http://localhost:8081/api/channels/create";
//			String request_body =
			CreateChannelRequest request = CreateChannelRequest.builder().
                    channelName(String.valueOf(channelClientId)).
					clientChannelId(String.valueOf(channelClientId)).
					build();
			service.createChannel(app,request);
		}
	}


	public static void main(String[] args) throws InterruptedException {



		ApplicationContext context = SpringApplication.run(AppApplication.class, args);

//		App app = context.getBean(App.class);

		AppRepository appRepository = context.getBean(AppRepository.class);
		ChannelController channelController = context.getBean(ChannelController.class);

		ChannelService service = context.getBean(ChannelService.class);

		App app = appRepository.save(App.builder().appName("App1").appApiKey("engineer-pro-key").build());

//
//		for (int i = 1; i <= TRANSACTIONS_PER_MACHINE; i++) {
//			CreateChannelRequest request = CreateChannelRequest.builder().
//					channelName(String.valueOf(i)).
//					clientChannelId(String.valueOf(i)).
//					build();
//			service.createChannel(app,request);
//			Thread.sleep(300);
//		}




	}

}
