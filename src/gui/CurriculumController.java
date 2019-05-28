package gui;

import model.Curriculum;
import model.Diploma;
import model.EsperienzaLavorativa;
import model.StudioEffettuato;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CurriculumController {
	
	/**
	 * Sample Skeleton for 'CurriculumView.fxml' Controller Class
	 */
	
	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="btnEsempi"
	    private Button btnEsempi; // Value injected by FXMLLoader

	    @FXML // fx:id="btnAddVoci"
	    private Button btnAddVoci; // Value injected by FXMLLoader

	    @FXML // fx:id="btnRemoveVoci"
	    private Button btnRemoveVoci; // Value injected by FXMLLoader

	    @FXML // fx:id="btnPrintCV"
	    private Button btnPrintCV; // Value injected by FXMLLoader

	    @FXML // fx:id="txtStatus"
	    private TextArea txtStatus; // Value injected by FXMLLoader

	    @FXML
	    void addVoci(ActionEvent event) {
	    	secondaryStage.setScene(scene2);
	    	secondaryStage.show();
	    	
	    }

	    @FXML
	    void caricaEsempi(ActionEvent event) {
	    	model.add(new StudioEffettuato(LocalDate.of(1969, 12, 25), LocalDate.of(1974, 01, 11), "Studio", "Itis Feltrinelli", new Diploma("Perito Informatico", "5", String.valueOf((int)(Math.random()*5+6)))));
			model.add(new EsperienzaLavorativa(LocalDate.of(1999, 12, 25), LocalDate.of(2005, 01, 11), "Lavoro", "Pernigotti", "1500", false, null));
			model.add(new StudioEffettuato(LocalDate.of(2076, 12, 25), LocalDate.of(2078, 01, 11), "Studio", "Itis Feltrinelli", new Diploma("Perito Informatico", "5", String.valueOf((int)(Math.random()*5+6)))));
			model.add(new EsperienzaLavorativa(LocalDate.of(2012, 12, 25), LocalDate.of(2015, 01, 11), "Lavoro", "Pernigotti", "1500", false, null));
			model.add(new EsperienzaLavorativa(LocalDate.of(2009, 12, 25), LocalDate.of(2010, 01, 11), "Lavoro", "Pernigotti", "1500", false, null));
			model.add(new StudioEffettuato(LocalDate.of(2005, 12, 25), LocalDate.of(2009, 01, 11), "Studio", "Itis Feltrinelli", new Diploma("Perito Informatico", "5", String.valueOf((int)(Math.random()*5+6)))));
			txtStatus.setText("Delle voci casuali sono state inserite al curriculum e ordinate come richiesto");
	    }

	    @FXML
	    void printCV(ActionEvent event) {

	    }

	    @FXML
	    void removeVoci(ActionEvent event) {

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert btnEsempi != null : "fx:id=\"btnEsempi\" was not injected: check your FXML file 'CurriculumView.fxml'.";
	        assert btnAddVoci != null : "fx:id=\"btnAddVoci\" was not injected: check your FXML file 'CurriculumView.fxml'.";
	        assert btnRemoveVoci != null : "fx:id=\"btnRemoveVoci\" was not injected: check your FXML file 'CurriculumView.fxml'.";
	        assert btnPrintCV != null : "fx:id=\"btnPrintCV\" was not injected: check your FXML file 'CurriculumView.fxml'.";
	        assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'CurriculumView.fxml'.";

	    }
		
	
	private Curriculum model;
	private Stage secondaryStage;
	private Scene scene1;
	private Scene scene2;
	
	void setModel(Curriculum model)
	{
		this.model = model;
	}
	
	void setStage(Stage secondaryStage)
	{
		this.secondaryStage = secondaryStage;
	}
	
	void setScene(Scene scene, int n)
	{
		if(n == 0)
			this.scene1 = scene;
		else
			this.scene2 = scene;
	}
}
