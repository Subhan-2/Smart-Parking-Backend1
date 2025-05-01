package com.example.smartparking.service;
import com.example.smartparking.model.*;
import com.example.smartparking.strategy.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;


import java.time.*;
import java.util.*;

    @Service
    public class ParkingLotService {
        private final List<ParkingSpot> spots = new ArrayList<>();
        private final Map<String, ParkingTransaction> activeTransactions = new HashMap<>();
        private final SpotAllocationStrategy allocationStrategy = new NearestSpotStrategy();
        private final Map<VehicleType, FeeStrategy> feeStrategies = Map.of(
                VehicleType.MOTORCYCLE, new MotorcycleFee(),
                VehicleType.CAR, new CarFee(),
                VehicleType.BUS, new BusFee()
        );

        @PostConstruct
        public void initSpots() {
            spots.add(new ParkingSpot("S1", 1, SpotSize.SMALL, false));
            spots.add(new ParkingSpot("M1", 1, SpotSize.MEDIUM, false));
            spots.add(new ParkingSpot("L1", 1, SpotSize.LARGE, false));
        }

        public ParkingTransaction checkIn(Vehicle vehicle) {
            Optional<ParkingSpot> spotOpt = allocationStrategy.findSpot(vehicle, spots);
            if (spotOpt.isEmpty()) throw new IllegalStateException("No available spot");

            ParkingSpot spot = spotOpt.get();
            spot.setOccupied(true);
            ParkingTransaction tx = new ParkingTransaction(UUID.randomUUID().toString(), vehicle, spot);
            activeTransactions.put(vehicle.getLicensePlate(), tx);
            return tx;
        }

        public ParkingTransaction checkOut(String licensePlate) {
            ParkingTransaction tx = activeTransactions.remove(licensePlate);
            if (tx == null) throw new NoSuchElementException("Transaction not found");

            tx.getSpot().setOccupied(false);
            tx.checkout(LocalDateTime.now(), feeStrategies.get(tx.getVehicle().getType()));
            return tx;
        }
    }


