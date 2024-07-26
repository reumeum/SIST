package kr.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProducer {
	private final static Logger logger = LoggerFactory.getLogger(SimpleProducer.class);
	//프로듀서가 생성한 데이터를 보낼 토픽 지정
	private final static String TOPIC_NAME = "test";
	//전송하고자 하는 카프카 클러스터 서버의 host와 ip를 지정
	private final static String BOOTSTRAP_SERVERS = "192.168.10.75:9092";
	
	public static void main(String[] args) {
		//Properties에는 KafkaProducer 인스턴스를 생성하기 위한 프로듀서 옵션들을
		//key/value로 선언
		Properties configs = new Properties();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		//String 객체를 전송하기 위해 String을 직렬화하는 클래스인 카프카 라이브러리의
		//StringSerializer를 사용
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		//Properties를 KafkaProducer의 생성 파라미터로 추가하여 인스턴스 생성
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);
		//토픽에 저장할 데이터
		String messageValue = "testMessage";
		//카프카 브로커로 데이터를 보내게 위해 ProducerRecord를 생성
		//메시지 키는 따로 선언하지 않으므로 null로 설정되어 전송
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC_NAME, messageValue);
		
		producer.send(record);
		logger.info("{}", record);
		
		producer.flush();
		producer.close();
		
	}
}
