package com.ugrade.springbootstarter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upgrade.springbootstarter.model.Course;

//This will be AUTO IMPLEMENTED by Spring into a Bean called TopicRepository
//CRUD refers Create, Read, Update, Delete

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

	public List<Course> findByTopicId(int topicId);
}
