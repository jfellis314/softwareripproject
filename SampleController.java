package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
 import javafx.scene.Group;
 import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
 import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter; 

 public class SampleController extends Application {
 
     @Override public void start(Stage stage) {
         // load the image
    	 
         Image image = new Image("D:\\±ÚÖ½\\0dd7912397dda1446fbaf31cb2b7d0a20df486e9[1].jpg");
         
 
         // simple displays ImageView the image as is
         ImageView iv1 = new ImageView();
         iv1.setImage(image);
 
         // resizes the image to have width of 100 while preserving the ratio and using
         // higher quality filtering method; this ImageView is also cached to
         // improve performance
         ImageView iv2 = new ImageView();
         iv2.setImage(image);
         iv2.setFitWidth(100);
         iv2.setPreserveRatio(true);
         iv2.setSmooth(true);
         iv2.setCache(true);

         // defines a viewport into the source image (achieving a "zoom" effect) and
         // displays it rotated
         ImageView iv3 = new ImageView();
         iv3.setImage(image);
         Rectangle2D viewportRect = new Rectangle2D(40, 35, 110, 110);
         iv3.setViewport(viewportRect);
         iv3.setRotate(90);

         Group root = new Group();
         Scene scene = new Scene(root);
         scene.setFill(Color.BLACK);
         HBox box = new HBox();
         box.getChildren().add(iv1);
         box.getChildren().add(iv2);
         box.getChildren().add(iv3);
         root.getChildren().add(box);
 
         stage.setTitle("ImageView");
         stage.setWidth(415);
         stage.setHeight(200);
         stage.setScene(scene); 
         stage.sizeToScene(); 
         stage.show(); 
     }


	public static void main(String[] args) {
         Application.launch(args);
     }
 }