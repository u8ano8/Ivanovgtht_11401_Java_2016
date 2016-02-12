/**
 * Created by Андрей on 12.02.2016.
 */
public class Rescue extends Helicopter implements Appointment {
    @Override
    public int seating() {
        return 8;
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
