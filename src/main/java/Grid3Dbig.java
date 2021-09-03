
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Grid3Dbig {

	Cell [][] field=new Cell[10][15];
	
	 Grid3Dbig(){
		
		initializeScene();
}
	 
	 
	 void initializeScene() {
		 Stage ps=new Stage();
			GridPane pane=new GridPane();
			pane.setAlignment(Pos.CENTER);
			Scene scene=new Scene(pane,1280,760);
			ps.setResizable(false);
			Button newgame=new Button("New Game");
			newgame.setTranslateX(-580+80.5);
			newgame.setTranslateY(-175);
			newgame.setPrefSize(90, 30);
			newgame.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					ChoiceDialog<String> savedialogue=new ChoiceDialog<String>("Yes","No");
					savedialogue.setContentText("Do you Want To save the Game");
					savedialogue.showAndWait();
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
						// SAVE GAME ADD CODE
					}
					ps.close();
					
				}
			
			
			
			});
			pane.add(Exitgame, 1, 0);
			
			double i=500/15;
			double j=364/10;
			double xupda=0;
			double yupda=0;
			for(int k=0;k<10;k++) {
				for(int u=0;u<15;u++) {
					Position c1p=new Position(-560+xupda,-155.67+yupda);
					Cell c1=new Cell(pane, i,j,c1p , k , u);
					c1.ballcolor=Color.BLACK;
					if((u==0 && k==0) || (u==14 && k==9) || (u==14 && k==0) || (u==0 && k==14)) {
						c1.settype("corner",k,u);
					}else if(((u>=1 && u<=14) && k==0) || (u==0 && (k>=1 && k<=9 )) || (u==14 &&( k>=1 && k<=9 )) || ((u>=1 && u<=14) && k==9)) {
						c1.settype("edge",k,u);
					}else {
						c1.settype("between",k,u);
					}
					field[k][u]=c1;
					c1.setposition(c1p);
					//c1.click(pane,"9 * 6",field,c1.gettype());
					
					xupda=xupda+80.8;
			}
				yupda=yupda+31.4;
				xupda=0;
			}
			
			for(int k=0;k<10;k++) {
				for(int u=0;u<15;u++) {
					Cell c=field[k][u];
					c.click(pane, "10 * 15", field,c.gettype(),c.retfieldrow(),c.retfieldcol());
					
				}
				
			}
			
			
			ps.setScene(scene);
			ps.show();
		}

	}

