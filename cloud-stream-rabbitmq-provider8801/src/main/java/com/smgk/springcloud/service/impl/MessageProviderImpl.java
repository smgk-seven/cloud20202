package com.smgk.springcloud.service.impl;

import com.smgk.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * 消息的发送者实现类，
 * 记得 生产者一定要加EnableBinding(Source.class
 * Source 注明是生产者
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    /**
     * 消息发送
     *
     * @return
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial = " + serial);
        return serial;
    }
}
