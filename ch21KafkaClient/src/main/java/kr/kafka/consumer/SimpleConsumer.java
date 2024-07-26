package kr.kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleConsumer {
	private final static Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);
	private final static String TOPIC_NAME = "test";
	private final static String BOOTSTRAP_SERVERS = "192.168.10.75:9092";
	
	/*
	 * 컨슈머 그룹 이름 선언.
	 * 컨슈머 그룹을 통해 컨슈머의 목적을 구분
	 */
	private final static String GROUP_ID = "test-group";
	
	public static void main(String[] args) {
		//Properties에는 KafkaProducer 인스턴스를 생성하기 위한 프로듀서 옵션들을
		//key/value로 선언
		Properties configs = new Properties();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		//String 객체를 전송하기 위해 String을 직렬화하는 클래스인 카프카 라이브러리의
		//StringSerializer를 사용
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs);
		consumer.subscribe(Arrays.asList(TOPIC_NAME));
		
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
			for (ConsumerRecord<String, String> record : records) {
				logger.info("{}", record);
			}
		}
		
		
	}
}
