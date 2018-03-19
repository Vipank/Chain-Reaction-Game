package application;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Settings extends Main_page {
	ComboBox<Color> playerc1;
	ComboBox<Color> playerc2;
	ComboBox<Color> playerc3;
	ComboBox<Color> playerc4;
	ComboBox<Color> playerc5;
	ComboBox<Color> playerc6;
	ComboBox<Color> playerc7;
	ComboBox<Color> playerc8;
	Stage settingsstage;
	
	Settings(){
		
	}
	
	public void initializesettingspage(int noplayers) {
		
	
		
		settingsstage=new Stage();
		settingsstage.setTitle("Settings");
		GridPane setpane=new GridPane();
		setpane.setAlignment(Pos.TOP_CENTER);
		
		playerc1=new ComboBox<Color>();
		playerc1.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color1 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color1;
		playerc1.setTranslateX(-30);
		playerc1.setTranslateY(15);
		playerc1.setPrefHeight(20);
		playerc1.setPrefWidth(90);
		Label p1 = new Label("Player1");
		p1.setTranslateX(-130);
		p1.setTranslateY(15);
		setpane.getChildren().add(p1);
		
		playerc2=new ComboBox<Color>();
		playerc2.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color2 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color2;
		playerc2.setTranslateX(-30);
		playerc2.setTranslateY(55);
		playerc2.setPrefHeight(20);
		playerc2.setPrefWidth(90);
		Label p2 = new Label("Player2");
		p2.setTranslateX(-130);
		p2.setTranslateY(55);
		setpane.getChildren().add(p2);
		
		playerc3=new ComboBox<Color>();
		playerc3.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color3 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color3;
		playerc3.setTranslateX(-30);
		playerc3.setTranslateY(95);
		playerc3.setPrefHeight(20);
		playerc3.setPrefWidth(90);
		Label p3 = new Label("Player3");
		p3.setTranslateX(-130);
		p3.setTranslateY(95);
		setpane.getChildren().add(p3);
		
		playerc4=new ComboBox<Color>();
		playerc4.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color4 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color4;
		playerc4.setTranslateX(-30);
		playerc4.setTranslateY(135);
		playerc4.setPrefHeight(20);
		playerc4.setPrefWidth(90);
		Label p4 = new Label("Player4");
		p4.setTranslateX(-130);
		p4.setTranslateY(135);
		setpane.getChildren().add(p4);
		
		playerc5=new ComboBox<Color>();
		playerc5.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color5 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color5;
		playerc5.setTranslateX(-30);
		playerc5.setTranslateY(175);
		playerc5.setPrefHeight(20);
		playerc5.setPrefWidth(90);
		Label p5 = new Label("Player5");
		p5.setTranslateX(-130);
		p5.setTranslateY(175);
		setpane.getChildren().add(p5);
		
		playerc6=new ComboBox<Color>();
		playerc6.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color6 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color6;
		playerc6.setTranslateX(-30);
		playerc6.setTranslateY(215);
		playerc6.setPrefHeight(20);
		playerc6.setPrefWidth(90);
		Label p6 = new Label("Player6");
		p6.setTranslateX(-130);
		p6.setTranslateY(215);
		setpane.getChildren().add(p6);
		
		playerc7=new ComboBox<Color>();
		playerc7.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color7 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color7;
		playerc7.setTranslateX(-30);
		playerc7.setTranslateY(255);
		playerc7.setPrefHeight(20);
		playerc7.setPrefWidth(90);
		Label p7 = new Label("Player7");
		p7.setTranslateX(-130);
		p7.setTranslateY(255);
		setpane.getChildren().add(p7);
		
		playerc8=new ComboBox<Color>();
		playerc8.getItems().addAll(
	            Color.BLUE,
	            Color.GREEN,
	            Color.RED,
	            Color.VIOLET,
	            Color.GOLD,
	            Color.ORANGE,
	            Color.PINK,
	            Color.WHITE
	        );
		Color color8 = playerc1.getSelectionModel().getSelectedItem();
		playerlist.get(0).color = color8;	
		playerc8.setTranslateX(-30);
		playerc8.setTranslateY(295);
		playerc8.setPrefHeight(20);
		playerc8.setPrefWidth(90);
		Label p8 = new Label("Player8");
		p8.setTranslateX(-130);
		p8.setTranslateY(295);
		setpane.getChildren().add(p8);
		
		setpane.add(playerc1, 1,0);
		setpane.add(playerc2, 1,0);
		setpane.add(playerc3, 1,0);
		setpane.add(playerc4, 1,0);
		setpane.add(playerc5, 1,0);
		setpane.add(playerc6, 1,0);
		setpane.add(playerc7, 1,0);
		setpane.add(playerc8, 1,0);
		
		Button done = new Button();
		done.setTranslateX(-100);
		done.setTranslateY(335);
		done.setText("DONE");
		setpane.add(done, 1, 0);
		
		done.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Color [] arrayofcolours=new Color[8];
				arrayofcolours[0]=playerc1.getValue();
				arrayofcolours[1]=playerc2.getValue();
				arrayofcolours[2]=playerc3.getValue();
				arrayofcolours[3]=playerc4.getValue();
				arrayofcolours[4]=playerc5.getValue();
				arrayofcolours[5]=playerc6.getValue();
				arrayofcolours[6]=playerc7.getValue();
				arrayofcolours[7]=playerc8.getValue();
				int checkcolor=0;
				int checknull=0;
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						if(arrayofcolours[i]!=null && arrayofcolours[j]!=null && (i!=j) && arrayofcolours[i].equals(arrayofcolours[j])) {
							checkcolor=1;
						}else if(arrayofcolours[i]==null){
							checknull=1;
						}
					}
				}
				if(checknull==1) {
					Dialog<String> warning=new Dialog<String>();
					warning.setContentText("Please Select colour for all Players and then Press Done");
					warning.show();
					Window    window = warning.getDialogPane().getScene().getWindow();
					window.setOnCloseRequest(Event -> window.hide());
				}
				
				else if(checkcolor==0) {
					settingsstage.close();
				} 
				
				else {
					Dialog<String> warning=new Dialog<String>();
					warning.setContentText("Please Choose Different colour for Different Players and then Press Done");
					warning.show();
					Window    window = warning.getDialogPane().getScene().getWindow();
					window.setOnCloseRequest(Event -> window.hide());
					
					
				
				
				}
			}
		});
		
		Scene scene=new Scene(setpane, 500, 500);
		settingsstage.setScene(scene);
		settingsstage.show();

	}
	
	
	
	
}
