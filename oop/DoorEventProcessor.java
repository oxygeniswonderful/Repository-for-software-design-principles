package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor{
    public void processEvent(SmartHome smartHome, SensorEvent event) {

        String d = "Door ";
        String atRoom = " at room ";

        for (Room room : smartHome.getRooms()) {

            for (Door door : room.getDoors()) {

                if (door.getId().equals(event.getObjectId())) {

                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);

                        System.out.println(d + door.getId() + atRoom + room.getName() + " was opened");
                    }

                    if (event.getType() == DOOR_CLOSED) {

                        door.setOpen(false);
                        System.out.println(d + door.getId() + atRoom + room.getName() + " was closed");

                        if (room.getName().equals("hall")) {

                            for (Room hallRoom : smartHome.getRooms()) {

                                for (Light light : hallRoom.getLights()) {

                                    light.setOn(false);
                                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                    CommandTransmitter.sendCommand(command);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
