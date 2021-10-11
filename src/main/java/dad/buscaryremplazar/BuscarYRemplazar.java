package dad.buscaryremplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYRemplazar extends Application {

	private TextField caja1;
	private TextField caja2;
	private CheckBox check1;
	private CheckBox check2;
	private CheckBox check3;
	private CheckBox check4;
	private Button boton1;
	private Button boton2;
	private Button boton3;
	private Button boton4;
	private Button boton5;
	
	public void start(Stage primaryStage) throws Exception {
		
		caja1= new TextField();
		caja2= new TextField();
		boton1= new Button("Buscar");
		boton1.setPrefWidth(130);
		boton2= new Button("Reemplazar");
		boton2.setPrefWidth(130);
		boton3= new Button("Reemplazar todo");
		boton3.setPrefWidth(130);
		boton4= new Button("Cerrar");
		boton4.setPrefWidth(130);
		boton5= new Button("Ayuda");
		boton5.setPrefWidth(130);
		check1= new CheckBox("Mayúsculas y minúsculas");
		check2= new CheckBox("Expresión regular");
		check3= new CheckBox("Buscar hacia atrás");
		check4= new CheckBox("Resaltar resultados");
		
		GridPane checkers= new GridPane();
		checkers.setPadding(new Insets(5));
		checkers.setHgap(5);
		checkers.setVgap(5);
		checkers.addRow(0, check1, check3);
		checkers.addRow(1, check2, check4);
		
		VBox botones= new VBox();
		botones.setPadding(new Insets(5));
		botones.setAlignment(Pos.TOP_RIGHT);
		botones.setSpacing(5);
		botones.setFillWidth(true);
		botones.getChildren().addAll(boton1, boton2, boton3, boton4, boton5);
			
		GridPane formPane= new GridPane();
		formPane.setPadding(new Insets(5));
		formPane.setHgap(5);
		formPane.setVgap(5);
		formPane.addRow(0, new Label("Buscar:"), caja1);
		formPane.addRow(1, new Label("Remplazar con:"), caja2);
		formPane.add(checkers, 1, 2);
		
		HBox root = new HBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(5);
		root.setPadding(new Insets(5));
		root.getChildren().addAll(formPane, botones);
	
		Scene escena = new Scene(root, 640, 480);
		
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(escena);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
