package com.ugrade.springbootstarter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upgrade.springbootstarter.model.Topic;

//This will be AUTO IMPLEMENTED by Spring into a Bean called TopicRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
