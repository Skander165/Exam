package com.esprit.exam.Services;

import com.esprit.exam.Models.Project;

import java.util.List;

public interface IProjectService {
    public Project addProject (Project project);
    public List<Project> getAllCurrentProject();
}
