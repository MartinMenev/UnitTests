package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AlarmTest {

    @Test
    public void testAlarmWithLowPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(12.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithEnormousPressure() {
        Sensor sensorWithBigPressure = Mockito.mock(Sensor.class);
        when(sensorWithBigPressure.popNextPressurePsiValue()).thenReturn(100.0);
        Alarm alarm = new Alarm(sensorWithBigPressure);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithNormalPressure() {
        Sensor sensorWithNormalPressure = Mockito.mock(Sensor.class);
        when(sensorWithNormalPressure.popNextPressurePsiValue()).thenReturn(18.0);
        Alarm alarm = new Alarm(sensorWithNormalPressure);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }
}