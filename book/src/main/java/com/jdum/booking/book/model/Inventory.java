package com.jdum.booking.book.model;

import com.jdum.booking.common.model.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Inventory extends BaseEntity {

    private String flightNumber;
    private String flightDate;
    private int available;

    public boolean isAvailable(int count) {
        return ((available - count) > 5);
    }

    public int getBookableInventory() {
        return available - 5;
    }
}