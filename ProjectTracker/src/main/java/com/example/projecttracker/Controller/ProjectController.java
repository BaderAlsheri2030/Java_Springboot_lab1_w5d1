package com.example.projecttracker.Controller;

import com.example.projecttracker.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/projects")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<Project>();

    @PostMapping("/add")
    public String addProject(@RequestBody Project project){
        projects.add(project);
        return "Project added successfully";
    }
    @GetMapping("/get")
    public List<Project> getProjects(){
        return projects;
    }
    @DeleteMapping("/delete/{index}")
    public String deleteProject(@PathVariable int index){
        projects.remove(index);
        return "Project removed successfully";
    }

    @PutMapping("update/{index}")
    public String updateProject(@PathVariable int index, Project project){
        projects.set(index,project);
        return "Project updated successfully";
    }

    @PutMapping("update/status/{index}")
    public String updateStatus(@PathVariable int index){
        if (projects.get(index).getStatus().equalsIgnoreCase("done")) {
            projects.get(index).setStatus("not done");
            return "Status is set to not done";
        }  if (projects.get(index).getStatus().equalsIgnoreCase("not done")) {
            projects.get(index).setStatus("done");
            return "Status is set to done";
        }
         return "Status must be set to (done) or (not done)";

    }

    @GetMapping("/search/{title}")
    public ArrayList<Project> searchProjectTitle(@PathVariable String title){
        ArrayList<Project> titles =new ArrayList<>();
        for (Project p : projects) {
            if (p.getTitle().equalsIgnoreCase(title)){
                titles.add(p);
        }
        }
        return titles;
    }

    @GetMapping("/search/companyprojects/{company}")
    public ArrayList<Project> displayProjectsByCompany(@PathVariable String company){
        ArrayList<Project> projectsByCompany = new ArrayList<>();
        for (Project project: projects) {
            if (project.getCompanyName().equalsIgnoreCase(company)){
                projectsByCompany.add(project);
            }
        }
        return projectsByCompany;

    }



}
