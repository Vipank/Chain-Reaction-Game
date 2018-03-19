package application;


import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main_page  extends Application{
	static ArrayList<Player> playerlist;
	static ArrayList<Player> playerlistfinal;
	public static void main(String[] args) {
		playerlist=new ArrayList<Player>();
		playerlist.add(new Player(0,Color.RED));
		playerlist.add(new Player(1,Color.GREEN));
		playerlist.add(new Player(2,Color.BROWN));
		playerlist.add(new Player(3,Color.BLUE));
		playerlist.add(new Player(4,Color.GRAY));
		playerlist.add(new Player(5,Color.ORANGE));
		playerlist.add(new Player(6,Color.DARKMAGENTA));
		playerlist.add(new Player(7,Color.WHITE));
		
		playerlistfinal =new ArrayList<Player>();
		launch(args);

	}

	@Override
	public void start(Stage primarystage) throws Exception {
		primarystage.setTitle("Chain Reaction"); 
		GridPane page=new GridPane();
		
		
		page.setAlignment(Pos.TOP_CENTER);
		ComboBox<String> nopd=new ComboBox<String>();
		nopd.getItems().addAll(
	            "2",
	            "3",
	            "4",
	            "5",
	            "6",
	            "7",
	            "8"
	        );
		nopd.setTranslateX(-50);
		nopd.setTranslateY(15);
		nopd.setPrefHeight(20);
		nopd.setPrefWidth(30);
		Label nop = new Label("No Of Players");
		nop.setTranslateX(-150);
		nop.setTranslateY(15);
		page.getChildren().add(nop);
		
		
		
		ComboBox<String> gridsize=new ComboBox<String>();
		gridsize.getItems().addAll(
	            "9 * 6",
	            "15 * 10"
	       	        );
		gridsize.setTranslateX(-50);
		gridsize.setTranslateY(30);
		gridsize.setPrefHeight(20);
		gridsize.setPrefWidth(80);
		Label gridsizel = new Label("Grid Size");
		page.getChildren().add(gridsizel);
		gridsizel.setTranslateX(-150);
		gridsizel.setTranslateY(60);

		Button newgame = new Button();
		newgame.setTranslateX(-100);
		newgame.setTranslateY(120);
		newgame.setText("New Game");
		
		
		Button settings = new Button();
		settings.setTranslateX(-180);
		settings.setTranslateY(120);
		settings.setText("Settings");
		settings.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Settings s=new Settings();
				s.initializesettingspage(Integer.parseInt(nopd.getSelectionModel().getSelectedItem()));
				
			}
		});
		
		Button resume = new Button();
		resume.setTranslateX(-10);
		resume.setTranslateY(120);
		resume.setText("Resume");
		
		
		page.add(nopd, 1,0);
		page.add(gridsize, 1, 1);
		page.add(newgame, 1, 1);
		page.add(settings, 1, 1);
		page.add(resume, 1, 1);
		
		Sphere s=new Sphere(15);
		PhongMaterial mat=new PhongMaterial();
		mat.setDiffuseColor(Color.WHITE);
		//mat.setDiffuseColor(Color.RED);		
		s.setMaterial(mat);
		
		
		Scene scene=new Scene(page, 500, 500);
		newgame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(nopd.getSelectionModel().isEmpty()) {
					Dialog<String> warning=new Dialog<String>();
					warning.setContentText("Please Choose Number of players");
					warning.show();
					Window    window = warning.getDialogPane().getScene().getWindow();
					window.setOnCloseRequest(Event -> window.hide());
				
				}else if (gridsize.getSelectionModel().isEmpty()) {
					Dialog<String> warning=new Dialog<String>();
					warning.setContentText("Please Choose GridSize");
					warning.show();
					Window    window = warning.getDialogPane().getScene().getWindow();
					window.setOnCloseRequest(Event -> window.hide());
				} 
				else if(gridsize.getValue().equals("9 * 6")) {
					for(int i=0;i<Integer.parseInt(nopd.getSelectionModel().getSelectedItem());i++) {
						playerlistfinal.add(playerlist.get(i));
					}
					
					Grid3d gsmall=new Grid3d();
					
					primarystage.close();
				
				}else if(gridsize.getValue().equals("15 * 10")) {
					for(int i=0;i<Integer.parseInt(nopd.getSelectionModel().getSelectedItem());i++) {
						playerlistfinal.add(playerlist.get(i));
					}
					
					Grid3Dbig gbig=new Grid3Dbig();
					primarystage.close();
				}
				
				
			}
		
		
		});
		
		primarystage.setScene(scene);
		primarystage.show();
		
	}

}
