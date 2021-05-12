package ru.sbt.mipt.oop.alarm;

public interface AlarmState {

    public void activate(String code);
    public void deactivate(String code);
    public void alert();
}
