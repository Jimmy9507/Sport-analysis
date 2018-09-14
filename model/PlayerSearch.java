package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import data.Record;

public class PlayerSearch {
	private Vector<Player> players;

	public void setPlayers(Vector<Record> records){
		players = new Vector<Player>();
		char[] blank = new char[80];
		Arrays.fill(blank,' ');
			
		for (Record i:records) {
			int index = -1;
			String s = i.getName() + new String(blank,0,(80-i.getName().length())) + i.getBirth();
			for(int j=0;j<players.size();j++){
				if(players.get(j).getNamebirth().equals(s)){
					index = j;
					break;
				}
			}
			if(index<0){
				Player player = new Player();
				player.setNamebirth(s);
				player.addSeason(i.getSeason());
				player.addTeamabbr(i.getTeamabbr());
				player.addLg(i.getLg());
				player.addG(i.getG());
				player.addPts(i.getPts());
				players.add(player);
			}
			else{
				players.get(index).addSeason(i.getSeason());
				players.get(index).addTeamabbr(i.getTeamabbr());
				players.get(index).addLg(i.getLg());
				players.get(index).addG(i.getG());
				players.get(index).addPts(i.getPts());
			}
		}
		
		Collections.sort(players,new Comparator(){
			public int compare(Object o1, Object o2) {
				Player a = (Player)o1;
				Player b = (Player)o2;
				return a.getNamebirth().compareTo(b.getNamebirth());
			}
		});
	}

	public Vector<Player> searchName(String s) {
		if (s.equals("")) {
			return players;
		} else {
			Vector<Player> result = new Vector<Player>();

			for (Player i : players) {
				if (i.getNamebirth().indexOf(s) >= 0) {
					result.add(i);
				}
			}

			return result;
		}
	}

	public Vector<Player> searchSeason(String s) {
		if (s.equals("")) {
			return players;
		} else {
			Vector<Player> result = new Vector<Player>();

			for (Player i : players) {
				for (String j : i.getSeason()) {
					if (j.indexOf(s) == 0) {
						result.add(i);
					}
				}
			}

			return result;
		}
	}
}
