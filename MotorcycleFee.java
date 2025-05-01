package com.example.smartparking.strategy;
    public class MotorcycleFee implements FeeStrategy {
        public double calculateFee(long hours) {
            return hours * 1.0;
        }
    }


