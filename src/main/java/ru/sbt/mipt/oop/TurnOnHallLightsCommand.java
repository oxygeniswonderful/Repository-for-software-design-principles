package ru.sbt.mipt.oop;



public class TurnOnHallLightsCommand implements Command {
    private SmartHome smartHome;

    public TurnOnHallLightsCommand(SmartHome smartHome) {

        this.smartHome = smartHome;
    }

    @Override
    public void execute() {

        smartHome.execute(component ->{

            if(!(component instanceof Room))  {

                return;
            }
            Room room = (Room) component;

            if(room.getName().equals("hall")) {

                room.execute(roomComponent-> {

                    if (roomComponent instanceof Light) {
                        ((Light) roomComponent).setOn(true);
                    }
                });
            }
        });
    }
}

