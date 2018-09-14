package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import data.Record;

public class TeamSearch {
	private Vector<Team> teams;

	public void setTeams(Vector<Record> records){
		teams = new Vector<Team>();
			
		for (Record i:records) {
			if(i.getTeamname().equals("")){
				
			}
			else{
				int index = -1;
				for(int j=0;j<teams.size();j++){
					if(teams.get(j).getTeamname().equals(i.getTeamname())){
						index = j;
						break;
					}
				}
				if(index<0){
					Team team = new Team();
					team.setTeamname(i.getTeamname());
					team.setTeamfrom(i.getTeamfrom());
					team.setTeamto(i.getTeamto());
					team.setTeamyrs(i.getTeamyrs());
					team.setTeamg(i.getTeamg());
					team.setTeamw(i.getTeamw());
					team.setTeaml(i.getTeaml());
					team.setTeamchamp(i.getTeamchamp());
					team.addSeason(i.getSeason());
					team.addTeamcoach(i.getTeamcoach());
					team.addArenatime(i.getArenatime());
					team.addArena(i.getArena());
					team.addArenalocation(i.getArenalocation());
					team.addArenaCapacity(i.getArenacapacity());
					teams.add(team);
				}
				else{
					if(i.getTeamcoach().equals(teams.get(index).getTeamcoach().lastElement())){
						teams.get(index).getSeason().set(teams.get(index).getSeason().size()-1,teams.get(index).getSeason().lastElement().replace(teams.get(index).getSeason().lastElement().substring(0, 4), i.getSeason().substring(0, 4)));
					}
					else{
						teams.get(index).addSeason(i.getSeason());
						teams.get(index).addTeamcoach(i.getTeamcoach());
					}
					if(i.getArenatime().equals(teams.get(index).getArenatime().lastElement())){
						
					}
					else{
						teams.get(index).addArenatime(i.getArenatime());
						teams.get(index).addArena(i.getArena());
						teams.get(index).addArenalocation(i.getArenalocation());
						teams.get(index).addArenaCapacity(i.getArenacapacity());
					}
				}
			}
		}
			
		
		Collections.sort(teams,new Comparator(){
			public int compare(Object o1, Object o2) {
				Team a = (Team)o1;
				Team b = (Team)o2;
				return a.getTeamname().compareTo(b.getTeamname());
			}
		});
	}

	public Vector<Team> searchName(String s) {
		if (s.equals("")) {
			return teams;
		}
		else {
			Vector<Team> result = new Vector<Team>();

			for (Team i : teams) {
				if (i.getTeamname().indexOf(s) >= 0) {
					result.add(i);
				}
			}

			return result;
		}
	}

	public Vector<Team> searchSeason(String s) {
		if (s.equals("")) {
			return teams;
		}
		else {
			Vector<Team> result = new Vector<Team>();

			for (Team i : teams) {
				int a = Integer.parseInt(i.getSeason().lastElement().substring(0, 4));
				int b = Integer.parseInt(i.getSeason().firstElement().substring(5, 9));
				int y = Integer.parseInt(s);
				if(y>=a && y<=b){
					result.add(i);
				}
			}

			return result;
		}
	}
}
