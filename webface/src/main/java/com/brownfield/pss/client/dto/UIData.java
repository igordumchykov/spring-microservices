package com.brownfield.pss.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class UIData {
    private SearchQuery searchQuery;
    private List<Flight> flights;
    private Flight selectedFlight;
    private Passenger passenger;
    private String bookingid;
}