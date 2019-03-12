package com.upgrade.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrade.springbootstarter.repository.TopicRepository;
import com.upgrade.springbootstarter.model.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(int id) {
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(int id, Topic newTopic) {
		topicRepository.save(newTopic);
	}
	
	public void removeTopic(int id) {
		topicRepository.deleteById(id);
	}	
}
