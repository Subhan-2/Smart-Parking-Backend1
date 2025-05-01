package com.example.smartparking.model;
import java.time.*;
import com.example.smartparking.strategy.FeeStrategy;

    public class ParkingTransaction {
        private String id;
        private Vehicle vehicle;
        private ParkingSpot spot;
        private LocalDateTime entryTime;
        private LocalDateTime exitTime;
        private double totalFee;

        public ParkingTransaction(String id, Vehicle vehicle, ParkingSpot spot) {
            this.id = id;
            this.vehicle = vehicle;
            this.spot = spot;
            this.entryTime = LocalDateTime.now();
        }

        public void checkout(LocalDateTime exitTime, FeeStrategy strategy) {
            this.exitTime = exitTime;
            long hours = Math.max(1, Duration.between(entryTime, exitTime).toHours());
            this.totalFee = strategy.calculateFee(hours);
        }

        public ParkingSpot getSpot() {
            return spot;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        // Getters only (no setters needed)
    }


