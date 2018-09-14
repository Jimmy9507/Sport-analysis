package ui;

import java.awt.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import model.Team;

import ui.PlayerUI.Person;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;



public class TeamUI extends Application {
  
  
  //private TextArea team_all = new TextArea ();
  
  private final TableView<Person01> teamtable01 = new TableView<>();
  private final TableView<Person02> teamtable02 = new TableView<>();
  private final TableView<Person01> teamtable03 = new TableView<>();
  
  List<Person01> teamcoachdata = new ArrayList<Person01>(); 
  List<Person02> teamarenadata = new ArrayList<Person02>(); 
  List<Person01> teamdata = new ArrayList<Person01>(); 
  
  public void addList01(Team teams){
    for(int i=0;i<teams.getSeason().size();i++){
      teamcoachdata.add(new Person01(teams.getSeason().get(i),teams.getTeamcoach().get(i),teams.getTeamname(),teams.getTeamg(),teams.getTeamw(),teams.getTeaml(),teams.getTeamchamp(),teams.getTeamfrom(),teams.getTeamyrs()));
    //System.out.println(playerdata.get(i).getNamebirth());
      }
  }
  
  public void addList02(Team teams){
    for(int i=0;i<teams.getArenatime().size();i++){
      teamarenadata.add(new Person02(teams.getArenatime().get(i),teams.getArena().get(i),teams.getArenalocation().get(i),teams.getArenacapacity().get(i)));   
    //System.out.println(playerdata.get(i).getNamebirth());
      }
  }  
  
  public void addList03(Team teams){
  teamdata.add(new Person01(teams.getSeason().get(0),teams.getTeamcoach().get(0),teams.getTeamname(),teams.getTeamg(),teams.getTeamw(),teams.getTeaml(),teams.getTeamchamp(),teams.getTeamfrom(),teams.getTeamyrs()));
  //System.out.println(teamdata.get(0).getWin());
  }
  
  private final ObservableList<Person01> data01 =FXCollections.observableList(teamcoachdata);
  private final ObservableList<Person02> data02 =FXCollections.observableList(teamarenadata);
  private final ObservableList<Person01> data03 =FXCollections.observableList(teamdata);
  
  final PieChart chart = new PieChart();
  
