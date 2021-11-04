package xg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyCfg implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor l;
    public void addInterceptors(InterceptorRegistry r) {
        r.addInterceptor(l).addPathPatterns("/**").
                excludePathPatterns("/**/login","/showIndex");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/showIndex").setViewName("index");
    }
}
