package com.example.start2.courses;


import com.example.start2.topic.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;
    @RequestMapping("/topics/{tId}/courses")
    public List<Course> getAllCourses(@PathVariable String tId) {


        return coursesService.getAllCourses(tId);
    }

    @RequestMapping("/topics/{topicid}/courses/{id}")
    public Course getCourse(@PathVariable String id ){

        return coursesService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course ,@PathVariable String topicId ){
        course.setTopics(new Topics(topicId ,"",""));
        coursesService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicid}/courses/{id}")
    public void upfateopics(@RequestBody Course course ,@PathVariable String topicId, @PathVariable String  id ){
        course.setTopics(new Topics(topicId ,"",""));
        coursesService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicid}/courses/{id}")
    public void deleteCourse(@PathVariable String id ){
        coursesService.deleteCourse(id);
    }

}
