package com.example.smartparking.strategy;

import com.example.smartparking.model.*;
        import java.util.*;

public class NearestSpotStrategy implements SpotAllocationStrategy {
    public Optional<ParkingSpot> findSpot(Vehicle vehicle, List<ParkingSpot> spots) {
        return spots.stream()
                .filter(s -> s.canFitVehicle(vehicle) && !s.isOccupied())
                .findFirst();
    }
}
