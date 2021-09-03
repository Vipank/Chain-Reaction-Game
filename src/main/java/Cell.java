
import java.awt.event.MouseEvent;
//import java.time.Duration;
import java.io.File;
import java.util.ArrayList;

import com.sun.prism.Material;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Window;
import javafx.util.Duration;

public class Cell extends Main_page{
	
	int colorcheck=0;
	
	boolean rotating;
	Ball ball;
	Position pos;
	HBox rectangle;
	int x1;int y1;
	String type;
	
	int row;int column;
	
	
	//Main_page Main_page;
	Color ballcolor;
	
	Cell(GridPane pane,double dimx,double dimy,Position pos , int i , int j){
		
		colorcheck=0;
		initializeCell(pane,dimx,dimy,pos, i , j);
		//Main_page=new Main_page();
		
	}
	
void initializeCell(GridPane pane,double dimx,double dimy,Position pos , int i , int j) {
	 rectangle=new HBox(-2);
	 rectangle.setPrefHeight(dimy);
	 rectangle.setPrefWidth(dimx);
	 String id = i +" "+ j;
	// System.out.println(id);
	 rectangle.setId(id);
     //rectangle.setStroke(Color.GREEN);
     //rectangle.setFill(Color.TRANSPARENT);
	 //rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color: red;");
	rectangle.setBorder(new Border(new BorderStroke(Main_page.playerlistfinal.get(0).color,BorderStrokeStyle.SOLID,null, null)));
	 
	 
	 rectangle.setTranslateX( pos.x);
     rectangle.setTranslateY( pos.y);
     pane.add(rectangle, 1,1);
}

void setposition(Position pos) {
	this.pos=pos;
}
Position getpos() {
	return pos;
}

void settype(String type,int r,int c) {
	this.type=type;
	this.row=r;
	this.column=c;
}
String gettype(){
	return type;
}
int retfieldrow() {
	return row; 
}
int retfieldcol() {
	return column;
}

void split(GridPane pane,String Grid,int x,int y,Cell [] [] field,int row1,int col1,Color color) {
	
	
	
	int row=row1;
	int col=col1;
	//System.out.println(row+" "+col);
	//System.out.println(field[row][col].retfieldcol()+" "+field[row][col].retfieldrow()+" "+field[row][col].gettype());
	//System.out.println(row+" "+col);
	if(field[row][col].gettype().equals("between")) {
		
		if(field[row][col].rectangle.getChildren().size()==4) {
			System.out.println("betweenballsplit");
			field[row][col].rectangle.getChildren().clear();
			
			
			//System.out.println("Balls inside "+this.rectangle.getChildren().size());
			/*System.out.println(field[row-1][col].rectangle.getChildren().size());
			System.out.println(field[row+1][col].rectangle.getChildren().size());
			System.out.println(field[row][col-1].rectangle.getChildren().size());
			System.out.println(field[row][col+1].rectangle.getChildren().size());*/
		
			field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
			field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
			field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
			field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
			
			field[row][col].ballcolor=Color.BLACK;
			
			cellallballchangecolor(field[row-1][col],color);
			cellallballchangecolor(field[row+1][col],color);
			cellallballchangecolor(field[row][col-1],color);
			cellallballchangecolor(field[row][col+1],color);
	
			
			field[row-1][col].split(pane,Grid,x,y,field,row-1,col,color);
			field[row+1][col].split(pane,Grid,x,y,field,row+1,col,color);
			field[row][col-1].split(pane,Grid,x,y,field,row,col-1,color);
			field[row][col+1].split(pane,Grid,x,y,field,row,col+1,color);
			sabthikkardo(field);
			removeplayer(Main_page.playerlistfinal, field);
			//System.out.println("List Length : "+Main_page.playerlistfinal.size());
			
			
			
			if(winnercheck(field)==true) {
				
				Dialog<String> warning=new Dialog<String>();
				warning.setContentText("Player Won The Game,If you want to play again Click new Game");
				warning.show();
				Window    window = warning.getDialogPane().getScene().getWindow();
				window.setOnCloseRequest(Event -> window.hide());
			}
			
			
				}
	}else if(field[row][col].gettype().equals("corner")) {
		
		if(field[row][col].rectangle.getChildren().size()==2) {
			System.out.println("cornerballsplit");
			field[row][col].rectangle.getChildren().clear();
			
		//	System.out.println((row-1)+" "+(col-1));
			
			if(row-1>0 && col-1>0) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				
				field[row][col].ballcolor=Color.BLACK;
			
				cellallballchangecolor(field[row-1][col],color);
				cellallballchangecolor(field[row][col-1],color);
				
				
				field[row-1][col].split(pane, Grid, x, y, field,row-1,col,color);
				field[row][col-1].split(pane, Grid, x, y, field,row,col-1,color);
				//System.out.println("1");
				
				
			}else if(row-1<0 && col-1<0) {
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor(field[row+1][col],color);
				cellallballchangecolor(field[row][col+1],color);
				
				
				field[row+1][col].split(pane, Grid, x, y, field,row+1,col,color);
				field[row][col+1].split(pane, Grid, x, y, field,row,col+1,color);
				 //System.out.println("2");
				
				
				
			}else if(row-1>0 && col-1<0 ) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor(field[row-1][col],color);
				cellallballchangecolor(field[row][col+1],color);
				
				
				field[row-1][col].split(pane, Grid, x, y, field,row-1,col,color);
				field[row][col+1].split(pane, Grid, x, y, field,row,col+1,color);
				 //System.out.println("3");
				
				
			}else {
				
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor(field[row][col-1],color);
				cellallballchangecolor(field[row+1][col],color);
				
				
				field[row][col-1].split(pane, Grid, x, y, field,row,col-1,color);
				field[row+1][col].split(pane, Grid, x, y, field,row+1,col,color);
				 //System.out.println("4");
				
				
			}
			sabthikkardo(field);
			removeplayer(Main_page.playerlistfinal, field);	
			//System.out.println("List Length : "+Main_page.playerlistfinal.size());
			
			
			if(winnercheck(field)==true) {
				
				Dialog<String> warning=new Dialog<String>();
				warning.setContentText("Player Won The Game,If you want to play again Click new Game");
				warning.show();
				Window    window = warning.getDialogPane().getScene().getWindow();
				window.setOnCloseRequest(Event -> window.hide());
			}
			
		}
		
	}else if(field[row][col].gettype().equals("edge")) {
		
		if(field[row][col].rectangle.getChildren().size()==3) {
			field[row][col].rectangle.getChildren().clear();
			//this.rectangle.getChildren().removeAll();
			
			System.out.println("edgeballsplit");
			if((1 <=row && row <=4 ) && (col)==0) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor(field[row-1][col],color);
				cellallballchangecolor(field[row+1][col],color);
				cellallballchangecolor(field[row][col+1],color);
				
				
				field[row-1][col].split(pane, Grid, x, y, field,row-1,col,color);
				field[row+1][col].split(pane, Grid, x, y, field,row+1,col,color);
				field[row][col+1].split(pane, Grid, x, y, field,row,col+1,color);
				
				
			}else if(((1 <=row && row <=4 ) && (col)==8)) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor(field[row-1][col],color);
				cellallballchangecolor(field[row+1][col],color);
				cellallballchangecolor(field[row][col-1],color);
				
				
				field[row-1][col].split(pane, Grid, x, y, field,row-1,col,color);
				field[row+1][col].split(pane, Grid, x, y, field,row+1,col,color);
				field[row][col-1].split(pane, Grid, x, y, field,row,col-1,color);
				
				
				
			}else if((1 <=col && col <=7 ) && (row)==0) {
				 
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor(field[row][col-1],color);
				cellallballchangecolor(field[row][col+1],color);
				cellallballchangecolor(field[row+1][col],color);
				
				
				field[row][col-1].split(pane, Grid, x, y, field,row,col-1,color);
				field[row][col+1].split(pane, Grid, x, y, field,row,col+1,color);
				field[row+1][col].split(pane, Grid, x, y, field,row+1,col,color);
				
				
			}else {
				
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor(field[row][col+1],color);
				cellallballchangecolor(field[row-1][col],color);
				cellallballchangecolor(field[row][col-1],color);
				 
				
				
				field[row][col+1].split(pane, Grid, x, y, field,row-1,col+1,color);
				field[row-1][col].split(pane, Grid, x, y, field,row,col-1,color);
				field[row][col-1].split(pane, Grid, x, y, field,row,col+1,color);
				
				
			}
			
		}
		sabthikkardo(field);	
		removeplayer(Main_page.playerlistfinal, field);
		
		
		if(winnercheck(field)==true) {
			
			Dialog<String> warning=new Dialog<String>();
			warning.setContentText("Player Won The Game,If you want to play again Click new Game");
			warning.show();
			Window    window = warning.getDialogPane().getScene().getWindow();
			window.setOnCloseRequest(Event -> window.hide());
		}
		
	}
	
	}

