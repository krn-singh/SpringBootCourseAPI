package com.upgrade.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugrade.springbootstarter.repository.CourseRepository;
import com.upgrade.springbootstarter.model.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(int id) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(int id) {
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(int id, Course newCourse) {
		courseRepository.save(newCourse);
	}
	
	public void removeCourse(int id) {
		courseRepository.deleteById(id);
	}	
}
