package com.esprit.exam.Repositories;

import com.esprit.exam.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByFnameAndLname(String fname, String lname);
    User findByFnameAndLnameAndRole_ScrumMaster(String fname, String lname);
}
