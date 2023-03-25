package com.esprit.exam.Services;

import com.esprit.exam.Models.Project;
import com.esprit.exam.Models.Sprint;
import com.esprit.exam.Models.User;
import com.esprit.exam.Repositories.ProjectRepository;
import com.esprit.exam.Repositories.SprintRepository;
import com.esprit.exam.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService{
    private final ProjectRepository _projectRepository;
    private final UserRepository _userRepository;
    private final SprintRepository _sprintRepository;
    @Override
    public Project addProject(Project project) {
        _projectRepository.save(project);
        return project;
    }

    @Override
    public List<Project> getAllCurrentProject() {
        Date auj = new Date();
        return _projectRepository.findProjectsBySprintsAfter(auj);

    }
}
