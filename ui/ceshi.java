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

import model.Player;
import model.PlayerSearch;

public class ceshi extends Application{
  public void start(Stage primaryStage) {
    
    primaryStage.setTitle("Welcome NBAStation");
    primaryStage.show();
    
    BorderPane border = new BorderPane();
    Scene scene = new Scene(border, 1000, 800);
    primaryStage.setScene(scene);
    
    
    File file = new File("data.txt");
    ReadData reader = new ReadData();
    Vector<Record> records= reader.read();
    
    PlayerSearch searcher = new PlayerSearch();
    searcher.setPlayers(records);
    Vector<Player> players = searcher.searchName("");

    PlayerUI playerUI01=new PlayerUI();
    //for(String s:players.get(0).getSeason()){
     // System.out.println(s);
   // }
   // playerUI01.setPlayer(player01);
    playerUI01.addList(players.get(0));
    playerUI01.start(primaryStage);
    
    
    
  }
  
  public static void main(String[] args) {
    
   
    
   // PlayerUI playerUI01=new PlayerUI();
    //Stage stage=new Stage();
   // playerUI01.start(stage);
    launch(args);
  // player01UI.setPlayer(player01);
    
  }

}
