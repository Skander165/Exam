package com.esprit.exam.Services;

import com.esprit.exam.Models.Project;
import com.esprit.exam.Models.Sprint;
import com.esprit.exam.Repositories.ProjectRepository;
import com.esprit.exam.Repositories.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SprintService implements ISprintService {
    private final SprintRepository _sprintRepository;
    private final ProjectRepository _projectRepository;
    @Override
    public Sprint addSprint(Sprint sprint) {
        _sprintRepository.save(sprint);

        return sprint;
    }

    @Override
    @Transactional
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = _projectRepository.findById(idProject).orElse(null);
        Sprint sp = addSprint(sprint);
        Assert.notNull(project,"Project must not be null");
        project.getSprints().add(sp);
    }
}
