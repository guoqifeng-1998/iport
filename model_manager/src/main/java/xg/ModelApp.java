package xg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600*24)
@MapperScan({"xg.dao","xg.utils"})
@SpringBootApplication
@EnableDiscoveryClient
public class ModelApp {
    public static void main(String[] args) {
        SpringApplication.run(ModelApp.class);
    }
}
