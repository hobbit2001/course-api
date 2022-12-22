package com.example.start2.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;
    @RequestMapping("/topics")
    public List<Topics> getAllTopics() {


        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{s}")
    public Topics getTopic(@PathVariable String s){

        return topicService.getTopics(s);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics")
    public void addtopics(@RequestBody Topics topics ){
        topicService.addTopic(topics);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
    public void upfateopics(@RequestBody Topics topics , @PathVariable String id  ){
        topicService.updateTopic(id ,topics);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void deletetopics(@PathVariable String id ){
        topicService.deleteTopic(id);
    }

}
