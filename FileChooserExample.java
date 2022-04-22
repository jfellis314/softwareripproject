package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
public class FileChooserExample extends Application {
public void start(Stage stage) {
      //Creating a menu
      Menu fileMenu = new Menu("File");
      //Creating menu Items
      MenuItem item = new MenuItem("Open Image");
      fileMenu.getItems().addAll(item);
      //Creating a File chooser
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Image");
      fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
      //Adding action on the menu item
      item.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            //Opening a dialog box
            fileChooser.showOpenDialog(stage);
      }});
      //Creating a menu bar and adding menu to it.
      MenuBar menuBar = new MenuBar(fileMenu);
      menuBar.setTranslateX(3);
      menuBar.setTranslateY(3);
      //Setting the stage
      Group root = new Group(menuBar);
      Scene scene = new Scene(root, 595, 355, Color.BEIGE);
      stage.setTitle("File Chooser Example");
      stage.setScene(scene);
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}