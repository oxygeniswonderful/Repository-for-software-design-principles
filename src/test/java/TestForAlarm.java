import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.alarm.Alarm;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestForAlarm {
    Alarm alarm = new Alarm();

    @Test
    public void testWrongCode() {

        alarm.activate("code");
        alarm.deactivate("oops");
        assertTrue(alarm.isAlert());
    }

    @Test
    public void testDeactivate() {

        alarm.activate("code");
        alarm.deactivate("code");
        assertTrue(alarm.isDeactivated());
    }

    @Test
    public void testActivate() {

        alarm.activate("code");
        assertTrue(alarm.isActivated());
    }

}
