package com.example.smartparking.strategy;
public class BusFee implements FeeStrategy {
        public double calculateFee(long hours) {
            return hours * 3.5;
        }
    }


