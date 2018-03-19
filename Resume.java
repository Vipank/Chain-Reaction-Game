package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Resume implements Serializable {

	
	Resume(Stage stage,Scene scene,GridPane pane,Cell [] [] field){
	

}
void serialize(Stage stage,Scene scene,GridPane pane,Cell [] [] field) {
	
	 try
     {   
         //Saving of object in a file
         FileOutputStream file = new FileOutputStream("Game");
         ObjectOutputStream out = new ObjectOutputStream(file);
          
         // Method for serialization of object
         out.writeObject(stage);
         out.writeObject(scene);
         out.writeObject(pane);
         out.writeObject(field);
          
         out.close();
         file.close();
          
         System.out.println("Object has been serialized");

     }
      
     catch(IOException ex)
     {
         System.out.println("IOException is caught");
     }


	
}
Object [] deserialize() {
	Object [] arr=new Object[4];
	
	try
	 {   
         // Reading the object from a file
         FileInputStream file = new FileInputStream("Game");
         ObjectInputStream in = new ObjectInputStream(file);
          
         // Method for deserialization of object
         Stage stage = (Stage)in.readObject();
         Scene scene=(Scene)in.readObject();
         GridPane pane=(GridPane)in.readObject();
         Cell[][] field=(Cell[][])in.readObject();
        arr[0]=stage;
         arr[1]=scene;
         arr[2]=pane;
         arr[3]=field;
         
         in.close();
         file.close();
          
         System.out.println("Object has been deserialized ");
        
     }
      
     catch(IOException ex)
     {
         System.out.println("IOException is caught");
     }
      
     catch(ClassNotFoundException ex)
     {
         System.out.println("ClassNotFoundException is caught");
     }
	return arr;
}
}