  @Override
  public void start(Stage primaryStage) {
                    
          primaryStage.setTitle("Team Imformation");
          primaryStage.show();
          primaryStage.setResizable(false);
    
          BorderPane border = new BorderPane();
          Scene scene = new Scene(border, 800, 600);
          primaryStage.setScene(scene);
          
          scene.getStylesheets().add(getClass().getResource("imformation.css").toExternalForm());
          
          GridPane grid1 = new GridPane();
          grid1.setId("team_Top");
          grid1.setHgap(30);
          grid1.setVgap(30);
          grid1.setPadding(new Insets(0, 10, 0, 10));
          border.setTop(grid1);
          
          GridPane grid2 = new GridPane();
          grid2.setHgap(30);
          grid2.setVgap(30);
          grid2.setPadding(new Insets(0, 10, 0, 10));
          border.setCenter(grid2);
           
          //grid1.setGridLinesVisible(true);
         // grid2.setGridLinesVisible(true);
          
          
          //球队名字
          Label l00=new Label("球队全称:");
          TextField team_name = new TextField ();
          team_name.setText(teamcoachdata.get(0).getTeamname());
          team_name.setEditable(false);
     
          grid1.add(l00,0,3,2,1);
          grid1.add(team_name, 2,3,3,1);
         
          
          //球队成立年份
          Label l01=new Label("成立时间:");
          TextField team_birth = new TextField ();
          team_birth.setText(String.valueOf(teamcoachdata.get(0).getTeamfrom()));
          team_birth.setEditable(false);
          grid1.add(l01, 6,3,2,1);
          grid1.add(team_birth,8,3,3,1);
          
          //球队成立时长
          Label l02=new Label("成立时长:");
          TextField team_life = new TextField ();
          team_life.setText(String.valueOf(teamcoachdata.get(0).getTeamyrs()));
          team_life.setEditable(false);
          grid1.add(l02, 12,3,2,1);
          grid1.add(team_life,14,3,3,1);
          
          //球队选项列表
          ListView<String> list = new ListView<>();
          ObservableList<String> items =FXCollections.observableArrayList (
              "球队总览", "球队教练关系","球队场馆关系");
          list.setItems(items);
          list.setPrefWidth(100);
          list.setPrefHeight(70);
          grid2.add(list,0,1,6,5);
          
          list.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends String> ov, String old_val,
            String new_val) -> {
              if(new_val=="球队总览"){
              teamtable01.setVisible(false);
              teamtable02.setVisible(false);
              teamtable03.setVisible(true); 
              chart.setVisible(true);
              }
              if(new_val=="球队教练关系"){
              teamtable01.setVisible(true);
              teamtable02.setVisible(false);
              teamtable03.setVisible(false);
              chart.setVisible(false);
              }
              if(new_val=="球队场馆关系"){
              teamtable01.setVisible(false);
              teamtable02.setVisible(true);
              teamtable03.setVisible(false);   
              chart.setVisible(false);
              }             
            });
          
          
          //球队教练表格
          TableColumn season = new TableColumn("赛季");
          TableColumn teamcoach = new TableColumn("教练");

          teamtable01.getColumns().addAll(season, teamcoach);
          teamtable01.setEditable(false);
          final VBox vbox01 = new VBox(); 
          vbox01.setSpacing(5);
          vbox01.setPadding(new Insets(10, 0, 0, 10));
          vbox01.getChildren().addAll( teamtable01);
          grid2.add(teamtable01,5,1,20,15);
          
          teamtable01.setItems(data01);
          
          season.setMinWidth(200);
          season.setCellValueFactory(
                  new PropertyValueFactory<>("season"));
 
          teamcoach.setMinWidth(200);
          teamcoach.setCellValueFactory(
                  new PropertyValueFactory<>("teamcoach"));
   

          //球队总览表格
          TableColumn game = new TableColumn("比赛数");
          TableColumn win = new TableColumn("胜利数");
          TableColumn lose = new TableColumn("失败数");
          TableColumn champion = new TableColumn("冠军数");
          
          teamtable03.getColumns().addAll(game, win,lose,champion);
          teamtable03.setEditable(false);
          final VBox vbox03 = new VBox(); 
          vbox03.setSpacing(5);
          vbox03.setPadding(new Insets(10, 0, 0, 10));
          vbox03.getChildren().addAll( teamtable03);
          grid2.add(teamtable03,5,1,20,3);
          
          teamtable03.setItems(data03);
          teamtable03.setVisible(false);
          
          game.setMinWidth(100);
          game.setCellValueFactory(
                  new PropertyValueFactory<>("game"));
 
          win.setMinWidth(100);
          win.setCellValueFactory(
                  new PropertyValueFactory<>("win"));
          
          lose.setMinWidth(100);
          lose.setCellValueFactory(
                  new PropertyValueFactory<>("lose"));

          champion.setMinWidth(100);
          champion.setCellValueFactory(
                  new PropertyValueFactory<>("champion"));
          
          //球队总览饼图
          List<PieChart.Data> teamwldata=new ArrayList<PieChart.Data>();
          
          teamwldata.add(new PieChart.Data("lose",teamdata.get(0).getLose() ));
          teamwldata.add(new PieChart.Data("win",teamdata.get(0).getWin() ));
          

          
          ObservableList<PieChart.Data> pieChartData =
              FXCollections.observableArrayList(teamwldata);
              
          chart.setData(pieChartData);

          grid2.add(chart,8,3,10,14);
          chart.setVisible(false);
          
          //球队场馆表格
          TableColumn arenatime = new TableColumn("赛季");
          TableColumn arena = new TableColumn("场馆");
          TableColumn arenalocation = new TableColumn("场馆位置");
          TableColumn arenacapacity = new TableColumn("场馆容量");
          
          teamtable02.getColumns().addAll( arenatime, arena, arenalocation, arenacapacity);
          teamtable02.setEditable(false);
          final VBox vbox02 = new VBox(); 
          vbox02.setSpacing(5);
          vbox02.setPadding(new Insets(10, 0, 0, 10));
          vbox02.getChildren().addAll( teamtable02);
          grid2.add(teamtable02,5,1,20,15);
          
          arenatime.setMinWidth(100);
          arenatime.setCellValueFactory(
                  new PropertyValueFactory<>("arenatime"));
          
          arena.setMinWidth(200);
          arena.setCellValueFactory(
                  new PropertyValueFactory<>("arena"));
                  
          arenalocation.setMinWidth(100);
          arenalocation.setCellValueFactory(
                  new PropertyValueFactory<>("arenalocation"));                  
                 
          arenacapacity.setMinWidth(100);
          arenacapacity.setCellValueFactory(
                  new PropertyValueFactory<>("arenacapacity"));   
          
          teamtable02.setItems(data02);
          teamtable02.setVisible(false);
          

  }         

          
