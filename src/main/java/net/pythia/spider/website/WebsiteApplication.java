package net.pythia.spider.website;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }
}
