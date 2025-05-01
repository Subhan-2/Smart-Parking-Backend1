package com.example.smartparking.strategy;
    public class CarFee implements FeeStrategy {
        public double calculateFee(long hours) {
            return hours * 2.0;
        }
    }



