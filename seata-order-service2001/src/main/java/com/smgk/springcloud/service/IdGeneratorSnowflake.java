package com.smgk.springcloud.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class IdGeneratorSnowflake {
    private long workerId = 0;//@param workerId 终端ID
    private long datacenterId = 1;//数据中心ID
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    /**
     * 初始化参数
     */
    @PostConstruct
    public void init() {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId:{}", workerId);
        } catch (Exception e) {
            log.info("当前机器的workerId获取失败", e);
            workerId = NetUtil.getLocalhostStr().hashCode();//如果失败了就获取本地的
            log.info("当前机器 workId:{}", workerId);
        }
    }

    /**
     * 生成id方法
     * @return
     */
    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    /**
     * 可以根据新的 workerId 和 datacenterId生成新的对象
     * @param workerId
     * @param datacenterId
     * @return
     */
    public synchronized long snowflakeId(long workerId, long datacenterId) {
        snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    /*public static void main(String[] args) {
        // 1236610764324864000
        System.out.println(new IdGeneratorSnowflake().snowflakeId());
    }*/

}
