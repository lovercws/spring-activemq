package com.lovecws.spring.activemq;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Demo {

	public static void main(String[] args) {
		receiveMessage();
	}

	public static void sendMessage() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
				"failover:(tcp://192.168.16.129:61616)");
		try {
			Connection connection = activeMQConnectionFactory.createConnection();

			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

			Queue queue = session.createQueue("lgan");

			MessageProducer producer = session.createProducer(queue);

			TextMessage message = session.createTextMessage("lovecws");

			producer.send(message);

			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void receiveMessage() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
				"failover:(tcp://192.168.16.129:61616)");
		try {
			Connection connection = activeMQConnectionFactory.createConnection();

			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

			Queue queue = session.createQueue("lgan");
			MessageConsumer consumer = session.createConsumer(queue);
			Message message = consumer.receive();

			if (message != null) {
				Serializable object = ((ObjectMessage) message).getObject();
				System.out.println(object);
			} else {
				System.out.println("message not found");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
