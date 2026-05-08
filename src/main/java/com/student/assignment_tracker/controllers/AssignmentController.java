package com.student.assignment_tracker.controllers;

import com.student.assignment_tracker.models.Assignments;
import com.student.assignment_tracker.services.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping
    @RequestMapping("/all")
    public List<Assignments> getAllStudentAsignment (){
        return this.assignmentService.getAllAssignments();
    }

    @GetMapping
    @RequestMapping("/{assignmentId}")
    public Assignments getAssignmentById(@PathVariable UUID assignmentId){
        return this.assignmentService.getAssignmentById(assignmentId);
    }

    @PostMapping
    @RequestMapping("/create")
    public Assignments createStudentAssignment(@RequestBody Assignments assignments){
        return this.assignmentService.createAssignment(assignments);
    }

    @PutMapping
    @RequestMapping("/update")
    public Assignments updateStudentAssignment(@RequestBody Assignments assignments){
        return this.assignmentService.updateAssignment(assignments);
    }

    @DeleteMapping
    @RequestMapping("/delete/{assignmentId}")
    public void deleteAsssignment(@PathVariable UUID assignmentId){
        this.assignmentService.deleteAssignment(assignmentId);
    }
}
