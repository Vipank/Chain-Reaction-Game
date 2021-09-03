
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Grid3d {
	Stage stage;
	Scene scene;
	GridPane pane;
	Cell[][] field=new Cell[6][9];
	
	
	Grid3d(){
		
		initializeScene();
			
		
	}
	
	Stage getstage() {
		return stage;
	}
	
	Scene getscene() {
		
		return scene;
	}
	
	GridPane getpane() {
		
		return pane;
	}
	
	Cell [] [] getfield(){
		
		return field;
	}
	
	
	
	void initializeScene(){
		Stage ps=new Stage();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		Scene scene=new Scene(pane,1280,760);
		ps.setResizable(false);
		pane.setBackground(new Background(new BackgroundFill(Color.web("#000000"),CornerRadii.EMPTY,Insets.EMPTY)));
		
		Button newgame=new Button("New Game");
		newgame.setTranslateX(-222.25+80.5);
		newgame.setTranslateY(-175);
		newgame.setPrefSize(90, 30);
		newgame.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				ChoiceDialog<String> savedialogue=new ChoiceDialog<String>("Yes","No");
				savedialogue.setContentText("Do you Want To save the Game");
				savedialogue.showAndWait();
				if(savedialogue.getResult().equals("Yes")) {
					//
				}
				ps.close();
				initializeScene();
				
			}
		});
		pane.add(newgame, 1, 0);
		
		Button Savegame=new Button("Save Game");
		Savegame.setTranslateX(-222.25+190.5);
		Savegame.setTranslateY(-175);
		Savegame.setPrefSize(90, 30);
		pane.add(Savegame, 1, 0);
		Savegame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//
			}
		});
		
		Button Exitgame=new Button("Exit Game");
		Exitgame.setTranslateX(-222.25+300.5);
		Exitgame.setTranslateY(-175);
		Exitgame.setPrefSize(90, 30);
		Exitgame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				//SAVE THE GAME ADD CODE
				ChoiceDialog<String> exitdialogue=new ChoiceDialog<String>("Yes","No");
				exitdialogue.setContentText("Are you Sure you Want to exit");
				exitdialogue.showAndWait();
				if(exitdialogue.getResult().equals("Yes")) {
					ps.close();
				}
				
			}
		
		
		});
		pane.add(Exitgame, 1, 0);
		
		double i=500/9;
		double j=364/6;
		double xupda=0;
		double yupda=0;
		for(int k=0;k<6;k++) {
			for(int u=0;u<9;u++) {
			Position c1p=new Position(-222.25+xupda,-155.67+yupda);
			Cell c1=new Cell(pane, i,j,c1p , k , u);
			c1.ballcolor=Color.BLACK;
			if((u==0 && k==0) || (u==0 && k==5) || (u==8 && k==0) || (u==8 && k==5)) {
				c1.settype("corner",k,u);
			}else if(((u>=1 && u<=7) && k==0) || (u==0 && (k>=1 && k<=4 )) || (u==8 &&( k>=1 && k<=4 )) || ((u>=1 && u<=7) && k==5)) {
				c1.settype("edge",k,u);
			}else {
				c1.settype("between",k,u);
			}
			field[k][u]=c1;
			c1.setposition(c1p);
			//c1.click(pane,"9 * 6",field,c1.gettype());
			
			xupda=xupda+80;
			
		}
			//System.out.println(field[0][0].getcolor());
			yupda=yupda+55;
			xupda=0;
		}
		
		for(int k=0;k<6;k++) {
			for(int u=0;u<9;u++) {
				Cell c=field[k][u];
				c.click(pane, "9 * 6", field,c.gettype(),c.retfieldrow(),c.retfieldcol());
				
			}
			
		}
		
		ps.setScene(scene);
		ps.show();
		/*ChoiceDialog<String> resumedialogue=new ChoiceDialog<String>("Yes","No");
		resumedialogue.setContentText("Do you Want To save the Game");
		resumedialogue.showAndWait();
		if(resumedialogue.getResult().equals("Yes")) {*/
			
			//resumescene(this.getstage(), this.getscene(), this.getpane(), this.getfield());
	//}
	}
	
	
		
	}
	
	
	
	
	
