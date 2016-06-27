package chapter10;

public class Client10_7 {

}

class RoadDisplay10_7 {
	public void draw() {
		System.out.println("기본 도로 표시");
	}
}

class RoadDisplayWithLane10_7 extends RoadDisplay10_7 {
	public void draw() {
		super.draw();
		drawLane();
	}
	
	private void drawLane() {
		System.out.println("차선표시");
	}
}
