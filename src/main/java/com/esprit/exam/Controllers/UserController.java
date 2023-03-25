package com.esprit.exam.Controllers;

import com.esprit.exam.Models.Project;
import com.esprit.exam.Models.User;
import com.esprit.exam.Services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService _iUserService;
    @PostMapping()
    public User addUser(@RequestBody User u) {
        return _iUserService.addUser(u);
    }


    @PutMapping("{projectId}/{userId}")
    public void assignProjectToUser(@PathVariable int projectId, @PathVariable int userId) {
        _iUserService.assignProjectToUser(projectId, userId);
    }

    @PutMapping("{projectId}/{firstName}/{lastName}")
    public void assignProjectToClient(int projectId, String firstName, String lastName){
        _iUserService.assignProjectToClient(projectId, firstName, lastName);
    }

    @GetMapping("findProjectByScrumMaster/{firstName}/{lastName}")
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        return _iUserService.getProjectsByScrumMaster(fName, lName);
    }
    }
