package dad.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BorderAndFlowPaneSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button a = new Button("Si");
		a.setPrefWidth(68);
		Button b = new Button("No");
		b.setPrefWidth(68);
		Button c = new Button("Tal vez");	
		c.setPrefWidth(68);
		Button d = new Button("Cancelar");
		d.setPrefWidth(68);
		
		FlowPane root =new FlowPane();
		root.setHgap(3);
		root.setVgap(6);
		root.setAlignment(Pos.BOTTOM_RIGHT);
		root.setOrientation(Orientation.HORIZONTAL);
		root.setPadding(new Insets(5));
		root.getChildren().addAll(a, b, c, d);
		
		BorderPane foto = new BorderPane(root);
		foto.setBottom(root);
		foto.setCenter(foto);
		
		Scene escena = new Scene(root, 640,480);
		
		primaryStage.setTitle("BorderPane Sample");
		primaryStage.setScene(escena);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
