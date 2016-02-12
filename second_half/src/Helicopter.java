/**
 * Created by Андрей on 12.02.2016.
 */
public class Helicopter implements Characteristic {
    @Override
    public boolean loop() {
        return false;
    }

    @Override
    public boolean turn() {
        return true;
    }
}
