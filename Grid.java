package application;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Grid {

    
    Grid(HBox root){
        // create root node
        //HBox root = new HBox();
       // Scene scene = new Scene(root, 640, 400);
      //  primaryStage.setScene(scene);

        // translate root node to center of the screen
        root.setTranslateX(320);
        root.setTranslateY(200);
        
        // create scene
        createScene(root);

       // primaryStage.show();
    }

    private void createScene(HBox root) {
        Group branch = new Group();
        root.getChildren().add(branch);

        GridPane pane=new GridPane();
        Ball b1=new Ball(new Position(0, 0),0, 0, 7, pane);
        Ball b2=new Ball(new Position(5, 10),0, 0,7, pane);
        pane.getChildren().add(b1);
        pane.getChildren().add(b2);
        branch.getChildren().add(pane);
        // create a recangle, which will be added to the branch
       // Rectangle r = new Rectangle(40, 20);
        //branch.getChildren().add(r);

        // circle should orbit around the rectangle
       // Circle c = new Circle(10);
        //branch.getChildren().add(c);
        //c.setTranslateY(-50);

        // rotate the branch
        Timeline rot = new Timeline();
        rot.setCycleCount(Timeline.INDEFINITE);
        rot.setRate(12);
        rot.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(
                        branch.rotateProperty(), 0)),
                new KeyFrame(Duration.seconds(5), new KeyValue(branch
                        .rotateProperty(), 360)));
        rot.playFromStart();
    }
       
    
public static void main(String[] args) throws IOException {
	HBox b=new HBox();
	Grid g=new Grid(b);

}
}