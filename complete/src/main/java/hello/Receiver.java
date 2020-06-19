package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "inbox", containerFactory = "myFactory")
	@SendTo("outbox")
	public String receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		return message.toUpperCase();
	}

}
