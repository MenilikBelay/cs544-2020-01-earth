package com.cs544.integration;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveCheckStatusMessage {

	@JmsListener(destination = "WebServiceStatus")
	public void receivePasswordMessage(String msg)
	{
		System.out.println("Recevied: "+msg);
	}
}
