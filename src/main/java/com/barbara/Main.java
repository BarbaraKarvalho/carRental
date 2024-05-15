package com.barbara;

import com.barbara.domain.CarRental;
import com.barbara.domain.Vehicle;
import com.barbara.service.BrazilTaxService;
import com.barbara.service.CarRentalService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.of(2024, 05, 15, 14, 0);
        LocalDateTime finish = LocalDateTime.of(2024, 05, 17, 15, 0);

        Vehicle vehicle = new Vehicle("Corola");

        CarRental rental = new CarRental(start, finish, vehicle);

        CarRentalService rentalService = new CarRentalService(10, 180, new BrazilTaxService());

        rentalService.processInvoice(rental);

    }
}