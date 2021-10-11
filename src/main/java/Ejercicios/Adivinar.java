package Ejercicios;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Adivinar extends Application{
	 
	private int numeroAAdivinar = (int)(Math. random()*100+1);
	private TextField numeroIntroducir;
	private Button comprobar;
	private int numIntentos=0;
	private double numeroIntroducidoInt=0;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		numeroIntroducir = new TextField();
		numeroIntroducir.setAlignment(Pos.CENTER);
	
		comprobar = new Button("Comprobar");
		comprobar.relocate(115, 120);
		
		
		HBox root =new HBox (5,comprobar,numeroIntroducir );
		
		Scene scene = new Scene(root, 320, 200); 
		
		primaryStage.setTitle("Adivinar");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		comprobar.setOnAction(g -> ganar (g));
	}

	private void ganar(ActionEvent g) {
		numeroIntroducidoInt=Integer.parseInt(numeroIntroducir.getText());
		++numIntentos;
		if(numeroIntroducidoInt>100||numeroIntroducidoInt<0) {
			//dialogo error
			Alert alertError = new Alert(AlertType.ERROR);
			alertError.setTitle("Adivinar");
			alertError.setHeaderText("ERROR");
			alertError.setContentText("El numero introducido no es valido");
			alertError.showAndWait();
			
			
		}else {
			if(numeroIntroducidoInt==numeroAAdivinar) {
				//dialogo al ganar
				Alert alertGanar= new Alert(AlertType.INFORMATION);
				alertGanar.setTitle("Adivinar");
				alertGanar.setHeaderText("¡ Has ganado !");
				alertGanar.setContentText("Solo has necesitado "+numIntentos+" intentos");
				alertGanar.showAndWait();
			}else if(numeroIntroducidoInt>numeroAAdivinar) {
				//dialogo al perder
				Alert alertPerder = new Alert(AlertType.WARNING);
				alertPerder.setTitle("Adivinar");
				alertPerder.setHeaderText("¡ Has fallado !");
				alertPerder.setContentText("El numero a adivinar es menor a "+numeroIntroducidoInt);
				alertPerder.showAndWait();
				}else {
					Alert alertPerder = new Alert(AlertType.WARNING);
					alertPerder.setTitle("Adivinar");
					alertPerder.setHeaderText("¡ Has fallado !");
					alertPerder.setContentText("El numero a adivinar es mayor a "+numeroIntroducidoInt);
					alertPerder.showAndWait();	
				}
				
				
			}
		}
		
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
