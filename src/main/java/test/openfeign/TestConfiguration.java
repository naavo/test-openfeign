package test.openfeign;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import test.openfeign.client.DummyClient;

@Configuration
@EnableFeignClients(clients= {DummyClient.class})
@EnableAutoConfiguration
public class TestConfiguration {

}