//54545465465465654654654654654d65f4sd65f4sd65f4sd65f

void split2(GridPane pane,String Grid,int x,int y,Cell [] [] field,int row1,int col1,Color color) {
	
	
	
	int row=row1;
	int col=col1;
	//System.out.println(row+" "+col);
	//System.out.println(field[row][col].retfieldcol()+" "+field[row][col].retfieldrow()+" "+field[row][col].gettype());
	//System.out.println(row+" "+col);
	if(field[row][col].gettype().equals("between")) {
		
		if(field[row][col].rectangle.getChildren().size()==4) {
			//System.out.println("betweenballsplit");
			field[row][col].rectangle.getChildren().clear();
			
			
			//System.out.println("Balls inside "+this.rectangle.getChildren().size());
			/*System.out.println(field[row-1][col].rectangle.getChildren().size());
			System.out.println(field[row+1][col].rectangle.getChildren().size());
			System.out.println(field[row][col-1].rectangle.getChildren().size());
			System.out.println(field[row][col+1].rectangle.getChildren().size());*/
		
			field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
			field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
			field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
			field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
			
			field[row][col].ballcolor=Color.BLACK;
			
			cellallballchangecolor2(field[row-1][col],color);
			cellallballchangecolor2(field[row+1][col],color);
			cellallballchangecolor2(field[row][col-1],color);
			cellallballchangecolor2(field[row][col+1],color);
	
			
			field[row-1][col].split2(pane,Grid,x,y,field,row-1,col,color);
			field[row+1][col].split2(pane,Grid,x,y,field,row+1,col,color);
			field[row][col-1].split2(pane,Grid,x,y,field,row,col-1,color);
			field[row][col+1].split2(pane,Grid,x,y,field,row,col+1,color);
			
			if(winnercheck2(field)==true) {
				
				Dialog<String> warning=new Dialog<String>();
				warning.setContentText("Player Won The Game,If you want to play again Click new Game");
				warning.show();
				Window    window = warning.getDialogPane().getScene().getWindow();
				window.setOnCloseRequest(Event -> window.hide());
			}
			
			
				}
	}else if(field[row][col].gettype().equals("corner")) {
		
		if(field[row][col].rectangle.getChildren().size()==2) {
			//System.out.println("cornerballsplit");
			field[row][col].rectangle.getChildren().clear();
			
		//	System.out.println((row-1)+" "+(col-1));
			
			if(row-1>0 && col-1>0) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				
				field[row][col].ballcolor=Color.BLACK;
			
				cellallballchangecolor2(field[row-1][col],color);
				cellallballchangecolor2(field[row][col-1],color);
				
				
				field[row-1][col].split2(pane, Grid, x, y, field,row-1,col,color);
				field[row][col-1].split2(pane, Grid, x, y, field,row,col-1,color);
				//System.out.println("1");
				
				
			}else if(row-1<0 && col-1<0) {
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor2(field[row+1][col],color);
				cellallballchangecolor2(field[row][col+1],color);
				
				
				field[row+1][col].split2(pane, Grid, x, y, field,row+1,col,color);
				field[row][col+1].split2(pane, Grid, x, y, field,row,col+1,color);
				 //System.out.println("2");
				
				
				
			}else if(row-1>0 && col-1<0 ) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor2(field[row-1][col],color);
				cellallballchangecolor2(field[row][col+1],color);
				
				
				field[row-1][col].split2(pane, Grid, x, y, field,row-1,col,color);
				field[row][col+1].split2(pane, Grid, x, y, field,row,col+1,color);
				 //System.out.println("3");
				
				
			}else {
				
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor2(field[row][col-1],color);
				cellallballchangecolor2(field[row+1][col],color);
				
				
				field[row][col-1].split2(pane, Grid, x, y, field,row,col-1,color);
				field[row+1][col].split2(pane, Grid, x, y, field,row+1,col,color);
				 //System.out.println("4");
				
				
			}
			
				if(winnercheck2(field)==true) {
				
				Dialog<String> warning=new Dialog<String>();
				warning.setContentText("Player Won The Game,If you want to play again Click new Game");
				warning.show();
				Window    window = warning.getDialogPane().getScene().getWindow();
				window.setOnCloseRequest(Event -> window.hide());
			}
			
		}
		
	}else if(field[row][col].gettype().equals("edge")) {
		
		if(field[row][col].rectangle.getChildren().size()==3) {
			field[row][col].rectangle.getChildren().clear();
			//this.rectangle.getChildren().removeAll();
			
			System.out.println("edgeballsplit");
			if((1 <=row && row <=8 ) && (col)==0) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor2(field[row-1][col],color);
				cellallballchangecolor2(field[row+1][col],color);
				cellallballchangecolor2(field[row][col+1],color);
				
				
				field[row-1][col].split2(pane, Grid, x, y, field,row-1,col,color);
				field[row+1][col].split2(pane, Grid, x, y, field,row+1,col,color);
				field[row][col+1].split2(pane, Grid, x, y, field,row,col+1,color);
				
				
			}else if(((1 <=row && row <=8 ) && (col)==14)) {
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor2(field[row-1][col],color);
				cellallballchangecolor2(field[row+1][col],color);
				cellallballchangecolor2(field[row][col-1],color);
				
				
				field[row-1][col].split2(pane, Grid, x, y, field,row-1,col,color);
				field[row+1][col].split2(pane, Grid, x, y, field,row+1,col,color);
				field[row][col-1].split2(pane, Grid, x, y, field,row,col-1,color);
				
				
				
			}else if((1 <=col && col <=13 ) && (row)==0) {
				 
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				field[row+1][col].addball(pane,Grid,x,y,field,field[row+1][col].gettype(),row+1,col);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor2(field[row][col-1],color);
				cellallballchangecolor2(field[row+1][col+1],color);
				cellallballchangecolor2(field[row+1][col],color);
				
				
				field[row][col-1].split2(pane, Grid, x, y, field,row,col-1,color);
				field[row][col+1].split2(pane, Grid, x, y, field,row,col+1,color);
				field[row+1][col].split2(pane, Grid, x, y, field,row+1,col,color);
				
				
			}else {
				
				field[row][col+1].addball(pane,Grid,x,y,field,field[row][col+1].gettype(),row,col+1);
				field[row-1][col].addball(pane,Grid,x,y,field,field[row-1][col].gettype(),row-1,col);
				field[row][col-1].addball(pane,Grid,x,y,field,field[row][col-1].gettype(),row,col-1);
				
				field[row][col].ballcolor=Color.BLACK;
				
				cellallballchangecolor2(field[row][col+1],color);
				cellallballchangecolor2(field[row-1][col],color);
				cellallballchangecolor2(field[row][col-1],color);
				 
				
				
				field[row][col+1].split2(pane, Grid, x, y, field,row-1,col+1,color);
				field[row-1][col].split2(pane, Grid, x, y, field,row,col-1,color);
				field[row][col-1].split2(pane, Grid, x, y, field,row,col+1,color);
				
				
			}
			
		}
			if(winnercheck2(field)==true) {
			
			Dialog<String> warning=new Dialog<String>();
			warning.setContentText("Player Won The Game,If you want to play again Click new Game");
			warning.show();
			Window    window = warning.getDialogPane().getScene().getWindow();
			window.setOnCloseRequest(Event -> window.hide());
		}
		
	}
	
	}


