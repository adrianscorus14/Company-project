package com.sda.company.service;

import com.sda.company.entities.Project;
import com.sda.company.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    ProjectRepository projectRepository;

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public void delete(Project project){
         projectRepository.delete(project);
    }
}
