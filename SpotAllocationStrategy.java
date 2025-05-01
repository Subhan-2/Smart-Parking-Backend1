package com.example.smartparking.strategy;

import com.example.smartparking.model.*;
import java.util.*;

    public interface SpotAllocationStrategy {
        Optional<ParkingSpot> findSpot(Vehicle vehicle, List<ParkingSpot> spots);
    }