////dfds2fsd2fsdF21sadFfdsafdsfadsfadsf24225454542

void click(GridPane pane,String Grid,Cell [] [] field,String type,int row,int col) {
	
	rectangle.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

		@Override
		public void handle(javafx.scene.input.MouseEvent event) {
			String st =  rectangle.getId();
			String[] star = st.split(" ");
			if((field[row][col].ballcolor==Color.BLACK||field[row][col].ballcolor==Main_page.playerlist.get(colorcheck).color)) {
				field[row][col].ballcolor=Main_page.playerlist.get(colorcheck).color;
				
			addball(pane,Grid,0,0,field,type,Integer.parseInt(star[0]),Integer.parseInt(star[1]));
			//System.out.println(colorcheck);
			if(Grid.equals("9 * 6")){
			if(colorcheck<Main_page.playerlistfinal.size()-1) {
				System.out.println("Listize"+Main_page.playerlistfinal.size());
				for(int k=0;k<6;k++) {
					for(int u=0;u<9;u++) {
						//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
					field[k][u].colorcheck+=1;	
				
					}
					
					
				}
				for(int k=0;k<6;k++) {
					for(int u=0;u<9;u++) {
						//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
						
						field[k][u].rectangle.setBorder(new Border(new BorderStroke(Main_page.playerlist.get(colorcheck).color,BorderStrokeStyle.SOLID,null, null)));
					}
					
				}	
			
			}else {
					for(int k=0;k<6;k++) {
						for(int u=0;u<9;u++) {
							//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
							field[k][u].colorcheck=0;
					
						}
						
					}
					for(int k=0;k<6;k++) {
						for(int u=0;u<9;u++) {
							//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
							
							field[k][u].rectangle.setBorder(new Border(new BorderStroke(Main_page.playerlist.get(colorcheck).color,BorderStrokeStyle.SOLID,null, null)));
						}
					}			
			}
			
			}
			
			else {
				
				if(colorcheck<Main_page.playerlistfinal.size()-1) {
					for(int k=0;k<10;k++) {
						for(int u=0;u<15;u++) {
							//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
						field[k][u].colorcheck+=1;	
					
						}
						
						
					}
					for(int k=0;k<10;k++) {
						for(int u=0;u<15;u++) {
							//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
							
							field[k][u].rectangle.setBorder(new Border(new BorderStroke(Main_page.playerlist.get(colorcheck).color,BorderStrokeStyle.SOLID,null, null)));
						}
						
					}	
				
				}else {
						for(int k=0;k<10;k++) {
							for(int u=0;u<15;u++) {
								//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
								field[k][u].colorcheck=0;
						
							}
							
						}
						for(int k=0;k<10;k++) {
							for(int u=0;u<15;u++) {
								//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
								
								field[k][u].rectangle.setBorder(new Border(new BorderStroke(Main_page.playerlist.get(colorcheck).color,BorderStrokeStyle.SOLID,null, null)));
							}
						}			
				}
				
				}
				
			}
			
			}
			
		}
);
}

