package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);


    @JmsListener(destination = "inbox", containerFactory = "myFactory")
    @SendTo("outbox")
    public String receiveMessage(String message) throws InterruptedException {
        logger.info("Received: " + message);
        Thread.sleep(100);
        String response = message.toUpperCase();
        logger.info("Responding with: " + response);
        return response;
    }

}
