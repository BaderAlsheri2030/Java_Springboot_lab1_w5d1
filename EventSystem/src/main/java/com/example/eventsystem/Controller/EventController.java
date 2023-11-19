package com.example.eventsystem.Controller;

import com.example.eventsystem.Model.EventSystem;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/event")
public class EventController {
    ArrayList<EventSystem> events = new ArrayList<EventSystem>();

    @GetMapping("/get")
public ArrayList<EventSystem> getEvents(){
    return events;
}

@PostMapping("/add")
public String addEvent(@RequestBody EventSystem event){
        events.add(event);
        return "Event added successfully";
}

@DeleteMapping("/delete/{index}")
public String deleteEvent(@PathVariable int index){
        events.remove(index);
        return "Event removed successfully";
}
@PutMapping("/update/{index}")
public String updateEvent(@PathVariable int index, EventSystem event){
        events.set(index,event);
        return "Event is updated";
}

@PutMapping("/capacity/{index}/{capacity}")
public String changeCapacity(@PathVariable int index,@PathVariable int capacity){
        events.get(index).setCapacity(capacity);
        return "Capacity for event changed";
}

@GetMapping("search/{id}")
public EventSystem searchEvent(@PathVariable String id){
    for (EventSystem e: events) {
        if (e.getId().equals(id)){
            return e;
        }
    }
    return null;
}



}
