package com.esprit.exam.Services;

import com.esprit.exam.Models.Project;
import com.esprit.exam.Models.User;
import com.esprit.exam.Repositories.ProjectRepository;
import com.esprit.exam.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository _userRepository;
    private final ProjectRepository _projectRepository;

    @Override
    public User addUser(User user) {
        _userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public void assignProjectToUser(int projectId, int userId) {
        Project project = _projectRepository.findById(projectId).orElse(null);
        User user = _userRepository.findById(userId).orElse(null);
        Assert.notNull(project, "Project must not be null.");
        Assert.notNull(user, "User must not be null.");
        user.getProjects().add(project);
    }
    @Override
    @Transactional
    public void assignProjectToClient(int projectId, String firstName, String lastName){
        Project project = _projectRepository.findById(projectId).orElse(null);
        User user = _userRepository.findByFnameAndLname(firstName, lastName);
        Assert.notNull(project, "Project must not be null.");
        Assert.notNull(user, "User must not be null.");
        user.getClientProjects().add(project);
    }
    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName){
        User user = _userRepository.findByFnameAndLnameAndRole_ScrumMaster(fName, lName);
        return user.getProjects();
    }

}
