package com.ugrade.springbootstarter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
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

import com.upgrade.springbootstarter.dao.CourseRepository;
import com.upgrade.springbootstarter.model.Course;
import com.upgrade.springbootstarter.model.Topic;
import com.upgrade.springbootstarter.service.CourseService;

@RunWith(SpringRunner.class)
public class CourseServiceTest {

	@TestConfiguration
	static class CourseServiceTestContextConfiuration {

		@Bean
		public CourseService courseService() {
			return new CourseService();
		}
	}

	@Autowired
	private CourseService courseService;

	@MockBean
	private CourseRepository courseRepository;

	@Before
	public void setUp() {
		Course javaStreams = new Course();
		javaStreams.setId(2);
		javaStreams.setName("Java Streams");
		javaStreams.setDescription("Java Streams Description");
		javaStreams.setTopic(new Topic(1, "", ""));

		List<Course> courseList = new ArrayList<Course>();
		courseList.add(javaStreams);

		Mockito.when(courseRepository.save(javaStreams)).thenReturn(javaStreams);
		Mockito.when(courseRepository.findByTopicId(javaStreams.getTopic().getId())).thenReturn(courseList);
		Mockito.when(courseRepository.findById(javaStreams.getId())).thenReturn(Optional.of(javaStreams));
	}

	@Test
	public void whenGetAllCoursesForATopicId_ifTopicIdExist_returnCourseList() {
		int topicId = 1;
		List<Course> found = courseService.getAllCourses(topicId);

		assertThat(1).isSameAs(found.size());
	}

	@Test
	public void whenGetAllCoursesForATopicId_ifTopicIdNotExist_returnNull() {

	}

	@Test
	public void whenGetCourseById_ifCourseIdExist_returnCourse() {
		int courseId = 2;
		Course found = courseService.getCourse(courseId);

		assertThat(courseId, is(found.getId()));
	}

	@Test
	public void whenGetCourseById_ifCourseIdNotExist_returnNull() {
		
	}

}
