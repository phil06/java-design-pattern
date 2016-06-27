package chapter09;

import java.util.ArrayList;
import java.util.List;

public class Client9_1 {
	public static void main(String[] args) {
		ScoreRecord scoreRecord = new ScoreRecord();
		
		DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
		scoreRecord.setDataSheetView(dataSheetView);
		
		for(int index = 1 ; index <= 5 ; index++) {
			int score = index * 10;
			System.out.println("Adding " + score);
			
			scoreRecord.addScore(score);
		}
	}
}

class DataSheetView {
	private ScoreRecord scoreRecord;
	private int viewCount;
	
	public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
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

class ScoreRecord {
	private List<Integer> scores = new ArrayList<Integer>();
	private DataSheetView dataSheetView;
	
	public void setDataSheetView(DataSheetView dataSheetView) {
		this.dataSheetView = dataSheetView;
	}
	
	public void addScore(int score) {
		scores.add(score);
		dataSheetView.update();
	}
	
	public List<Integer> getScoreRecord() {
		return scores;
	}
}
