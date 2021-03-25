package ru.sbt.mipt.oop;

public class TurnOnAlertCommand implements Command {

    private SmartHome smartHome;

    public TurnOnAlertCommand(SmartHome smartHome) {

        this.smartHome = smartHome;
    }

    @Override
    public void execute() {

        smartHome.getAlarm().alert();
    }
}
