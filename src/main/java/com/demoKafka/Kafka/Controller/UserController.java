package com.demoKafka.Kafka.Controller;

import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoKafka.Kafka.Model.JsonMessenger;

@RestController
@RequestMapping("/mess")
public class UserController {

	@Autowired
	private KafkaTemplate<String, JsonMessenger> kafka;
	String TOPIC_NAME = "items-topic";

	@GetMapping("/{sendmess}")
	public String sendMess(@PathVariable("sendmess") String sendmess) {

		String UID = UUID.randomUUID().toString();

		JsonMessenger messenger = new JsonMessenger();
		messenger.setId(UID);
		messenger.setMess(sendmess);
		messenger.setTimesend(new Date());

		kafka.send(TOPIC_NAME, messenger);
		return "Send : " + sendmess;

	}

	@KafkaListener(topics = "items-topic", groupId = "group-id")
	public void listen(String mess) {
		System.out.println("Mess: " + mess);
	}
}
