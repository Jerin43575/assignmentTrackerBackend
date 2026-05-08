package com.student.assignment_tracker.services;

import com.student.assignment_tracker.models.Assignments;
import com.student.assignment_tracker.repositories.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository){
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignments> getAllAssignments(){
        return this.assignmentRepository.findAll();
    }

    public Assignments getAssignmentById(UUID assignmentId){
        return this.assignmentRepository.findById(assignmentId).orElseThrow(()->new RuntimeException("Assignment Not Found"));
    }

    public Assignments createAssignment(Assignments assignments){
        return this.assignmentRepository.save(assignments);
    }

    public Assignments updateAssignment(Assignments assignments) {
        Assignments existingAssignment = this.assignmentRepository.findById(assignments.getAssignmentId()).orElseThrow(()->new RuntimeException("Assignment Not Found"));
        return this.assignmentRepository.save(assignments);
    }

    public void deleteAssignment(UUID assignmentId){
        Assignments existingAssignment = this.assignmentRepository.findById(assignmentId).orElseThrow(()->new RuntimeException("Assignment Not Found"));
        this.assignmentRepository.deleteById(assignmentId);
    }
}
