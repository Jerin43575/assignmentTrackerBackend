package com.student.assignment_tracker.repositories;

import com.student.assignment_tracker.models.Assignments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignments, UUID> {
    public List<Assignments> findAll();
}
