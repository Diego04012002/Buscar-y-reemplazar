package dad.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane root = new FlowPane(); 
		root.setHgap(2);
		root.setVgap(15);
		root.setAlignment(Pos.TOP_LEFT);
		root.setOrientation(Orientation.HORIZONTAL);
		root.setPadding(new Insets(5));
		
		for (int i = 0; i < 50; i++) {
			Button b = new Button("" + i);
			b.setStyle("-fx-background-color: lightgreen;");
			b.setPrefWidth(60);
			
			root.getChildren().add(b);
		}
		
		Scene escena = new Scene(root, 640,480);
		
		primaryStage.setTitle("BorderPane Sample");
		primaryStage.setScene(escena);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
