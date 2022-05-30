package com.demoKafka.Kafka.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.demoKafka.Kafka.Model.JsonMessenger;

@Configuration
public class KafkaConsConfig {
	// Consumer_Config
	@Bean
	public ConsumerFactory<String, JsonMessenger> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerconfig());
	}

	@Bean
	public Map<String, Object> consumerconfig() {
		Map<String, Object> cons = new HashMap<>();
		cons.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		cons.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
		cons.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		cons.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		cons.put(JsonDeserializer.VALUE_DEFAULT_TYPE, JsonMessenger.class);
		return cons;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, JsonMessenger> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, JsonMessenger> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
