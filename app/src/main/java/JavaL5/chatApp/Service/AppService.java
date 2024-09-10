package JavaL5.chatApp.Service;


import JavaL5.chatApp.Model.App;
import JavaL5.chatApp.Repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AppService {

    public App getAppByAppApiKey(String appApiKey);



}
