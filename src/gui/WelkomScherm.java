package gui;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class WelkomScherm extends Pane {

	public WelkomScherm() {
		Label lblWelkom = new Label("Welkom!");
		
		
		lblWelkom.setLayoutX(200);
		lblWelkom.setLayoutY(10);
		
		
		
		this.getChildren().addAll(lblWelkom);
	}

}
