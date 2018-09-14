package data;

public class Record {
	private String name;// ��Ա����
	private int birth;//��Ա����
	private String season;// ��ǰ����
	private int age;// ��Ա�ڵ�ǰ����������
	private String teamabbr;// ��ǰ���������������д
	private String lg;// ����
	private int g;// ��ǰ�����Ѵ�ı�����
	private int pts;// ��ǰ�����ѵ÷���
	private String teamname;// ��ǰ�����������
	private String teamcoach;// ��ǰ����������ӽ���
	private int teamfrom;// ������ӽ���ʱ��
	private int teamto;// ������ӽ���ʱ��
	private int teamyrs;// ������Ӵ���ʱ�䳤��
	private int teamg;// ������Ӿ����ı�����
	private int teamw;// �������Ӯ�õı�����
	private int teaml;// �������ʧ�ܵı�����
	private int teamchamp;// �������Ӯ�õĹھ���
	private String arenatime;// ������ӵ�ǰ����ʹ�õ���������ʼ����ʱ��
	private String arena;// ������ӵ�ǰ����ʹ�õ�����������
	private String arenalocation;// ������ӵ�ǰ����ʹ�õ����������ڵ�
	private int arenacapacity;// ������ӵ�ǰ����ʹ�õ�������������
	

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
