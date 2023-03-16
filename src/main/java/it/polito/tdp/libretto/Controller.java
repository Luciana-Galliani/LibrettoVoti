package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller { //istanziata automaticamente da loader
	private Libretto model;
	
	//nel controller non devo mai fare la new, questa la faccio in app
	
	public void setModel(Libretto model) {
		this.model=model;
	}
	
	//CAPIRE QUALI SONO GLI ELEMENTI FONDAMENTALI CHE MI SERVONO PER LA GRAFICA
	
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<Integer> comboVoti;  //al posto di Integer avevo all'inizio ? perché non sa qual è il tipo del contenitore

	    @FXML
	    private DatePicker selezionaData;

	    @FXML
	    private TextField txtCorso;

	    @FXML
	    private TextArea txtRisultato;

	    @FXML
	    void handleInserisci(ActionEvent event) {
	    	String corso= txtCorso.getText();
	    	Integer punti= comboVoti.getValue(); //getValue mi da il riferimento del valore selezionato tra quelli possibili, se no null
	    	LocalDate data= selezionaData.getValue();
	    	
	    	Voto v= new Voto(corso, punti, data);
	    	this.model.add(v);
	    	
	    	this.txtRisultato.setText(this.model.toString());
	    }

	    @FXML
	    void initialize() {
	        assert comboVoti != null : "fx:id=\"comboVoti\" was not injected: check your FXML file 'main.fxml'.";
	        assert selezionaData != null : "fx:id=\"selezionaData\" was not injected: check your FXML file 'main.fxml'.";
	        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
	        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'main.fxml'.";

	        for(int p=18; p<=30; p++)
	        comboVoti.getItems().add(p);
	    }
}
