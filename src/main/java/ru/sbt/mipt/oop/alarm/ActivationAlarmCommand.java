package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.Command;
import ru.sbt.mipt.oop.SmartHome;

public class ActivationAlarmCommand implements Command {

    private SmartHome smartHome;
    private String code;

    public ActivationAlarmCommand(SmartHome smartHome, String code) {

        this.smartHome = smartHome;
        this.code = code;
    }

    @Override
    public void execute() {

        smartHome.getAlarm().activate(code);
    }
}