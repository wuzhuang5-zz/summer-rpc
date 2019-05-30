package com.summer.config;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class ServiceConfig<T> implements Serializable {
    private static final long serialVersionUID = -8517668931657103588L;
    /**
     * 标记方式是否已暴露
     */
    private AtomicBoolean exported = new AtomicBoolean(false);
    /**
     * 暴露服务
     */
    public synchronized void export(){
        if(exported.get()) {
//            log.info("%s has already been expoted, so ignore the export request!\", Interface.class);
        }
    }
}
