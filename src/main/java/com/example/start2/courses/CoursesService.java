package com.example.start2.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

//    private List<Course> topics = new ArrayList<>(Arrays.asList(
//
//            new Course("spring", "Spring framework", "dexcrition"),
//            new Course("sprinasdasd", "Spring asdassdaframework", "dexcrsadsd"),
//            new Course("spasdas", "sdsada", "dexcrsadsa")
//
//
//    ));

    public List<Course> getAllCourses( String topicid) {
//        return topics;
        List<Course> courses = new ArrayList<>();
        coursesRepository.findByTopicsId(topicid).forEach(courses::add); //is an iterbale convert to list.
        return courses;
   }

    public Course getCourse(String id) {
      //  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();//lmda expressin
        return coursesRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
       // topics.add(topic);
        coursesRepository.save(course);
    }

    public void updateCourse( Course course) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topics t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        coursesRepository.save(course);//save do the work for both add and update
    }

    public void deleteCourse(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        coursesRepository.deleteById(id);
    }
}
