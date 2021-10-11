package dad.layouts;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//norte
		
		HBox norte = new HBox(new Label("Etiqueta"), new Button("Botón"));
		norte.setAlignment(Pos.BASELINE_LEFT);
		norte.setStyle("-fx-background-color: red;");
		
		Pane sur = new Pane();
		sur.setPrefHeight(25);
		sur.setStyle("-fx-background-color: yellow;");
		
		Pane este = new Pane();
		este.setPrefWidth(25);
		este.setStyle("-fx-background-color: orange;");
		
		Pane oeste = new Pane();
		oeste.setPrefWidth(50);
		oeste.setPrefHeight(20);
		oeste.setStyle("-fx-background-color: blue;");
		
		Pane centro = new Pane();
		centro.setStyle("-fx-background-color: green;");
		
		BorderPane root = new BorderPane();
		root.setTop(norte);
		root.setBottom(sur);
		root.setLeft(oeste);
		root.setRight(este);
		root.setCenter(centro);
		
		BorderPane.setAlignment(norte, Pos.CENTER);
		BorderPane.setAlignment(sur, Pos.CENTER);
		BorderPane.setAlignment(oeste, Pos.CENTER);
		BorderPane.setAlignment(este, Pos.CENTER);
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("Ejemplo de BorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
