package com.example.start2.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    // private List<Topics> topics = new ArrayList<>(Arrays.asList(

    //         new Topics("spring", "Spring framework", "dexcrition"),
    //         new Topics("sprinasdasd", "Spring asdassdaframework", "dexcrsadsd"),
    //         new Topics("spasdas", "sdsada", "dexcrsadsa")


    // ));

    public List<Topics> getAllTopics() {
//        return topics;
        List<Topics> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add); //is an iterbale convert to list.
        return topics;
   }

    public Topics getTopics(String id) {
      //  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();//lmda expressin
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topics topic) {
       // topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topics topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topics t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);//save do the work for both add and update
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
