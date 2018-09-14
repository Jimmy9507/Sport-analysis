package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Vector;

import data.ReadData;
import data.Record;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Coach;
import model.CoachSearch;
import model.Player;
import model.PlayerSearch;
import model.Team;
import model.TeamSearch;
import ui.PlayerUI;

public class MainUI extends Application{
    private int mode = -1;
    private int choice = 1;
    private Vector<Player> players = new Vector<Player>();
    private Vector<Team> teams = new Vector<Team>();
    private Vector<Coach> coaches = new Vector<Coach>();
	private ListView<String> list = new ListView<String>();


	
	@Override
    public void start(Stage primarystage)  {
        // Use a border pane as the root for scene
       BorderPane border = new BorderPane();

       ReadData reader = new ReadData();
       Vector<Record> records= reader.read();

       PlayerSearch ps = new PlayerSearch();
       CoachSearch cs = new CoachSearch();
       TeamSearch ts = new TeamSearch();
       ps.setPlayers(records);
       cs.setCoaches(records);
       ts.setTeams(records);

        // …Ë÷√hbox
       HBox hbox = new HBox();
       VBox vbox = new VBox();
       vbox.setSpacing(20);
       hbox.setSpacing(500);
       hbox.getStyleClass().add("hbox");

       Label lb = new Label();
       lb.setPrefSize(130, 40);
       lb.setTextFill(Color.web("#eae1e1"));
       lb.setFont(new Font("Arial",35));
       final ToggleGroup group = new ToggleGroup();
       RadioButton rb1 = new RadioButton("Name");
       rb1.setPrefSize(70, 10);
       rb1.setTextFill(Color.web("#eae1e1"));
       rb1.setToggleGroup(group);
       rb1.setSelected(true);
       RadioButton rb2 = new RadioButton("Season");
       rb2.setPrefSize(70, 10);
       rb2.setTextFill(Color.web("#eae1e1"));
       rb2.setToggleGroup(group);
       group.selectedToggleProperty().addListener(
    		   new ChangeListener<Toggle>(){
    			   public void changed(ObservableValue<? extends Toggle>ov,Toggle old_toggle,Toggle new_toggle){
    				   if(group.getSelectedToggle() == rb1){choice = 1;}
    				   else { choice = 2;}
    			   }
    		   });

       TextField textSearch = new TextField();
       textSearch.setPrefSize(250, 40);
       Button buttonSearch = new Button("À—À˜");
       buttonSearch.setPrefSize(100, 40);

       buttonSearch.setId("button-custom");
       vbox.getChildren().addAll(rb1,rb2);
       hbox.getChildren().addAll(lb,vbox,textSearch, buttonSearch);
       border.setTop(hbox);

        //…Ë÷√vboxl
    	VBox vboxL = new VBox();
        vboxL.getStyleClass().addAll("pane", "vboxL");
        Image imagePlayer = new Image(getClass().getResourceAsStream("buttonPlayer.jpg"));
        Button buttonPlayer = new Button();
        buttonPlayer.setGraphic(new ImageView(imagePlayer));

        Image imageTeam = new Image(getClass().getResourceAsStream("buttonTeam.jpg"));
        Button buttonTeam = new Button();
        buttonTeam.setGraphic(new ImageView(imageTeam));

        Image imageCoach = new Image(getClass().getResourceAsStream("buttonCoach.jpg"));
        Button buttonCoach = new Button();
        buttonCoach.setGraphic(new ImageView(imageCoach));


        vboxL.getChildren().addAll(buttonPlayer,buttonTeam,buttonCoach);
        border.setLeft(vboxL);


        //…Ë÷√vboxR
    	VBox vboxR = new VBox();
    	vboxR.getStyleClass().add("vboxR");


    	vboxR.getChildren().addAll(list);
    	border.setCenter(vboxR);

    	buttonPlayer.setOnAction((ActionEvent e) -> {
    		list.setItems(null);
    		mode=0;
    		lb.setText("Player :");
        });
    	buttonTeam.setOnAction((ActionEvent e) -> {
    		list.setItems(null);
    		mode=1;
    		lb.setText("Team :");
        });
    	buttonCoach.setOnAction((ActionEvent e) -> {
    		list.setItems(null);
    		mode=2;
    		lb.setText("Coach :");
        });



        buttonSearch.setOnAction((ActionEvent e) -> {
        	if(mode == 0&&choice == 1){
        		list.setItems(null);
        		players = ps.searchName(textSearch.getText());
            	Vector<String> names = new Vector<String>();
            	for(int i=0 ;i <players.size();i++){
            		names.add(players.get(i).getNamebirth());
            	}
            	ObservableList<String> items = FXCollections.observableArrayList (names);
            	list.setItems(items);
        	}
        	if(mode == 0&&choice == 2){
        		list.setItems(null);
        		players = ps.searchSeason(textSearch.getText());
            	Vector<String> names = new Vector<String>();
            	for(int i=0 ;i <players.size();i++){
            		names.add(players.get(i).getNamebirth());
            	}
            	ObservableList<String> items = FXCollections.observableArrayList (names);
            	list.setItems(items);
        	}
        	if(mode == 1&&choice == 1){
        		list.setItems(null);
        		teams = ts.searchName(textSearch.getText());
            	Vector<String> names = new Vector<String>();
            	for(int i=0 ;i <teams.size();i++){
            		names.add(teams.get(i).getTeamname());
            	}
            	ObservableList<String> items = FXCollections.observableArrayList (names);
            	list.setItems(items);
        	}
        	if(mode == 1&&choice == 2){
        		list.setItems(null);
        		teams = ts.searchSeason(textSearch.getText());
            	Vector<String> names = new Vector<String>();
            	for(int i=0 ;i <teams.size();i++){
            		names.add(teams.get(i).getTeamname());
            	}
            	ObservableList<String> items = FXCollections.observableArrayList (names);
            	list.setItems(items);
        	}
        	if(mode == 2&&choice == 1){
        		list.setItems(null);
        		coaches = cs.searchName(textSearch.getText());
            	Vector<String> names = new Vector<String>();
            	for(int i=0 ;i <coaches.size();i++){
            		names.add(coaches.get(i).getTeamcoach());
            	}
            	ObservableList<String> items = FXCollections.observableArrayList (names);
            	list.setItems(items);
        	}
        	if(mode == 2&&choice == 2){
        		list.setItems(null);
        		coaches = cs.searchSeason(textSearch.getText());
            	Vector<String> names = new Vector<String>();
            	for(int i=0 ;i <coaches.size();i++){
            		names.add(coaches.get(i).getTeamcoach());
            	}
            	ObservableList<String> items = FXCollections.observableArrayList (names);
            	list.setItems(items);
        	}

        });
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           if(mode == 0){
        	    Player player = new Player();
              	for(Player i:players){
              		if(i.getNamebirth().equals(newValue)){

              			player = i;
              		}
              	}
              	if(player.getNamebirth() != null){
              		PlayerUI a=new PlayerUI();
                  	a.addList(player);
                  	a.start(new Stage());
              	}
           }
           if(mode == 1){
        	   	Team team = new Team();
             	for(Team i:teams){
             		if(i.getTeamname().equals(newValue)){

             			team = i;
             		}
             	}
             	if(team.getTeamname() != null){
             		TeamUI a=new TeamUI();
                 	a.addList01(team);
                 	a.addList02(team);
                 	a.addList03(team);
                 	a.start(new Stage());
             	}
           }
           if(mode == 2){
        	   Coach coach = new Coach();
            	for(Coach i:coaches){
            		if(i.getTeamcoach().equals(newValue)){

            			coach = i;
            		}
            	}
            	if(coach.getTeamcoach() != null){
            		CoachUI a=new CoachUI();
                	a.addList(coach);
                	a.start(new Stage());
            	}
           }
    	});

        //scene
        Scene scene = new Scene(border);
        scene.getStylesheets().add("ui/layoutstyles.css");


        primarystage.setScene(scene);
        primarystage.setTitle("NBA Station");
        primarystage.setWidth(1000);
        primarystage.setHeight(800);
        primarystage.show();
        primarystage.setResizable(false);
        }
}


