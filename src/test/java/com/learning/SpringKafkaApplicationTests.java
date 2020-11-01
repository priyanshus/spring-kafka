package com.learning;

import com.learning.service.KafkaConsumerService;
import com.learning.service.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringKafkaApplicationTests {

	@Autowired
	KafkaProducerService producerService;


	@Autowired
	KafkaConsumerService consumerService;
}
