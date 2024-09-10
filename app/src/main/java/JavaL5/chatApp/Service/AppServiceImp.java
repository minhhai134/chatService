package JavaL5.chatApp.Service;

import JavaL5.chatApp.Model.App;
import JavaL5.chatApp.Repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.desktop.AppReopenedEvent;

@Service
public class AppServiceImp implements AppService {
    @Autowired
    private AppRepository appRepository;

    @Override
    public App getAppByAppApiKey(String appApiKey) {
        return appRepository.findByAppApiKey(appApiKey);
    }
}
