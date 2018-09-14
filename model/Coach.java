package model;

import java.util.Vector;

public class Coach {
	private String teamcoach;
	Vector<String> season = new Vector<String>();
	Vector<String> teamname = new Vector<String>();
	
	public String getTeamcoach(){
		return teamcoach;
	}
	public Vector<String> getSeason(){
		return season;
	}
	public Vector<String> getTeamname(){
		return teamname;
	}
	
	public void setTeamcoach(String a){
		teamcoach = a;
	}
	public void addSeason(String a){
		season.add(a);
	}
	public void addTeamname(String a){
		teamname.add(a);
	}
}
