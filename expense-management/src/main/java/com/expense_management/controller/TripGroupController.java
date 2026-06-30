package com.expense_management.controller;

import com.expense_management.dto.CreateTripGroupRequest;
import com.expense_management.entity.TripGroup;
import com.expense_management.service.TripGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip-groups")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TripGroupController {

    private final TripGroupService tripGroupService;

    @PostMapping
    public TripGroup createTripGroup(
            @Valid @RequestBody CreateTripGroupRequest request) {

        return tripGroupService.createTripGroup(request);
    }

    @GetMapping
    public List<TripGroup> getAllTripGroups() {

        return tripGroupService.getAllTripGroups();

    }

    @GetMapping("/{id}")
    public TripGroup getTripGroup(
            @PathVariable Long id) {

        return tripGroupService.getTripGroupById(id);

    }

}