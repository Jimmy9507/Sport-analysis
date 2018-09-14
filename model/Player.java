package model;

import java.util.Vector;

public class Player {
	private String namebirth;
	private Vector<String> season = new Vector<String>();
	private Vector<String> teamabbr = new Vector<String>();
	private Vector<String> lg = new Vector<String>();
	private Vector<Integer> g = new Vector<Integer>();
	private Vector<Integer> pts = new Vector<Integer>();
	
	public String getNamebirth(){
		return namebirth;
	}
	public Vector<String> getSeason(){
		return season;
	}
	public Vector<String> getTeamabbr(){
		return teamabbr;
	}
	public Vector<String> getLg(){
		return lg;
	}
	public Vector<Integer> getG(){
		return g;
	}
	public Vector<Integer> getPts(){
		return pts;
	}
	
	public void setNamebirth(String a){
		namebirth = a;
	}
	public void addSeason(String a){
		season.add(a);
	}
	public void addTeamabbr(String a){
		teamabbr.add(a);
	}
	public void addLg(String a){
		lg.add(a);
	}
	public void addG(int a){
		g.add(a);
	}
	public void addPts(int a){
		pts.add(a);
	}
}
