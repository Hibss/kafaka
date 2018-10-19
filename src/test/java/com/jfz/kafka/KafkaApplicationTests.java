package com.jfz.kafka;

import com.jfz.kafka.bean.Message;
import com.jfz.kafka.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

	@Autowired
	private Sender sender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSendMessage(){
		for(int i = 0;i<10;i++){
			Message message = Message.builder()
					.id(System.currentTimeMillis())
					.sendTime(new Date())
					.msg("timeCount:"+i)
					.build();
			sender.send(message);
		}
	}
}
