package com.jfz.kafka;

import com.jfz.kafka.provider.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

		Sender sender = context.getBean(Sender.class);
		for(int i =0;i<10;i++){
			sender.send();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("/")
	public String home(){
		return "welcome home";
	}
}
