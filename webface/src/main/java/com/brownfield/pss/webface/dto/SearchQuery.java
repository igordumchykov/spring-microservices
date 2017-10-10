package com.brownfield.pss.webface.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SearchQuery {
    private String origin;
    private String destination;
    private String flightDate;

}