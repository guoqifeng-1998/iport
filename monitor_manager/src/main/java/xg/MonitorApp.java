package xg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600*24)
@MapperScan("xg.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class MonitorApp {
    public static void main(String[] args) {
        SpringApplication.run(MonitorApp.class);
    }

    @Bean//目的是告诉spring,要扫描带有@ServerEndpoint注解的类
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
