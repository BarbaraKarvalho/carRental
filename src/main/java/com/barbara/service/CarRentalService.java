package com.barbara.service;

import com.barbara.domain.CarRental;

import java.time.Duration;

public class CarRentalService {
    private double pricePerHour;
    private double pricePerDay;

    public CarRentalService() {
    }

    public CarRentalService(double pricePerHour, double pricePerDay) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void processInvoice(CarRental carRental) {
        Duration rentalDuration = Duration.between(carRental.getStart(), carRental.getFinish());
    }

    @Override
    public String toString() {
        return "CarRentalService{" +
                "pricePerHour=" + pricePerHour +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