public void addball(GridPane pane,String Grid,int x1,int y1,Cell [] [] field,String type,int row,int col) {
	//if((field[row][col].ballcolor==Color.BLACK||field[row][col].ballcolor==Main_page.playerlist.get(colorcheck).color)) {
	//	field[row][col].ballcolor=Main_page.playerlist.get(colorcheck).color;
		
		
	String bip = "bip.mp3";
//	Media hit = new Media(new File(bip).toURI().toString());
//	MediaPlayer mediaPlayer = new MediaPlayer(hit);
//	mediaPlayer.play();
	
	
	if(Grid.equals("9 * 6")) {
		
		if(field[row][col].rectangle.getChildren().size()==0) {
			x1=590;y1=350;
		}else if(field[row][col].rectangle.getChildren().size()==1) {
			x1=590;y1=350;
		}else if(field[row][col].rectangle.getChildren().size()==2) {
			x1=615;y1=340;
		}
		
		if(type.equals("corner")) {
				System.out.println("Cornerballadd");
				
				if(field[row][col].rectangle.getChildren().size()<=1) {
					//Ball b=new Ball(this.getpos(), 18+x1, 0+y1, 10, pane);
					//System.out.println("Cornerballadd");
					Sphere b=new Sphere(10);
					PhongMaterial mat=new PhongMaterial();
					mat.setDiffuseColor(Main_page.playerlist.get(colorcheck).color);
					//mat.setDiffuseColor(Color.RED);
					b.setTranslateX(field[row][col].rectangle.getLayoutX()-x1);
					b.setTranslateY(field[row][col].rectangle.getLayoutX()-x1);	
					b.setMaterial(mat);
					RotateTransition rt = new RotateTransition(Duration.INDEFINITE, b);
				    movepivot(b,1.0,1.0,field[row][col].rectangle.getLayoutX()-x1,field[row][col].rectangle.getLayoutX()-x1);
					rt.setByAngle(720);
				     rt.setCycleCount(Timeline.INDEFINITE);
				   //  rt.setAutoReverse(false);
					rt.play();
					field[row][col].rectangle.getChildren().add(b);
					
					//	System.out.println("Size : "+rectangle.getChildren().size());
					if(field[row][col].rectangle.getChildren().size()==2) {
						field[row][col].split(pane,Grid,0,0,field,row,col,Main_page.playerlist.get(colorcheck).color);
					}
				
				}
			}else if(type.equals("between")) {
				System.out.println("betweenballadd");
				if(field[row][col].rectangle.getChildren().size()<=3) {
					Sphere b=new Sphere(10);
					PhongMaterial mat=new PhongMaterial();
					mat.setDiffuseColor(Main_page.playerlist.get(colorcheck).color);
					//mat.setDiffuseColor(Color.RED);
					b.setTranslateX(field[row][col].rectangle.getLayoutX()-x1);
					b.setTranslateY(field[row][col].rectangle.getLayoutY()-y1);
					b.setMaterial(mat);
					
					
				     field[row][col].rectangle.getChildren().add(b);
			//	 System.out.println("Rotating");
				   
				    // System.out.println("Size : "+rectangle.getChildren().size()); 
				    
				     if(field[row][col].rectangle.getChildren().size()==4) {
				    	 field[row][col].split(pane,Grid,0,0,field,row,col,Main_page.playerlist.get(colorcheck).color);
				     }
				}
			}else if(type.equals("edge")){
				System.out.println("edgeballadd");
			//	System.out.println(this.gettype());
				if(field[row][col].rectangle.getChildren().size()<=2) {
					//Ball b=new Ball(this.getpos(), 18+x1, 0+y1, 10, pane);
					Sphere b=new Sphere(10);
					PhongMaterial mat=new PhongMaterial();
					mat.setDiffuseColor(Main_page.playerlist.get(colorcheck).color);
					//mat.setDiffuseColor(Color.RED);
					b.setTranslateX(field[row][col].rectangle.getLayoutX()-x1);
					b.setTranslateY(field[row][col].rectangle.getLayoutY()-y1);		
					b.setMaterial(mat);
					
					field[row][col].rectangle.getChildren().add(b);
				//	System.out.println("Size : "+rectangle.getChildren().size());
					
					if(field[row][col].rectangle.getChildren().size()==3) {
						field[row][col].split(pane,Grid,0,0,field,row,col,Main_page.playerlist.get(colorcheck).color);
					}
				}
			}
	}else {
		
		if(field[row][col].rectangle.getChildren().size()==0) {
			x1=575;y1=370;
		}else if(field[row][col].rectangle.getChildren().size()==1) {
			x1=575;y1=370;
		}else if(field[row][col].rectangle.getChildren().size()==2) {
			x1=592;y1=360;
		}
		
		
		if(type.equals("corner")) {
			

			if(field[row][col].rectangle.getChildren().size()<=1) {
				//Ball b=new Ball(this.getpos(), 18+x1, 0+y1, 10, pane);
				//System.out.println("Cornerballadd");
				Sphere b=new Sphere(7);
				PhongMaterial mat=new PhongMaterial();
				mat.setDiffuseColor(Main_page.playerlist.get(colorcheck).color);
				//mat.setDiffuseColor(Color.RED);
				b.setTranslateX(field[row][col].rectangle.getLayoutX()-x1);
				b.setTranslateY(field[row][col].rectangle.getLayoutY()-y1);	
				b.setMaterial(mat);
				field[row][col].rectangle.getChildren().add(b);
				//System.out.println("Size : "+rectangle.getChildren().size());
				if(field[row][col].rectangle.getChildren().size()==2) {
					field[row][col].split2(pane,Grid,0,0,field,row,col,Main_page.playerlist.get(colorcheck).color);
				}
			
			}
		}else if(type.equals("between")) {
			if(field[row][col].rectangle.getChildren().size()<=3) {
				Sphere b=new Sphere(7);
				PhongMaterial mat=new PhongMaterial();
				mat.setDiffuseColor(Main_page.playerlist.get(colorcheck).color);
				//mat.setDiffuseColor(Color.RED);
				b.setTranslateX(field[row][col].rectangle.getLayoutX()-x1);
				b.setTranslateY(field[row][col].rectangle.getLayoutY()-y1);
				b.setMaterial(mat);
				
				RotateTransition rt = new RotateTransition(Duration.INDEFINITE, b);
			     rt.setByAngle(720);
			     rt.setCycleCount(15);
			     rt.setAutoReverse(true);
			     field[row][col].rectangle.getChildren().add(b);
		//	 System.out.println("Rotating");
			     rt.play();
			     System.out.println("Size : "+rectangle.getChildren().size()); 
			     if(field[row][col].rectangle.getChildren().size()==4) {
			    	 field[row][col].split2(pane,Grid,0,0,field,row,col,Main_page.playerlist.get(colorcheck).color);
			     }
			}
		}else {
			if(field[row][col].rectangle.getChildren().size()<=2) {
				//Ball b=new Ball(this.getpos(), 18+x1, 0+y1, 10, pane);
				Sphere b=new Sphere(7);
				PhongMaterial mat=new PhongMaterial();
				mat.setDiffuseColor(Main_page.playerlist.get(colorcheck).color);
				//mat.setDiffuseColor(Color.RED);
				b.setTranslateX(field[row][col].rectangle.getLayoutX()-x1);
				b.setTranslateY(field[row][col].rectangle.getLayoutY()-y1);		
				b.setMaterial(mat);
				
				field[row][col].rectangle.getChildren().add(b);
				System.out.println("Size : "+rectangle.getChildren().size());
				if(field[row][col].rectangle.getChildren().size()==3) {
					field[row][col].split2(pane,Grid,0,0,field,row,col,Main_page.playerlist.get(colorcheck).color);
				}
			}
		}
		
		
	}
	

	}
	
