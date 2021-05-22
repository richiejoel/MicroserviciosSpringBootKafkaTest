package com.heavy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class ConfigBroker {
	
	@Bean
	public NewTopic payEvent() {
		return TopicBuilder.name("transaction-events")
				.partitions(3)
				.replicas(1)
				.build();
	}

}
