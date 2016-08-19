package com.lovecws.spring.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

import com.lovecws.spring.activemq.entity.PhoneNoticeInfo;
import com.lovecws.spring.activemq.queue.QueueSender;
import com.lovecws.spring.activemq.topic.TopicSender;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:activemq*.xml");
		applicationContext.start();

		QueueSender queueSender = applicationContext.getBean(QueueSender.class);
		TopicSender topicSender = applicationContext.getBean(TopicSender.class);
		for (int i = 0; i < 10; i++) {
			queueSender.send("lganQueue", new PhoneNoticeInfo("lovecws", "hahha", "cws", "15330061450"));
			topicSender.send("lganTopic", "lganTopic lovecws");
		}

		applicationContext.close();
		
	}
}
