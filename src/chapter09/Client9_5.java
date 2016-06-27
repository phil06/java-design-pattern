package chapter09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client9_5 {
	public static void main(String[] args) {
		ScoreRecord9_5 scoreRecord = new ScoreRecord9_5();
		DataSheetView9_5 dataSheetView3 = new DataSheetView9_5(scoreRecord, 3);
		scoreRecord.attach(dataSheetView3);
		MinMaxView9_5 minMaxView = new MinMaxView9_5(scoreRecord);
		scoreRecord.attach(minMaxView);
		
		for(int index = 1 ; index <= 5 ; index++) {
			int score = index * 10;
			System.out.println("Adding " + score);
			scoreRecord.addScore(score);
		}
		
		scoreRecord.detach(dataSheetView3);
		StatisticsView statisticsView = new StatisticsView(scoreRecord);
		scoreRecord.attach(statisticsView);
		
		for(int index = 1 ; index <= 5 ; index++) {
			int score = index * 10;
			System.out.println("Adding " + score);
			scoreRecord.addScore(score);
		}
	}
}

interface Observer {
	public abstract void update();
}



abstract class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer o : observers)
			o.update();
	}
}

class ScoreRecord9_5 extends Subject {
	
	private List<Integer> scores = new ArrayList<Integer>();
	
	public void addScore(int score) {
		scores.add(score);
		notifyObservers();
	}
	
	public List<Integer> getScoreRecord() {
		return scores;
	}
}

class DataSheetView9_5 implements Observer {
	private ScoreRecord9_5 scoreRecord;
	private int viewCount;
	
	public DataSheetView9_5(ScoreRecord9_5 scoreRecord, int viewCount) {
		this.scoreRecord = scoreRecord;
		this.viewCount = viewCount;
	}
	
	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayScores(record, viewCount);
	}
	
	private void displayScores(List<Integer> record, int viewCount) {
		System.out.println("List of " + viewCount + " entries: ");
		for(int i = 0 ; i < viewCount && i < record.size() ; i++ ) {
			System.out.println(record.get(i) + " ");
		}
		System.out.println();
	}
}

class MinMaxView9_5 implements Observer{
	private ScoreRecord9_5 scoreRecord;
	
	public MinMaxView9_5(ScoreRecord9_5 scoreRecord) {
		this.scoreRecord = scoreRecord;
	}
	
	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMax(record);
	}
	
	private void displayMinMax(List<Integer> record) {
		int min = Collections.min(record, null);
		int max = Collections.max(record, null);
		System.out.println("Min:" + min + "/ Max:" + max);
	}
}

class StatisticsView implements Observer {

	private ScoreRecord9_5 scoreRecord;
	
	public StatisticsView(ScoreRecord9_5 scoreRecord) {
		this.scoreRecord = scoreRecord;
	}
	
	@Override
	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayStatistics(record);
	}
	
	private void displayStatistics(List<Integer> record) {
		int sum = 0;
		for (int score:record)
			sum += score;
		
		float average = (float)sum/record.size();
		System.out.println("Sum : " + sum + " Average : " + average);
	}
	
}

/*
 * 
Adding 10
List of 3 entries: 
10 

Min:10/ Max:10
Adding 20
List of 3 entries: 
10 
20 

Min:10/ Max:20
Adding 30
List of 3 entries: 
10 
20 
30 

Min:10/ Max:30
Adding 40
List of 3 entries: 
10 
20 
30 

Min:10/ Max:40
Adding 50
List of 3 entries: 
10 
20 
30 

Min:10/ Max:50
Adding 10
Min:10/ Max:50
Sum : 160 Average : 26.666666
Adding 20
Min:10/ Max:50
Sum : 180 Average : 25.714285
Adding 30
Min:10/ Max:50
Sum : 210 Average : 26.25
Adding 40
Min:10/ Max:50
Sum : 250 Average : 27.777779
Adding 50
Min:10/ Max:50
Sum : 300 Average : 30.0

 * */
