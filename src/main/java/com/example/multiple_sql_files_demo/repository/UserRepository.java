package com.example.multiple_sql_files_demo.repository;

import com.example.multiple_sql_files_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
