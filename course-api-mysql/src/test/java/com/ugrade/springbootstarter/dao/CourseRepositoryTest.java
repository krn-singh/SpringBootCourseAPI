package com.ugrade.springbootstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.upgrade.springbootstarter.dao.CourseRepository;
import com.upgrade.springbootstarter.model.Course;
import com.upgrade.springbootstarter.model.Topic;

@RunWith(SpringRunner.class)	//provide a bridge between Spring Boot test features and JUnit
@DataJpaTest
public class CourseRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void findByTopicId_returnCourseList() {
		
		Topic topic = new Topic();
		
		Course javaStreams = new Course();
		javaStreams.setName("Java Streams");
		javaStreams.setDescription("Java Streams Description");
		javaStreams.setTopic(topic);
		
		entityManager.persist(topic);
		entityManager.persist(javaStreams);
		entityManager.flush();
		
		List<Course> found = courseRepository.findByTopicId(topic.getId());
		
		assertThat(1, is(found.size()));
	}

}
