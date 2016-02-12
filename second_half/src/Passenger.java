/**
 * Created by Андрей on 12.02.2016.
 */
public class Passenger extends Aircraft implements Appointment {
    @Override
    public int seating() {
        return 154;
    }

    @Override
    public boolean trunk() {
        return true;
    }

    @Override
    public boolean cistern() {
        return false;
    }

    @Override
    public boolean weapon() {
        return false;
    }
}
