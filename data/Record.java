package data;

public class Record {
	private String name;// 球员姓名
	private int birth;//球员出生
	private String season;// 当前赛季
	private int age;// 球员在当前赛季的年龄
	private String teamabbr;// 当前赛季所属球队名缩写
	private String lg;// 联盟
	private int g;// 当前赛季已打的比赛数
	private int pts;// 当前赛季已得分数
	private String teamname;// 当前赛季所属球队
	private String teamcoach;// 当前赛季所属球队教练
	private int teamfrom;// 所属球队建立时间
	private int teamto;// 所属球队结束时间
	private int teamyrs;// 所属球队存在时间长度
	private int teamg;// 所属球队经历的比赛数
	private int teamw;// 所属球队赢得的比赛数
	private int teaml;// 所属球队失败的比赛数
	private int teamchamp;// 所属球队赢得的冠军数
	private String arenatime;// 所属球队当前赛季使用的体育场开始结束时间
	private String arena;// 所属球队当前赛季使用的体育场名称
	private String arenalocation;// 所属球队当前赛季使用的体育场所在地
	private int arenacapacity;// 所属球队当前赛季使用的体育场的容量
	

	public String getName() {
		return name;
	}
	
	public int getBirth() {
		return birth;
	}
	
	public String getSeason() {
		return season;
	}

	public int getAge() {
		return age;
	}

	public String getTeamabbr() {
		return teamabbr;
	}

	public String getLg() {
		return lg;
	}

	public int getG() {
		return g;
	}

	public int getPts() {
		return pts;
	}

	public String getTeamname() {
		return teamname;
	}

	public String getTeamcoach() {
		return teamcoach;
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

	public String getArenatime() {
		return arenatime;
	}

	public String getArena() {
		return arena;
	}

	public String getArenalocation() {
		return arenalocation;
	}

	public int getArenacapacity() {
		return arenacapacity;
	}

	

	public void setAll(String[] a) {
		name = a[1];
		season = a[2];
		if (!a[3].equals("")) {
			age = Integer.parseInt(a[3]);
		}
		if(age != 0){
			birth = Integer.parseInt(season.substring(0, 4)) - age;
		}
		teamabbr = a[4];
		lg = a[5];
		if (!a[6].equals("")) {
			g = Integer.parseInt(a[6]);
		}
		if (!a[7].equals("")) {
			pts = Integer.parseInt(a[7]);
		}
		teamname = a[10];
		teamcoach = a[11];
		if (!a[12].equals("")) {
			teamfrom = Integer.parseInt(a[12]);
		}
		if (!a[13].equals("")) {
			teamto = Integer.parseInt(a[13]);
		}
		if (!a[14].equals("")) {
			teamyrs = Integer.parseInt(a[14]);
		}
		if (!a[15].equals("")) {
			teamg = Integer.parseInt(a[15]);
		}
		if (!a[16].equals("")) {
			teamw = Integer.parseInt(a[16]);
		}
		if (!a[17].equals("")) {
			teaml = Integer.parseInt(a[17]);
		}
		if (!a[18].equals("")) {
			teamchamp = Integer.parseInt(a[18]);
		}
		arenatime = a[20];
		arena = a[21];
		arenalocation = a[22];
		if (!a[23].equals("")) {
			arenacapacity = Integer.parseInt(a[23]);
		}	
	}
}
