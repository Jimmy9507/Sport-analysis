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

import model.Coach;
import model.Player;
import ui.PlayerUI.Person;
import javafx.scene.Scene;
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



public class CoachUI extends Application {
  
  
  private final TableView<Person> coachtable = new TableView<>();
  
  List<Person> coachdata = new ArrayList<Person>(); 
  
  public void addList(Coach coach){
    for(int i=0;i<coach.getSeason().size();i++){
      coachdata.add(new Person(coach.getSeason().get(i),coach.getTeamname().get(i),coach.getTeamcoach()));
    
      }
  }
  
  private final ObservableList<Person> data =FXCollections.observableList(coachdata);
    
  
  @Override
  public void start(Stage primaryStage) {
                    
          primaryStage.setTitle("CoachImformation");
          primaryStage.show();
          primaryStage.setResizable(false);
    
          BorderPane border = new BorderPane();
          Scene scene = new Scene(border, 800, 600);
          primaryStage.setScene(scene);
          
          scene.getStylesheets().add(getClass().getResource("imformation.css").toExternalForm());
          
          GridPane grid1 = new GridPane();
          grid1.setId("coach_Top");
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
          Label l00=new Label("教练名字:");
          TextField coach_name = new TextField ();
          coach_name.setText(coachdata.get(0).getTeamcoach());
          coach_name.setEditable(false);
     
          grid1.add(l00,9,3,2,1);
          grid1.add(coach_name, 11,3,3,1);
         
          

          
          //选项列表
          ListView<String> list = new ListView<>();
          ObservableList<String> items =FXCollections.observableArrayList (
               "教练经历");
          list.setItems(items);
          list.setPrefWidth(100);
          list.setPrefHeight(70);
          grid2.add(list,0,1,6,5);
          
          list.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends String> ov, String old_val,
            String new_val) -> {
              if(new_val=="教练经历"){
              coachtable.setVisible(true);
              }
            });
          
          
          //球员生涯表格
          TableColumn season = new TableColumn("赛季");
          TableColumn teamname = new TableColumn("执教球队");

          coachtable.getColumns().addAll(season, teamname);
          coachtable.setEditable(false);
          final VBox vbox = new VBox(); 
          vbox.setSpacing(5);
          vbox.setPadding(new Insets(10, 0, 0, 10));
          vbox.getChildren().addAll( coachtable);
          grid2.add(coachtable,5,1,20,15);
          
          season.setMinWidth(200);
          season.setCellValueFactory(new PropertyValueFactory<>("season"));
 
          teamname.setMinWidth(200);
          teamname.setCellValueFactory(
                  new PropertyValueFactory<>("teamname"));
   
          coachtable.setItems(data);
          

          
  }         
         
  public static class Person {
    private final SimpleStringProperty season;
    private final SimpleStringProperty teamname;
    private final SimpleStringProperty teamcoach;

    private Person(String S, String N, String C) {
        this.season = new SimpleStringProperty(S);
        this.teamname = new SimpleStringProperty(N);
        this.teamcoach = new SimpleStringProperty(C);

    }
 
    public String getSeason() {
        return season.get();
    }
    public void setSeaon(String S) {
        season.set(S);
    }
 
    
    public String getTeamname() {
        return teamname.get();
    }
    public void setLg(String N) {
        teamname.set(N);
    }
 
    public String getTeamcoach() {
        return teamcoach.get();
    }
 
    public void setTeamcaoch(String C) {
        teamcoach.set(C);
    }
    
   
}       
}