//}
public void changecolorofield(Cell [][] field,Color color) {
	
	for(int k=0;k<6;k++) {
		for(int u=0;u<9;u++) {
			//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
			field[k][u].rectangle.setBorder(new Border(new BorderStroke(color,BorderStrokeStyle.SOLID,null, null)));
		}
		
	}
}

public void changecolorofield2(Cell [][] field,Color color) {
	
	for(int k=0;k<10;k++) {
		for(int u=0;u<15;u++) {
			//field[u][k].rectangle.setStyle("-fx-background-color : transparent;" + "-fx-border-color:"+color+";");
			field[k][u].rectangle.setBorder(new Border(new BorderStroke(color,BorderStrokeStyle.SOLID,null, null)));
		}
		
	}
}

public void cellallballchangecolor(Cell c,Color color) {
	for(Node n:c.rectangle.getChildren()) {
		c.ballcolor=color;
		Sphere s=(Sphere)n;
		PhongMaterial mat=new PhongMaterial();
		mat.setDiffuseColor(color);
		s.setMaterial(mat);
	}

}

public void cellallballchangecolor2(Cell c,Color color) {
	for(Node n:c.rectangle.getChildren()) {
		c.ballcolor=color;
		Sphere s=(Sphere)n;
		PhongMaterial mat=new PhongMaterial();
		mat.setDiffuseColor(color);
		s.setMaterial(mat);
	}

}


