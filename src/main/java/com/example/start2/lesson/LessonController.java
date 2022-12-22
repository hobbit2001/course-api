package com.example.start2.lesson;


import com.example.start2.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService topicService;
    @RequestMapping("/topics/{tid}/courses/{id}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String id) {


        return topicService.getAllLessons(id);
    }

    @RequestMapping("/topics/{topicid}/courses/{cid}/lessons/{s}")
    public Lesson getLesson(@PathVariable String s){

        return topicService.getLesson(s);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}/courses/{cid}/lessons")
    public void addLesson(@RequestBody Lesson lessons ,@PathVariable String cid ,@PathVariable String topicId ){
        lessons.setCourse(new Course(cid ,"" , "" , topicId));
        topicService.addLesson(lessons);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}/courses/{cid}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lessons , @PathVariable String id,@PathVariable String cid ,@PathVariable String topicId  ){
        lessons.setCourse(new Course(cid ,"" , "" , topicId));
        topicService.updateLesson(lessons);
    }

    @RequestMapping(method = RequestMethod.DELETE  , value = "/topics/{topicId}/courses/{cid}/lessons/{id}")
    public void deleteLesson(@PathVariable String id ){
        topicService.deleteLesson(id);
    }

}
