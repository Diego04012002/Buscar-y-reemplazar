package dad.buscaryremplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
		
		GridPane formPane = new GridPane();
		formPane.setGridLinesVisible(false);
		formPane.setHgap(7);
		formPane.setVgap(7);
		formPane.setPadding(new Insets(5));
		formPane.addRow(0, new Label("Buscar: "), caja1);
		formPane.addRow(1, new Label("Remplazar con: "), caja2);

		formPane.add(check1, 1, 2);
		formPane.add(check3, 2, 2);
		formPane.add(check2, 1, 3);
		formPane.add(check4, 2, 3);
		
		GridPane.setColumnSpan(caja1, 2);
		GridPane.setColumnSpan(caja2, 2);
		
		ColumnConstraints [] cols = {
				new ColumnConstraints(),	
				new ColumnConstraints(),	
				new ColumnConstraints(),	
				new ColumnConstraints(),
			};
		formPane.getColumnConstraints().setAll(cols);
		
		cols[2].setHgrow(Priority.ALWAYS);
		
		
		VBox botones = new VBox(5);
		botones.getChildren().addAll(boton1, boton2, boton3, boton4, boton5);
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		root.setCenter(formPane);
		root.setRight(botones);
		
		Scene scene = new Scene(root, 500, 185);

		primaryStage.setTitle("Buscar Y Remplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
