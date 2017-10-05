package com.brownfield.pss.book.service;

import com.brownfield.pss.book.model.BookingRecord;

/**
 * @author idumchykov
 * @since 10/4/17
 */
public interface BookingService {
    long book(BookingRecord record);

    BookingRecord getBooking(long id);

    void updateStatus(String status, long bookingId);
}
