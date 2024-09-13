package JavaL5.chatApp;


import JavaL5.chatApp.controller.ChannelController;
import JavaL5.chatApp.model.App;
import JavaL5.chatApp.repository.AppRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import static org.springframework.web.reactive.function.BodyInserters.fromFormData;
//exclude = {DataSourceAutoConfiguration.class }


// **********************  CHAT SERVICE  *******************************
@Slf4j
@SpringBootApplication
public class AppApplication {


	public static void main(String[] args) throws InterruptedException {


		ApplicationContext context = SpringApplication.run(AppApplication.class, args);

//		App app = context.getBean(App.class);

		AppRepository appRepository = context.getBean(AppRepository.class);
		ChannelController channelController = context.getBean(ChannelController.class);

		App app = appRepository.save(App.builder().appName("App1").appApiKey("engineer-pro-key").build());


//		User user = userRepo.save(new User());
//
//		System.out.println("User vừa lưu có ID: " + user.getId());
	}

}
