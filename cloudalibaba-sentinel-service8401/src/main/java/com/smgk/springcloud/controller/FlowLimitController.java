package com.smgk.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.smgk.springcloud.handle.MyBlockHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "testA-----";
    }
    @GetMapping("/testA2")
    public String testATwo(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testATwo-----";
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB   -----";
    }

    @GetMapping("/testBTwo")
    public String testBTwo(){
        log.error(Thread.currentThread().getName() + " --》 进入");
        return "testBTwo   -----";
    }
    /*
        要注意，这样只是对浏览进行监控处理，并没有处理异常，千万不要搞错
     */
    @GetMapping("/tetsHotKey")
    @SentinelResource(value = "tetsHotKey", blockHandler = "dealTestHotKey")//注意 value 与配置页面中的资源名保持一至
    public String tetsHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        return "testHokey 热点监控 ： " + p1;
    }

    public String dealTestHotKey(String p1, String p2, BlockException be){
        String retuStr = "dealTestHotKey 热点监控 ： "+ p1;
        log.info(retuStr);
        return retuStr;
    }


    /**
     * blockHandlerClass 指定处理超时的类
     * blockHandler 类中的方法
     * 这里不仅仅会对流控进行处理，如果配置了降级，出了异常也会处理
     * @param id
     * @return
     */
    @GetMapping(value = "/testResource")
    @SentinelResource(value = "testResource", blockHandlerClass = MyBlockHandle.class, blockHandler = "testResource")
    public String testResource(@RequestParam (value = "id", required = false) Long id){
        if (id == 5){
            throw new RuntimeException("非常参数");
        }
        return "testResource --> " + id;
    }











}