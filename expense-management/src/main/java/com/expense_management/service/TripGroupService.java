package com.expense_management.service;

import com.expense_management.dto.CreateTripGroupRequest;
import com.expense_management.entity.TripGroup;

import java.util.List;

public interface TripGroupService {

    TripGroup createTripGroup(CreateTripGroupRequest request);

    List<TripGroup> getAllTripGroups();

    TripGroup getTripGroupById(Long id);
}
