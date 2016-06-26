package chapter08;

public class Client8_2 {
	public static void main(String[] args) {
		Alarm alarm = new Alarm();
		Button alarmButton = new Button(alarm);
		alarmButton.pressed();
	}
}

class Alarm {
	public void start() {
		System.out.println("Alarming...");
	}
}

class Button {
	private Alarm theAlarm;
	
	public Button(Alarm theAlarm) {
		this.theAlarm = theAlarm;
	}
	
	public void pressed() {
		theAlarm.start();
	}
}