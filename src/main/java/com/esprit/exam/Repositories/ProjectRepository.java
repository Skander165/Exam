package com.esprit.exam.Repositories;

import com.esprit.exam.Models.Project;
import com.esprit.exam.Models.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findProjectsBySprintsAfter(Date auj);

}