public boolean winnercheck(Cell [][] field) {
	boolean check=true;
	int u=0;
	int k=0;
	Color color=Color.BLACK;
	for(k=0;k<6;k++) {
		for( u=0;u<9;u++) {
			if(field[k][u].ballcolor.equals(Color.BLACK)!=true) {
				color=field[k][u].ballcolor;
				break;
			}
		}
	}
	int innercheck=0;
	for(int t=0;t<6;t++) {
		for(int s=0;s<9;s++) {
			if(field[t][s].ballcolor.equals(Color.BLACK)!=true) {
			
			if(field[t][s].ballcolor.equals(color)!=true) {
				check=false;
				innercheck=1;
				break;
			}
		}
		}
			if(innercheck==1) {
			break;
		}
		
	}
	return check;
}

public boolean winnercheck2(Cell [][] field) {
	boolean check=true;
	int u=0;
	int k=0;
	Color color=Color.BLACK;
	for(k=0;k<10;k++) {
		for( u=0;u<15;u++) {
			if(field[k][u].ballcolor.equals(Color.BLACK)!=true) {
				color=field[k][u].ballcolor;
				break;
			}
		}
	}
	int innercheck=0;
	for(int t=0;t<10;t++) {
		for(int s=0;s<15;s++) {
			if(field[t][s].ballcolor.equals(Color.BLACK)!=true) {
			
			if(field[t][s].ballcolor.equals(color)!=true) {
				check=false;
				innercheck=1;
				break;
			}
		}
		}
			if(innercheck==1) {
			break;
		}
		
	}
	return check;
}

