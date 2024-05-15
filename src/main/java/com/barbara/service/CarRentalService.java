package com.barbara.service;

import com.barbara.domain.CarRental;
import com.barbara.domain.Invoice;

import java.time.Duration;

public class CarRentalService {
    private double pricePerHour;
    private double pricePerDay;

    private BrazilTaxService brazilTaxService;

    public CarRentalService(double pricePerHour, double pricePerDay, BrazilTaxService brazilTaxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.brazilTaxService = brazilTaxService;
    }

    // TODO: gerar o invoice em cima do aluguel recebido
    /*  regras:
    *   1. pagamento é contado em horas inteiras até 12h, acima conta na diária
    *   2. usar valor de custo por hora e custo por dia em cima do tempo para pagamento basico
    *   3. em cima do pagamento basico, calcular a taxa a ser ser paga
    *   4. montar o invoice
    * */
    public void processInvoice(CarRental carRental) {
        // LocalDateTime, Duration
        Duration rentalDuration = carRental.getDuration();

        double durationInHours = Math.ceil(rentalDuration.toMinutes() / 60.0);
        double durationInDays = Math.ceil(rentalDuration.toHours() / 24.0);

        double basicPayment;

        if(durationInHours <= 12)
           basicPayment = durationInHours * pricePerHour;
        else
           basicPayment = durationInDays * pricePerDay;

        double tax = brazilTaxService.calculateTax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    @Override
    public String toString() {
        return "CarRentalService{" +
                "pricePerHour=" + pricePerHour +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
