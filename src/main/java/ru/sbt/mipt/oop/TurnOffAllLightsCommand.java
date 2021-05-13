package ru.sbt.mipt.oop;

public class TurnOffAllLightsCommand implements Command {

    private SmartHome smartHome;

    public TurnOffAllLightsCommand(SmartHome smartHome) {

        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(component ->{
            if(component instanceof Light){
                ((Light) component).setOn(false);
            }
        });
    }

}
