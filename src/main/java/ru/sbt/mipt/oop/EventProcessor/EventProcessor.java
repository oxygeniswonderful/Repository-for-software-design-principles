package ru.sbt.mipt.oop.EventProcessor;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventProcessor {

    void processEvent(SmartHome smartHome, SensorEvent event);
}
