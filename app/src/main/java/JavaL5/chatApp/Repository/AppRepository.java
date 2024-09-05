package JavaL5.chatApp.Repository;

import JavaL5.chatApp.Model.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App,String> {

    App findByAppApiKey(String appApiKey);
}
