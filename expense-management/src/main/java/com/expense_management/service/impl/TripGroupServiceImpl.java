package com.expense_management.service.impl;

import com.expense_management.dto.CreateTripGroupRequest;
import com.expense_management.entity.TripGroup;
import com.expense_management.repository.TripGroupRepository;
import com.expense_management.service.TripGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripGroupServiceImpl implements TripGroupService {

    private final TripGroupRepository tripGroupRepository;

    @Override
    public TripGroup createTripGroup(CreateTripGroupRequest request) {

        TripGroup group = TripGroup.builder()
                .name(request.getName())
                .build();

        return tripGroupRepository.save(group);
    }

    @Override
    public List<TripGroup> getAllTripGroups() {

        return tripGroupRepository.findAll();

    }

    @Override
    public TripGroup getTripGroupById(Long id) {

        return tripGroupRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Trip Group not found"));

    }
}
