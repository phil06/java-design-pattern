package chapter09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client9_2 {
	public static void main(String[] args) {
		ScoreRecord9_2 scoreRecord = new ScoreRecord9_2();
		
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		DataSheetView9_2 dataSheetView = new DataSheetView9_2(scoreRecord, 3);
		
		scoreRecord.setMinMaxView(minMaxView);
		scoreRecord.setDataSheetView(dataSheetView);
		
		for(int index = 1 ; index <= 5 ; index++) {
			int score = index * 10;
			System.out.println("Adding " + score);
			
			scoreRecord.addScore(score);
		}
		
		
	}
}


class DataSheetView9_2 {
	private ScoreRecord9_2 scoreRecord;
	private int viewCount;
	
	public DataSheetView9_2(ScoreRecord9_2 scoreRecord, int viewCount) {
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

class MinMaxView {
	private ScoreRecord9_2 scoreRecord;
	
	public MinMaxView(ScoreRecord9_2 scoreRecord) {
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

class ScoreRecord9_2 {
	private List<Integer> scores = new ArrayList<Integer>();
	private DataSheetView9_2 dataSheetView;
	private MinMaxView minMaxView;
	
	public void setDataSheetView(DataSheetView9_2 dataSheetView) {
		this.dataSheetView = dataSheetView;
	}
	
	public void setMinMaxView(MinMaxView minMaxView) {
		this.minMaxView = minMaxView;
	}
	
	public void addScore(int score) {
		scores.add(score);
		dataSheetView.update();
		minMaxView.update();
	}
	
	public List<Integer> getScoreRecord() {
		return scores;
	}
}
