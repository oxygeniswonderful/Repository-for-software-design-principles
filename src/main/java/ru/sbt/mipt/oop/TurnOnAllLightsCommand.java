package ru.sbt.mipt.oop;


public class TurnOnAllLightsCommand implements Command {

    private SmartHome smartHome;

    public TurnOnAllLightsCommand(SmartHome smartHome) {

        this.smartHome = smartHome;
    }

    @Override
    public void execute() {

        smartHome.execute(component -> {
            if(component instanceof Light) {
                ((Light) component).setOn(true);
            }
        });
    }
}
