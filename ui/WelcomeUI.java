package ui;

import java.awt.Font;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;



public class WelcomeUI extends Application {
  
	public static void main(String[] args) {
		  launch(args);
		}
	
      @Override
      public void start(Stage primaryStage) {
                        
              primaryStage.setTitle("Welcome NBAStation");
              primaryStage.show();
              
              BorderPane border = new BorderPane();
              Scene scene = new Scene(border, 1000, 800);
              primaryStage.setScene(scene);
              
             
              scene.getStylesheets().add(getClass().getResource("welcome.css").toExternalForm());
              
 
              GridPane grid = new GridPane();
              //grid.setGridLinesVisible(true);
              grid.setAlignment(Pos.CENTER);
              grid.setHgap(30);
              grid.setVgap(30);
              grid.setPadding(new Insets(25, 25, 25, 25));
              border.setCenter(grid);
              
              //按键
              Image imagePlayer = new Image(getClass().getResourceAsStream("button_welcome.jpg"));
              Button btn = new Button();
              btn.setGraphic(new ImageView(imagePlayer));
              btn.setId("sign-button");
              grid.add(btn, 2, 18);//, 2, 3);//将HBox pane放到grid中的第1列，第4行
              
              btn.setOnAction(new EventHandler<ActionEvent>() {
                
                public void handle(ActionEvent event) {
                    MainUI a=new MainUI();

                    a.start(primaryStage);
                }
              });
              

          
           }
  
  }

