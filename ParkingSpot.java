package com.example.smartparking.model;

public class ParkingSpot {
        private String id;
        private int floor;
        private SpotSize size;
        public boolean isOccupied;

        public ParkingSpot(String id, int floor, SpotSize size, boolean isOccupied) {
            this.id = id;
            this.floor = floor;
            this.size = size;
            this.isOccupied = isOccupied;
        }

        public boolean canFitVehicle(@org.jetbrains.annotations.NotNull Vehicle vehicle) {
            switch (vehicle.getType()) {
                case MOTORCYCLE: return true;
                case CAR: return size == SpotSize.MEDIUM || size == SpotSize.LARGE;
                case BUS: return size == SpotSize.LARGE;
                default: return false;
            }
        }

    public void setOccupied(boolean b) {
    }

    public boolean isOccupied() {
            return isOccupied;
    }

    //
    }


