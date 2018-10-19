package com.jfz.kafka.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/22 15:24
 */
@Component
@Slf4j
public class Receiver {

    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"shengyuanzhou"})
    private void listen(ConsumerRecord<?,?> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            log.info("receive record : "+gson.toJson(record));
            log.info("receive message : "+gson.toJson(message));
        }
    }
}
