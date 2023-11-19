package com.example.javaspringboot_lab1.Controller;

import com.example.javaspringboot_lab1.Model.StudentSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/system")
    public class StudentController {
     ArrayList<StudentSystem> students = new ArrayList<>();

     @PostMapping("/add")
    public String addStudents(@RequestBody StudentSystem student){
    students.add(student);
    return "Student added";
}

    @DeleteMapping("/delete/{index}")
    public String deleteStudents(@PathVariable int index ){
         students.remove(index);
         return "Student deleted successfully";
    }
    @GetMapping("/students")
    public ArrayList<StudentSystem> getStudents(){
         return students;
    }
    @PutMapping("update/{index}")
    public String updateStudent(@PathVariable int index,@RequestBody StudentSystem student){
         students.set(index,student);
         return "Student information updated Successfully";
    }
    @GetMapping("/name/{index}")
    public String getName(@PathVariable int index){
        return students.get(index).getName();
    }

    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index){
         return students.get(index).getAge();
    }

    @GetMapping("/college/degree/{index}")
    public String getDegree(@PathVariable int index){
         return students.get(index).getDegree();
    }
    @GetMapping("/study/status/{index}")
    public boolean isGraduated(@PathVariable int index){
        return students.get(index).getStatus().equalsIgnoreCase("Graduated");
    }



}
