package com.jmh.streamhello.reciver;

/**
 * @author by jiangmenghui
 * @version [版本号, 2019/4/4]
 * @Classname SinkReceiver
 * @Description TODO
 * @Date 2019/4/4
 */

import com.jmh.streamhello.StreamHelloApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplication.class);
    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received: " + payload);
    }
}
