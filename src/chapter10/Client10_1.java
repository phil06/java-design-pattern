package chapter10;

public class Client10_1 {
	public static void main(String[] args) {
		RoadDisplay road = new RoadDisplay();
		road.draw();
		
		RoadDisplay roadWithLane = new RoadDisplayWithLane();
		roadWithLane.draw();
	}
}

class RoadDisplay {
	public void draw() {
		System.out.println("기본 도로 표시");
	}
}

class RoadDisplayWithLane extends RoadDisplay {
	public void draw() {
		super.draw();
		drawLane();
	}
	
	private void drawLane() {
		System.out.println("차선표시");
	}
}

/*
 * 
기본 도로 표시
기본 도로 표시
차선표시
 * */