public static class Person01 {
    private final SimpleStringProperty season;
    private final SimpleStringProperty teamcoach;
    private final SimpleStringProperty teamname;
    private final SimpleIntegerProperty game;
    private final SimpleIntegerProperty win;
    private final SimpleIntegerProperty lose;
    private final SimpleIntegerProperty champion;
    private final SimpleIntegerProperty teamfrom;
    private final SimpleIntegerProperty teamyrs;
    
 
    private Person01(String S, String C,String N,int G,int W,int O,int M,int F,int Y) {
    this.season = new SimpleStringProperty(S);
    this.teamcoach = new SimpleStringProperty(C);
    this.teamname = new SimpleStringProperty(N);
    this.game = new SimpleIntegerProperty(G);
    this.win = new SimpleIntegerProperty(W);
    this.lose = new SimpleIntegerProperty(O);
    this.champion = new SimpleIntegerProperty(M);
    this.teamfrom = new SimpleIntegerProperty(F);
    this.teamyrs = new SimpleIntegerProperty(Y);
    }
 
    public String getSeason() {
        return season.get();
    }
    public void setSeaon(String S) {
        season.set(S);
    }
  
  
    public String getTeamcoach() {
        return teamcoach.get();
    }
    public void setTeamcoach(String C) {
      teamcoach.set(C);
    }
    
    
    public String getTeamname() {
      return teamname.get();
   }
    public void setTeamname(String N) {
      teamname.set(N);
   }

   
    public int getGame() {
      return game.get();
   }
    public void setGame(int G) {
     game.set(G);
   }
   

    public int getWin() {
      return win.get();
   }
    public void setWin(int W) {
     win.set(W);
   }
   
         
    public int getLose() {
      return lose.get();
   }
    public void setLose(int O) {
     lose.set(O);
   }
   
            
    public int getChampion() {
      return champion.get();
   }
    public void setChampion(int M) {
     champion.set(M);
   }  
    
    
    public int getTeamfrom() {
      return teamfrom.get();
   }
    public void setTeamfrom(int F) {
      teamfrom.set(F);
   }  
    
    
    public int getTeamyrs() {
      return teamyrs.get();
   }
    public void setTeamyrs(int Y) {
     teamyrs.set(Y);
   }  
    
}

public static class Person02{
  
  private final SimpleStringProperty arenatime;
  private final SimpleStringProperty arena;
  private final SimpleStringProperty arenalocation;
  private final SimpleIntegerProperty arenacapacity;
  
   private  Person02( String T, String A,String L,int C) {
    this.arenatime =new SimpleStringProperty(T);
    this.arena = new SimpleStringProperty(A);
    this.arenalocation=new SimpleStringProperty(L);
    this.arenacapacity = new SimpleIntegerProperty(C);
  }
  
  public String getArenatime() {
    return arenatime.get();
  }
  public void setArenatime(String T) {
  arenatime.set(T);
  }  
  
  public String getArena() {
      return arena.get();
  }
  public void setArena(String A) {
    arena.set(A);
  }
  
  
  public String getArenalocation() {
    return arenalocation.get();
  }
  public void setarenAlocation(String N) {
    arenalocation.set(N);
  }
  
  
  public int getArenacapacity() {
    return arenacapacity.get();
 }
  public void setArenacapacity(int C) {
    arenacapacity.set(C);
 }
  }
}