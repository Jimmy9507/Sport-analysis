package model;

import java.util.Vector;

public class Team {
	private String teamname;
	private int teamfrom;
	private int teamto;
	private int teamyrs;
	private int teamg;
	private int teamw;
	private int teaml;
	private int teamchamp;
	private Vector<String> season = new Vector<String>();
	private Vector<String> teamcoach = new Vector<String>();
	private Vector<String> arenatime = new Vector<String>();
	private Vector<String> arena = new Vector<String>();
	private Vector<String> arenalocation = new Vector<String>();
	private Vector<Integer> arenacapacity = new Vector<Integer>();
	
	public String getTeamname() {
		return teamname;
	}
	public int getTeamfrom() {
		return teamfrom;
	}
	public int getTeamto() {
		return teamto;
	}
	public int getTeamyrs() {
		return teamyrs;
	}
	public int getTeamg() {
		return teamg;
	}
	public int getTeamw() {
		return teamw;
	}
	public int getTeaml() {
		return teaml;
	}
	public int getTeamchamp() {
		return teamchamp;
	}
	public Vector<String> getSeason(){
		return season;
	}
	public Vector<String> getTeamcoach(){
		return teamcoach;
	}
	public Vector<String> getArenatime(){
		return arenatime;
	}
	public Vector<String> getArena(){
		return arena;
	}
	public Vector<String> getArenalocation(){
		return arenalocation;
	}
	public Vector<Integer> getArenacapacity(){
		return arenacapacity;
	}
	
	public void setTeamname(String a){
		teamname = a;
	}
	public void setTeamfrom(int a){
		teamfrom = a;
	}
	public void setTeamto(int a){
		teamto = a;
	}
	public void setTeamyrs(int a){
		teamyrs = a;
	}
	public void setTeamg(int a){
		teamg = a;
	}
	public void setTeamw(int a){
		teamw = a;
	}
	public void setTeaml(int a){
		teaml = a;
	}
	public void setTeamchamp(int a){
		teamchamp = a;
	}
	public void addSeason(String a){
		season.add(a);
	}
	public void addTeamcoach(String a){
		teamcoach.add(a);
	}
	public void addArenatime(String a){
		arenatime.add(a);
	}
	public void addArena(String a){
		arena.add(a);
	}
	public void addArenalocation(String a){
		arenalocation.add(a);
	}
	public void addArenaCapacity(int a){
		arenacapacity.add(a);
	}
}
