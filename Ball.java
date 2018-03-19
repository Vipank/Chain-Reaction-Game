package application;

import java.time.Duration;

import javafx.animation.RotateTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

public class Ball extends Sphere{
	Player player;
	String color;
	Position pos;
	Sphere ball;
	
	
	Ball(Position pos,int addshiftx,int addshifty,int radius,GridPane pane){
		initializeBall(pos,addshiftx,addshifty,radius);
	}
	void initializeBall(Position pos,int addshiftx,int addshifty,int radius) {
		ball=new Sphere(radius);
		PhongMaterial mat=new PhongMaterial();
		mat.setDiffuseColor(Color.RED);
		//mat.setDiffuseColor(Color.RED);
		ball.setTranslateX(pos.x+addshiftx);
		ball.setTranslateY(pos.y+addshifty);		
		ball.setMaterial(mat);
		ball.setVisible(true);
		
		
	}
	
}
	
	

