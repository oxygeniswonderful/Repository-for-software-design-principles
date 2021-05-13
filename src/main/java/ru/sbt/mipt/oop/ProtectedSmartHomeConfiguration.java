package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControl;
import rc.RemoteControlRegistry;
import AlarmEventProcessor;
import ru.sbt.mipt.oop.EventProcessor.AlarmEventProcessorDecorator;
import ru.sbt.mipt.oop.EventProcessor.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessor.EventProcessor;
import ru.sbt.mipt.oop.EventProcessor.LightEventProcessor;
import ru.sbt.mipt.oop.alarm.AlertAlarmMessageNotifier;
import ru.sbt.mipt.oop.alarm.AlertAlarmNotifier;
import ru.sbt.mipt.oop.rc.*;

import java.util.List;
import java.util.Map;

import static ru.sbt.mipt.oop.SensorEventType.*;

@Configuration
public class ProtectedSmartHomeConfiguration {
    @Bean
    public SmartHome smartHome() {
        return new SmartHomeJsonReader().readSmartHome("smart-home-1.js");
    }

    @Bean
    EventProcessor doorEventProcessor(){
        return new DoorEventProcessor();
    }

    @Bean
    EventProcessor hallDoorEventProcessor(){
        return new HallDoorEventProcessor();
    }

    @Bean
    Map<String, SensorEventType> ccStringToType() {
        return Map.ofEntries(
                Map.entry("LightIsOn", LIGHT_ON),
                Map.entry("LightIsOff", LIGHT_OFF),
                Map.entry("DoorIsOpen", DOOR_OPEN),
                Map.entry("DoorIsClosed", DOOR_CLOSED)
        );
    }

    @Bean
    EventProcessor lightEventProcessor(){
        return new LightEventProcessor();
    }

    @Bean
    public AlertAlarmNotifier createAlertAlarmNotifier(){
        return new AlertAlarmMessageNotifier();
    }


    @Bean
    EventProcessor alarmEventProcessor(){
        return new AlarmEventProcessor();
    }

    @Bean
    CCEventProcessorAdapter eventProcessorAdapter(List<EventProcessor> processors,
                                                  Map<String, SensorEventType> ccStringToType){
        return new CCEventProcessorAdapter(new AlarmEventProcessorDecorator(processors, createAlertAlarmNotifier()), smartHome(), ccStringToType);
    }

    @Bean
    public SensorEventCreator sensorEventsManager(CCEventProcessorAdapter adapter) {
        SensorEventCreator sensorEventsManager = new SensorEventCreator();
        sensorEventsManager.registerEventProcessor(adapter);
        return sensorEventsManager;
    }

    @Bean
    String code() {
        return "activate";
    }

    @Bean
    Command activateAlarmCommand() {
        return new ActivateAlarmCommand(smartHome(), code());
    }

    @Bean
    Command closeHallDoorCommand() {
        return new CloseHallDoorCommand(smartHome());
    }

    @Bean
    Command turnOffAllLightsCommand() {
        return new TurnOffAllLightsCommand(smartHome());
    }

    @Bean
    Command turnOnAlertCommand() {
        return new TurnOnAlertCommand(smartHome());
    }

    @Bean
    Command turnOnAllLightsCommand() {
        return new TurnOnAllLightsCommand(smartHome());
    }

    @Bean
    Command turnOnHallLightCommand() {
        return new TurnOnHallLightCommand(smartHome());
    }

    @Bean
    RemoteControl remoteControl() {
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand("0", turnOffAllLightsCommand(smartHome()));
        remoteControl.setCommand("1", turnOnAllLightsCommand(smartHome()));
        remoteControl.setCommand("2", turnOnHallLightCommand(smartHome()));
        remoteControl.setCommand("3", activateAlarmCommand(smartHome()));
        remoteControl.setCommand("4", closeHallDoorCommand(smartHome()));
        remoteControl.setCommand("5", turnOnAlertCommand(smartHome()));
        return remoteControl;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry(String rcId) {
        RemoteControlRegistry remoteControlRegistry = new RemoteControlRegistry();
        remoteControlRegistry.registerRemoteControl(remoteControl(), rcId);
        return remoteControlRegistry;
    }
}
