package JavaL5.chatApp.config;


import JavaL5.chatApp.Common.AuthenticationFilter;
import JavaL5.chatApp.Service.AppService;
import JavaL5.chatApp.Service.AppServiceImp;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> loggingFilter(AppService appService){
        // 10h51 PM 9/9
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthenticationFilter(appService));
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

}
