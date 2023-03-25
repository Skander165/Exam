package com.esprit.exam.Services;

import com.esprit.exam.Models.Sprint;

public interface ISprintService {
    public Sprint addSprint(Sprint sprint);
    public void addSprintAndAssignToProject(Sprint sprint, int idProject);
}
