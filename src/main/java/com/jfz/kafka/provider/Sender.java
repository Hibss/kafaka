package com.jfz.kafka.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfz.kafka.bean.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/22 15:17
 */
@Component
@Slf4j
public class Sender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(){
        Message message = Message.builder().id(System.currentTimeMillis()).msg("测试测试").sendTime(new Date()).build();
        log.info("send message"+gson.toJson(message));
        kafkaTemplate.send("shengyuanzhou",gson.toJson(message));
    }

    public void send(Message message){
        log.info("send message"+gson.toJson(message));
        kafkaTemplate.send("shengyuanzhou",gson.toJson(message));
    }
}
