package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import data.Record;

public class CoachSearch {
	private Vector<Coach> coaches;

	public void setCoaches(Vector<Record> records){
		coaches = new Vector<Coach>();
			
		for (Record i:records) {
			if(i.getTeamcoach().equals("")){
				
			}
			else{
				int index = -1;
				for(int j=0;j<coaches.size();j++){
					if(coaches.get(j).getTeamcoach().equals(i.getTeamcoach())){
						index = j;
						break;
					}
				}
				if(index<0){
					Coach coach = new Coach();
					coach.setTeamcoach(i.getTeamcoach());
					coach.addSeason(i.getSeason());
					coach.addTeamname(i.getTeamname());
					coaches.add(coach);
				}
				else{
					if(i.getTeamname().equals(coaches.get(index).getTeamname().lastElement())){
						coaches.get(index).getSeason().set(coaches.get(index).getSeason().size()-1,coaches.get(index).getSeason().lastElement().replace(coaches.get(index).getSeason().lastElement().substring(0, 4), i.getSeason().substring(0, 4)));
					}
					else{
						coaches.get(index).addSeason(i.getSeason());
						coaches.get(index).addTeamname(i.getTeamname());
					}
				}
			}
		}
			
		
		Collections.sort(coaches,new Comparator(){
			public int compare(Object o1, Object o2) {
				Coach a = (Coach)o1;
				Coach b = (Coach)o2;
				return a.getTeamcoach().compareTo(b.getTeamcoach());
			}
		});
	}

	public Vector<Coach> searchName(String s) {
		if (s.equals("")) {
			return coaches;
		}
		else {
			Vector<Coach> result = new Vector<Coach>();

			for (Coach i : coaches) {
				if (i.getTeamcoach().indexOf(s) >= 0) {
					result.add(i);
				}
			}

			return result;
		}
	}

	public Vector<Coach> searchSeason(String s) {
		if (s.equals("")) {
			return coaches;
		}
		else {
			Vector<Coach> result = new Vector<Coach>();

			for (Coach i : coaches) {
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
