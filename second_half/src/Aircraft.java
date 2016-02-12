/**
 * Created by Андрей on 12.02.2016.
 */
public class Aircraft implements Characteristic {
    @Override
    public boolean loop() {
        return true;
    }

    @Override
    public boolean turn() {
        return false;
    }
}
