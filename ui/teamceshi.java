package ui;

import java.util.Vector;

import data.ReadData;
import data.Record;

import java.awt.Font;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import model.Team;
import model.TeamSearch;

public class teamceshi extends Application{
  public void start(Stage primaryStage) {
    
    primaryStage.setTitle("Welcome NBAStation");
    primaryStage.show();
    
    BorderPane border = new BorderPane();
    Scene scene = new Scene(border, 1000, 800);
    primaryStage.setScene(scene);
    
    
    File file = new File("data.txt");
    ReadData reader = new ReadData();
    Vector<Record> records= reader.read();
    
    TeamSearch searcher = new TeamSearch();
    searcher.setTeams(records);
    Vector<Team> teams = searcher.searchName("");

    TeamUI teamUI01=new TeamUI();
   // for(String s:teams.get(0).getArena()){
   //   System.out.println(s);
   // }
    teamUI01.addList01(teams.get(0));
    teamUI01.addList02(teams.get(0));
    teamUI01.addList03(teams.get(0));
    teamUI01.start(primaryStage);
    
    
    
  }
  
  public static void main(String[] args) {
    
   
    
   // PlayerUI playerUI01=new PlayerUI();
    //Stage stage=new Stage();
   // playerUI01.start(stage);
    launch(args);
  // player01UI.setPlayer(player01);
    
  }

}

