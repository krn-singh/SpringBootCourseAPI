package com.ugrade.springbootstarter.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.upgrade.springbootstarter.dao.TopicRepository;
import com.upgrade.springbootstarter.model.Topic;
import com.upgrade.springbootstarter.service.TopicService;

@RunWith(SpringRunner.class) // provide a bridge between Spring Boot test features and JUnit
public class TopicServiceTest {

	@TestConfiguration
	static class TopicServiceTestContextConfiguration {

		@Bean
		public TopicService topicService() {
			return new TopicService();
		}
	}

	@Autowired
	private TopicService topicService;

	@MockBean
	private TopicRepository topicRepository;

	@Before
	public void setUp() {
		Topic java = new Topic();
		java.setId(1);
		java.setName("java");
		java.setDescription("Java Description");

		List<Topic> topicList = new ArrayList<Topic>();
		topicList.add(java);

		Mockito.when(topicRepository.save(java)).thenReturn(java);
		Mockito.when(topicRepository.findAll()).thenReturn(topicList);
		Mockito.when(topicRepository.findById(java.getId())).thenReturn(Optional.of(java));
		Mockito.when(topicRepository.findById(0)).thenThrow(new NullPointerException());
	}

	@Test
	public void whenGetAllTopics_returnTopicList() {
		List<Topic> found = topicService.getAllTopics();
		
		assertThat(1, is(found.size()));
	}
	
	@Test
	public void whenGetTopicById_ifTopicExist_returnTopic() {
		int topicId = 1;
		Topic found = topicService.getTopic(topicId);
		
		assertThat(topicId, is(found.getId()));
	}
	
	@Test(expected = NullPointerException.class)
	public void whenGetTopicById_ifTopicNotExist_returnNull() {
		int topicId = 0;
		Topic found = topicService.getTopic(topicId);		
	}
}
