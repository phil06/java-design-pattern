package chapter08;

public class Client8_4 {
	public static void main(String[] args) {
		Lamp8_4 lamp = new Lamp8_4();
		Command lampOnCommand = new LampOnCommand(lamp);
		
		Button8_4 button1 = new Button8_4(lampOnCommand);
		button1.pressed();
		
		Alarm8_4 alarm = new Alarm8_4();
		Command alarmOnCommand = new AlarmOnCommand(alarm);
		
		Button8_4 button2 = new Button8_4(alarmOnCommand);
		button2.pressed();
		
		button2.setCommand(lampOnCommand);
		button2.pressed();
	}
}

interface Command {
	public abstract void execute();
}

class Button8_4 {
	private Command theCommand;
	
	public Button8_4(Command theCommand) {
		setCommand(theCommand);
	}
	
	public void setCommand(Command theCommand) {
		this.theCommand = theCommand;
	}
	
	public void pressed() {
		theCommand.execute();
	}
}

class Lamp8_4 {
	public void turnOn() {
		System.out.println("Lamp On ....");
	}
}

class LampOnCommand implements Command {
	private Lamp8_4 theLamp;
	
	public LampOnCommand(Lamp8_4 theLamp) {
		this.theLamp = theLamp;
	}
	
	@Override
	public void execute() {
		theLamp.turnOn();
	}
	
}

class Alarm8_4 {
	public void start() {
		System.out.println("Alarming ...");
	}
}

class AlarmOnCommand implements Command {
	private Alarm8_4 theAlarm;
	
	public AlarmOnCommand(Alarm8_4 theAlarm) {
		this.theAlarm = theAlarm;
	}
	
	public void execute() {
		theAlarm.start();
	}
}