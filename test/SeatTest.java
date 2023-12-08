import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    void testSeat() {
        Seat seat = new Seat();
        assertFalse(seat.isOccupied());
        seat.occupy();
        assertTrue(seat.isOccupied());
        seat.release();
        assertFalse(seat.isOccupied());
    }
}