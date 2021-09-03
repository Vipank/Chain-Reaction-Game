

import java.sql.Time;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Rotatationns {

	Rotatationns(GridPane pane,Sphere b){
		
		
		Rotateball(pane,b);
		
	}
void Rotateball(GridPane pane,Sphere b) { 
	     //Sphere rect = new Sphere();
	     //rect.setRadius(5);
	     
	     //rect.setArcHeight(50);
	   //  rect.setArcWidth(50);
	   //  rect.setFill(Color.VIOLET);
	 
	     RotateTransition rt = new RotateTransition(Duration.millis(10000), b);
	     rt.setByAngle(720);
	     rt.setCycleCount(Timeline.INDEFINITE);
	     rt.setAutoReverse(true);
	 pane.add(b,0,0);
	 System.out.println("Rotating");
	     rt.play();
	 
	 
	 
}

}