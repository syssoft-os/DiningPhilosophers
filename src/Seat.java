public class Seat {

    public Seat ( ) {
    }

    public boolean isOccupied ( ) {
        return occupied;
    }

    public void occupy ( ) {
        assert(!occupied);
        occupied = true;
    }

    public void release ( ) {
        assert(occupied);
        occupied = false;
    }
    private boolean occupied = false;
}
