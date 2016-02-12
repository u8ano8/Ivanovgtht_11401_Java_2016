/**
 * Created by Андрей on 12.02.2016.
 */
public class Firefighter extends Helicopter implements Appointment {
    @Override
    public int seating() {
        return 0;
    }

    @Override
    public boolean trunk() {
        return false;
    }

    @Override
    public boolean cistern() {
        return true;
    }

    @Override
    public boolean weapon() {
        return false;
    }
}
