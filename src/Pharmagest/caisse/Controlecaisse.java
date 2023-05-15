package Pharmagest.caisse;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Controlecaisse {

    @FXML
    private AnchorPane menuventeAnchorPane;

    @FXML
    public void menu(ActionEvent event){

        menuventeAnchorPane.setVisible(false);
    }

}
