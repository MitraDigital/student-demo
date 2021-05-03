package com.mitrai.studentDemo.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mitrai.studentDemo.entity.Student;

@Service
public class ProducerService {
	
	
	@Autowired
	private KafkaTemplate<String, messageModel> kafkaTemplate;
	private final String TOPIC = "studentInsert";
	
	public void addStudentSync(Student data) {
		messageModel msg = new messageModel (data.getStudentId(), data.getName(), data.getScore());
		kafkaTemplate.send(TOPIC, msg);
	}

}
