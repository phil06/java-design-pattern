package chapter08;

public class Client8_3 {
	public static void main(String[] args) {
		Alarm8_3 alarm = new Alarm8_3();
		Lamp8_3 lamp = new Lamp8_3();
		Button8_3 button = new Button8_3(alarm, lamp);
		
		button.setMode(Mode.LAMP);
		button.pressed();
		button.setMode(Mode.ALARM);
		button.pressed();
	}
}

enum Mode { LAMP, ALARM }

class Lamp8_3 {
	public void turnOn() {
		System.out.println("Lamp On");
	}
}

class Alarm8_3 {
	public void start() {
		System.out.println("Alarming...");
	}
}

class Button8_3 {
	private Alarm8_3 theAlarm;
	private Lamp8_3 theLamp;
	private Mode theMode;
	
	public Button8_3(Alarm8_3 theAlarm, Lamp8_3 theLamp) {
		this.theAlarm = theAlarm;
		this.theLamp = theLamp;
	}
	
	public void setMode(Mode theMode) {
		this.theMode = theMode;
	}
	
	public void pressed() {
		switch(theMode) {
		case LAMP:
			theLamp.turnOn();
			break;
		case ALARM:
			theAlarm.start();
			break;
		}
	}
}