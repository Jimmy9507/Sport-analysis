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

import model.Coach;
import model.CoachSearch;

public class coachceshi extends Application{
  public void start(Stage primaryStage) {
    
    primaryStage.setTitle("Welcome NBAStation");
    primaryStage.show();
    
    BorderPane border = new BorderPane();
    Scene scene = new Scene(border, 1000, 800);
    primaryStage.setScene(scene);
    
    
    File file = new File("data.txt");
    ReadData reader = new ReadData();
    Vector<Record> records= reader.read();
    
    CoachSearch searcher = new CoachSearch();
    searcher.setCoaches(records);
    Vector<Coach> coaches = searcher.searchName("");

    CoachUI coachUI01=new CoachUI();
    //for(String s:players.get(0).getSeason()){
     // System.out.println(s);
   // }
   // playerUI01.setPlayer(player01);
    coachUI01.addList(coaches.get(6));
    coachUI01.start(primaryStage);
    
    
    
  }
  
  public static void main(String[] args) {
    
    launch(args);

  }

}
