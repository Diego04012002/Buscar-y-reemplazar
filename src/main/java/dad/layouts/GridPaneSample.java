package dad.layouts;

import java.time.LocalDate;
import java.time.Period;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneSample extends Application {
	
	private ObjectProperty<LocalDate> fechaNac = new SimpleObjectProperty<>();
	private IntegerProperty edad= new SimpleIntegerProperty();

	private TextField nombreText;
	private TextField apellidosText;
	private TextField dniText;
	private DatePicker fechaNacimiento;
	private Label edadLabel;
	private TextField[] ibanText;
	private RadioButton hombreRadio, mujerRadio;
	private TextArea descripcionArea;
	
	public void start(Stage primaryStage) throws Exception {
		nombreText= new TextField();
		nombreText.setPromptText("Nombre del alumno");
		
		apellidosText= new TextField();
		apellidosText.setPromptText("Apellidos del alumno");
		
		dniText= new TextField();
		dniText.setPromptText("DNI del alumno");
		
		fechaNacimiento= new DatePicker();
		fechaNacimiento.setPromptText("Fecha de nacimiento");
		
		edadLabel= new Label("XXX");
		edadLabel.setMinHeight(Region.USE_PREF_SIZE); // no se puede encoger el label 
		
		ibanText= new TextField[6];
		for (int i = 0; i < ibanText.length; i++) {
			ibanText[i]= new TextField();
			ibanText[i].setPrefColumnCount(4);
		}
		
		hombreRadio= new RadioButton("Hombre");
		mujerRadio= new RadioButton("Mujer");
		
		ToggleGroup sexoGrupo= new ToggleGroup();
		sexoGrupo.getToggles().addAll(hombreRadio, mujerRadio);
		sexoGrupo.selectedToggleProperty().addListener((o, ov, nv)->{
			RadioButton seleccionado = (RadioButton) nv;
			System.out.println(seleccionado.getText());
		});
		
		descripcionArea= new TextArea();
		
		GridPane formPane= new GridPane();
		formPane.setGridLinesVisible(true);
		formPane.setPadding(new Insets(5));
		formPane.setHgap(5);
		formPane.setVgap(5);
		formPane.addRow(0, new Label("Nombre"), nombreText);
		formPane.addRow(1, new Label("Apellidos"), apellidosText);
		formPane.addRow(2, new Label("DNI"), dniText);
		formPane.addRow(3, new Label("Fecha de nacimiento"), fechaNacimiento, edadLabel);
		formPane.addRow(4, new Label ("IBAN:"), new HBox(5, ibanText));
		formPane.addRow(5, new Label("Sexo:"), new HBox(5 , hombreRadio, mujerRadio));
		formPane.addRow(6, new Label("Descripcion:"), descripcionArea);
		
		ColumnConstraints[]cols ={
			new ColumnConstraints(),
			new ColumnConstraints(),
			new ColumnConstraints()
		};
		formPane.getColumnConstraints().setAll(cols);
		
		RowConstraints [] rows= {
			new RowConstraints(),
			new RowConstraints(),
			new RowConstraints(),
			new RowConstraints(),
			new RowConstraints(),
			new RowConstraints(),
			new RowConstraints()
		};
		formPane.getRowConstraints().setAll(rows);
		
		//restricciones de la columna 8(1ºcolumna)
		cols[0].setHalignment(HPos.RIGHT);
		
		//restricciones de la columna 1(2º columna)
		cols[1].setHgrow(Priority.ALWAYS);
		
		//restricciones de la columna 6 (7ºFila)
		rows[6].setVgrow(Priority.ALWAYS);
		
		//restricciones especificas a nivel de componente
		GridPane.setFillWidth(dniText, false);
		GridPane.setColumnSpan(nombreText, 2);
		GridPane.setColumnSpan(apellidosText, 2);
		
		//panel inferior
		
		CheckBox gridLinesCheck= new CheckBox("Mostrar cuadricula");
		formPane.gridLinesVisibleProperty().bind(gridLinesCheck.selectedProperty());
		
		BorderPane root= new BorderPane();
		root.setPadding(new Insets(5));
		root.setCenter(formPane);
		root.setBottom(gridLinesCheck);
		
		Scene escena = new Scene(root, 640, 480);
		
		primaryStage.setTitle("GridPane Sample");
		primaryStage.setScene(escena);
		primaryStage.show();
		
		//bindeos
		
		edadLabel.textProperty().bind(edad.asString().concat(" años"));
		
		fechaNac.bind(fechaNacimiento.valueProperty());
		fechaNac.addListener((o, ov, nv)->
			onFechaNacChanged(o, ov, nv));
		edad.addListener((o, ov, nv)-> System.out.println("El alumno tiene " + nv + " años"));
	}

	private void onFechaNacChanged(ObservableValue<? extends LocalDate> o, LocalDate ov, LocalDate nv) {
		LocalDate fechaNacimiento= nv;
		LocalDate hoy = LocalDate.now();
		int años = Period.between(nv, hoy).getYears();
		edad.set(años);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
