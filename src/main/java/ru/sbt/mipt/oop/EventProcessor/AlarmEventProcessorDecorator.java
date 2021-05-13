package ru.sbt.mipt.oop.EventProcessor;

import ru.sbt.mipt.oop.EventProcessor.EventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.AlertAlarmNotifier;

import java.util.List;

public class AlarmEventProcessorDecorator implements EventProcessor {
    private List<EventProcessor> processors;
    private AlertAlarmNotifier alertAlarmNotifier;

    public AlarmEventProcessorDecorator(List<EventProcessor> processors, AlertAlarmNotifier alertAlarmNotifier) {
        this.processors = processors;
        this.alertAlarmNotifier = alertAlarmNotifier;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarm().isActivated() && event.getType() != SensorEventType.ALARM_DEACTIVATE) {
            smartHome.getAlarm().alert();
            alertAlarmNotifier.sendMessage();
        } else {
            if (smartHome.getAlarm().isDeactivated()) {
                for (EventProcessor processor : processors) {
                    processor.processEvent(smartHome, event);
                }
            }
        }
    }
}

