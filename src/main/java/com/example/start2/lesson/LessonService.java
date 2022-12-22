package com.example.start2.lesson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;



    public List<Lesson> getAllLessons( String courseId) {
//        return topics;
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(courseId).forEach(lessons::add); //is an iterbale convert to list.
        return lessons;
   }

    public Lesson getLesson(String id) {
      //  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();//lmda expressin
        return lessonRepository.findById(id).orElse(null);
    }

    public void addLesson(Lesson lesson) {
       // topics.add(topic);
        lessonRepository.save(lesson);
    }

    public void updateLesson(Lesson lesson) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topics t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        lessonRepository.save(lesson);//save do the work for both add and update
    }

    public void deleteLesson(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        lessonRepository.deleteById(id);
    }
}
