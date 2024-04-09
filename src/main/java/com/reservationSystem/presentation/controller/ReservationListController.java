package com.reservationSystem.presentation.controller;

import com.reservationSystem.application.usecase.FetchReservationListUsecase;
import com.reservationSystem.domain.model.aggregate.ReservationListAggregate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationListController {
    private final FetchReservationListUsecase usecase;

    public ReservationListController(FetchReservationListUsecase usecase) {
        this.usecase = usecase;
    }

    @GetMapping("/List")
    public List<ReservationListAggregate> getReservations() {
        return usecase.execute();
    }
}