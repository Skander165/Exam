package com.esprit.exam.Controllers;

import com.esprit.exam.Models.Project;
import com.esprit.exam.Models.User;
import com.esprit.exam.Services.IProjectService;
import com.esprit.exam.Services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class projectController {
    private final IProjectService _iProjectService;
    @PostMapping()
    public Project addProject(@RequestBody Project p) {
        return _iProjectService.addProject(p);
    }
    @GetMapping()
    public List<Project> getAllCurrentProject() {
        return _iProjectService.getAllCurrentProject();
    }
}
