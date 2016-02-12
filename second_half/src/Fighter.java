/**
 * Created by Андрей on 12.02.2016.
 */
public class Fighter extends Aircraft implements Appointment {
    @Override
    public int seating() {
        return 2;
    }

    @Override
    public boolean trunk() {
        return false;
    }

    @Override
    public boolean cistern() {
        return false;
    }

    @Override
    public boolean weapon() {
        return true;
    }
}
