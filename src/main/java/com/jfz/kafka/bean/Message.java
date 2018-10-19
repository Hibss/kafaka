package com.jfz.kafka.bean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/22 15:16
 */
@Data
@Builder
public class Message {
    private Long id;
    private String msg;
    private Date sendTime;
}
