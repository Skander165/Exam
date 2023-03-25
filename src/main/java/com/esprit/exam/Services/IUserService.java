package com.esprit.exam.Services;

import com.esprit.exam.Models.Project;
import com.esprit.exam.Models.User;

import java.util.List;

public interface IUserService {
    public User addUser(User user);
   public void assignProjectToUser (int projectId, int userId);
    public void assignProjectToClient(int projectId, String firstName, String lastName);

    public List<Project> getProjectsByScrumMaster(String fName, String lName);
}
