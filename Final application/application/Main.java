package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	private static Stage stg;
	
	@Override
	public void start(Stage loginStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(root);
		loginStage.setScene(scene);
		loginStage.show();
	}
	

	public static void main(String[] args) {launch(args);}
}
