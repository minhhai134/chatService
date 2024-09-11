package JavaL5.chatApp.service;

import JavaL5.chatApp.model.App;
import JavaL5.chatApp.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImp implements AppService {
    @Autowired
    private AppRepository appRepository;

    @Override
    public App getAppByAppApiKey(String appApiKey) {
        return appRepository.findByAppApiKey(appApiKey);
    }
}
