package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.alarm.AlertAlarmNotifier;

public class AlertAlarmMessageNotifier implements AlertAlarmNotifier {
    @Override
    public void sendMessage() {
        System.out.println("Sending sms");
    }
}
