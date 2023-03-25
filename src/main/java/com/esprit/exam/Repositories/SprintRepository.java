package com.esprit.exam.Repositories;

import com.esprit.exam.Models.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {
    List<Sprint> findByStartDateAfter(Date auj);
}
