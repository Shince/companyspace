package com.lovematch.match.beans;

import java.util.List;

public class RaceDistance {
	private String wholeMarathon;
	private String halfMarathon;
	private String otherDistance;
	private List<String> otherDistanceList;
	
	public String getWholeMarathon() {
		return wholeMarathon;
	}
	public void setWholeMarathon(String wholeMarathon) {
		this.wholeMarathon = wholeMarathon;
	}
	public String getHalfMarathon() {
		return halfMarathon;
	}
	public void setHalfMarathon(String halfMarathon) {
		this.halfMarathon = halfMarathon;
	}
	public String getOtherDistance() {
		return otherDistance;
	}
	public void setOtherDistance(String otherDistance) {
		this.otherDistance = otherDistance;
	}
	public List<String> getOtherDistanceList() {
		return otherDistanceList;
	}
	public void setOtherDistanceList(List<String> otherDistanceList) {
		this.otherDistanceList = otherDistanceList;
	}
	
}
