package com.example.smartparking.controller;

import com.example.smartparking.model.*;
import com.example.smartparking.service.ParkingLotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/parking")
    public class ParkingController {

        private final ParkingLotService service;

        public ParkingController(ParkingLotService service) {
            this.service = service;
        }

        @PostMapping("/checkin")
        public ResponseEntity<ParkingTransaction> checkIn(@RequestBody Vehicle vehicle) {
            return ResponseEntity.ok(service.checkIn(vehicle));
        }

        @PostMapping("/checkout/{licensePlate}")
        public ResponseEntity<ParkingTransaction> checkOut(@PathVariable String licensePlate) {
            return ResponseEntity.ok(service.checkOut(licensePlate));
        }
    }


