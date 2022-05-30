
package com.demoKafka.Kafka.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.demoKafka.Kafka.Model.JsonMessenger;
import org.apache.kafka.common.serialization.*;

@Configuration
public class KafkaProsConfig {

	@Bean
	public ProducerFactory<String, JsonMessenger> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	// Producer_Config
	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return config;
	}

	@Bean
	public KafkaTemplate<String, JsonMessenger> kafkaTemplate() {
		return new KafkaTemplate<String, JsonMessenger>(producerFactory());
	}
}
