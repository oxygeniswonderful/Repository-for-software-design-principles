package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {

        String lightExpression = "Light ";
        String atRoom = " at room ";

        for (Room room : smartHome.getRooms()) {

            for (Light light : room.getLights()) {

                if (light.getId().equals(event.getObjectId())) {

                    if (event.getType() == LIGHT_ON) {

                        light.setOn(true);
                        System.out.println(lightExpression + light.getId() + atRoom + room.getName() + " was turned on.");
                    }
                    if (event.getType() == LIGHT_OFF) {

                        light.setOn(false);
                        System.out.println(lightExpression + light.getId() + atRoom + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}
