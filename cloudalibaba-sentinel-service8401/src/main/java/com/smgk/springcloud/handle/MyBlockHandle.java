package com.smgk.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandle {

    public static String testResource(Long id, BlockException be) {
        return "MyBlockHandle--> testResource -->" + id;
    }
}
