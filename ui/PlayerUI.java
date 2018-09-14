package ui;

import java.awt.Font;

import java.util.ArrayList;
import java.util.LinkedList;
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
import model.Player;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;



public class PlayerUI extends Application {
  
  //定义折线图
  final CategoryAxis xAxis = new CategoryAxis();
  final NumberAxis yAxis = new NumberAxis();
  final LineChart<String,Number> lineChart = 
          new LineChart<String,Number>(xAxis,yAxis);
  
  //定义表格
  private final TableView<Person> playertable = new TableView<>();
  List<Person> playerdata = new ArrayList<Person>(); 
  public void addList(Player players){
    for(int i=0;i<players.getSeason().size();i++){
      playerdata.add(new Person(players.getSeason().get(i),players.getTeamabbr().get(i),players.getLg().get(i),players.getG().get(i),players.getPts().get(i),players.getNamebirth()));

      }
  }
  private final ObservableList<Person> data =FXCollections.observableList(playerdata);

  //start类
  @Override
  public void start(Stage primaryStage) {
                    
          primaryStage.setTitle("PlayerImformation");
          primaryStage.show();
          primaryStage.setResizable(false);
    
          BorderPane border = new BorderPane();
          Scene scene = new Scene(border, 800, 600);
          primaryStage.setScene(scene);
          
          scene.getStylesheets().add(getClass().getResource("imformation.css").toExternalForm());
          
          GridPane grid1 = new GridPane();
          grid1.setId("player_Top");
          grid1.setHgap(30);
          grid1.setVgap(30);
          grid1.setPadding(new Insets(0, 10, 0, 10));
          border.setTop(grid1);
          
          GridPane grid2 = new GridPane();
          grid2.setHgap(30);
          grid2.setVgap(30);
          grid2.setPadding(new Insets(0, 10, 0, 10));
          border.setCenter(grid2);
           
                  
          //球员名字
          Label l00=new Label("球员名字:");
          TextField player_name = new TextField ();
          player_name.setText(playerdata.get(0).getNamebirth().substring(0, 80).trim());
          player_name.setEditable(false);
     
          grid1.add(l00,0,3,2,1);
          grid1.add(player_name, 2,3,3,1);
                
          //球员出生年份
          Label l01=new Label("出生年份:");
          TextField player_birth = new TextField ();
          player_birth.setText(playerdata.get(0).getNamebirth().substring(80));
          player_birth.setEditable(false);
          grid1.add(l01, 6,3,2,1);
          grid1.add(player_birth,8,3,3,1);
          
          //球员生涯长度
          Label l02=new Label("生涯长度:");
          TextField player_life = new TextField ();
          player_life.setText(String.valueOf(playerdata.size()));
          player_life.setEditable(false);
          grid1.add(l02, 12,3,2,1);
          grid1.add(player_life,14,3,3,1);
          
          //选项列表
          ListView<String> list = new ListView<>();
          ObservableList<String> items =FXCollections.observableArrayList (
              "球员生涯经历", "球员得分图表");
          list.setItems(items);
          list.setPrefWidth(100);
          list.setPrefHeight(70);
          grid2.add(list,0,1,6,5);
          
          list.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends String> ov, String old_val,
            String new_val) -> {
              if(new_val=="球员得分图表"){
              playertable.setVisible(false);
              lineChart.setVisible(true);
              }
              if(new_val=="球员生涯经历"){
              playertable.setVisible(true);
              lineChart.setVisible(false);
              }
            });
          
          
          //球员生涯表格
          TableColumn season = new TableColumn("赛季");
          TableColumn teamabbr = new TableColumn("球队");
          TableColumn lg = new TableColumn("赛季");
          TableColumn game = new TableColumn("比赛数");
          TableColumn pts = new TableColumn("得分");
          playertable.getColumns().addAll(season, teamabbr, lg, game, pts);
          playertable.setEditable(false);
          final VBox vbox = new VBox(); 
          vbox.setSpacing(5);
          vbox.setPadding(new Insets(10, 0, 0, 10));
          vbox.getChildren().addAll( playertable);
          grid2.add(playertable,5,1,20,15); 
          
          season.setMinWidth(100);
          season.setCellValueFactory(new PropertyValueFactory<>("season"));
 
          teamabbr.setMinWidth(100);
          teamabbr.setCellValueFactory(
                  new PropertyValueFactory<>("teamabbr"));
   

          lg.setMinWidth(100);
          lg.setCellValueFactory(
                  new PropertyValueFactory<>("lg"));
          
          game.setMinWidth(100);
          game.setCellValueFactory(
                  new PropertyValueFactory<>("game"));
          
          pts.setMinWidth(100);
          pts.setCellValueFactory(
                  new PropertyValueFactory<>("pts"));
          
          playertable.setItems(data);

          
     
          //球员得分图表
          xAxis.setLabel("赛季");
          yAxis.setLabel("得分");
          lineChart.setTitle("球员得分走势图");

          XYChart.Series series = new XYChart.Series();
          series.setName("得分");
          
          for(int i=(playerdata.size()-1);i>=0;i--)
          {
            series.getData().add(new XYChart.Data(playerdata.get(i).getSeason(), playerdata.get(i).getPts()));
          }
          
          grid2.add(lineChart, 5, 1, 20, 15);
          lineChart.getData().add(series);
          lineChart.setVisible(false);
          
          
  }    
    
 
  
  
  public static class Person {
    private final SimpleStringProperty season;
    private final SimpleStringProperty teamabbr;
    private final SimpleStringProperty lg;
    private final SimpleIntegerProperty game;
    private final SimpleIntegerProperty pts;
    private final SimpleStringProperty namebirth;
 
    private Person(String S, String T, String L,int G,int P,String B) {
        this.season = new SimpleStringProperty(S);
        this.teamabbr = new SimpleStringProperty(T);
        this.lg = new SimpleStringProperty(L);
        this.game = new SimpleIntegerProperty(G);
        this.pts = new SimpleIntegerProperty(P);
        this.namebirth=new SimpleStringProperty(B);
    }
 
    public String getSeason() {
        return season.get();
    }
 
    public void setSeaon(String S) {
        season.set(S);
    }
 
    public String getLg() {
        return lg.get();
    }
 
    public void setLg(String L) {
        lg.set(L);
    }
 
    public String getTeamabbr() {
        return teamabbr.get();
    }
 
    public void setTeamabbr(String T) {
        teamabbr.set(T);
    }
    
    public int getGame() {
      return game.get();
   }

    public void setGame(int G) {
      game.set(G);
   }

    public int getPts() {
      return pts.get();
   }

    public void setPts(int P) {
     pts.set(P);
   }
    
    public String getNamebirth() {
      return namebirth.get();
  }

  public void setNamebirth(String N) {
    namebirth.set(N);
  }
}
          
}