public void removeplayer(ArrayList<Player> l,Cell [][] field) {
	int k,u=0;
	int innercheck=0;
	int present=0;
	for(int i=0;i<l.size();i++) {
		Color c=l.get(i).color;
		for(k=0;k<6;k++) {
			for( u=0;u<9;u++) {
				System.out.println(i+" "+k+" "+u+" "+field[k][u].ballcolor +" "+c);
				if(field[k][u].ballcolor.equals(c)) {
					//System.out.println("checkingthis "+c);
					//System.out.println("currentcolor "+field[k][u].ballcolor);
					innercheck=1;
					present=1;
					System.out.println("Present "+present);
					break;
				}
			}
			if(innercheck==1) {
				break;
			}
		}
		if(present==0) {
			System.out.println(i+" "+"player removed");
			l.remove(i);
		}
	}
	
	
}
public void movepivot(Node n,double x,double y,double x1,double y1) {
	n.getTransforms().add(new Translate(-x,-y));
	n.setTranslateX(x1);
	n.setTranslateY(y1);
}
public void sabthikkardo(Cell [] [] field) {
	for(int k=0;k<6;k++) {
		for(int u=0;u<9;u++) {
			if(field[k][u].rectangle.getChildren().size()!=0){
				field[k][u].ballcolor=spherecolor(field[k][u].rectangle);
				
			}else {
				field[k][u].ballcolor=Color.BLACK;
			}
		}
		
	}
	
}

public Color spherecolor(HBox rec) {
	Color c=Color.BLACK;
	for(Node n:rec.getChildren()) {
		Sphere s=(Sphere)n;
		PhongMaterial m=(PhongMaterial) s.getMaterial();
		 c=m.getDiffuseColor();	
	}
	return c;
}

}