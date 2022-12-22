package com.example.start2.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CoursesRepository extends CrudRepository<Course, String> {


    public List<Course> findByTopicsId(String topicsId);



}
