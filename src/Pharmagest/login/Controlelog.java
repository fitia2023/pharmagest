package Pharmagest.login;


import Pharmagest.Modele.baseconnexion;
import Pharmagest.caisse.Controlecaisse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controlelog {
    Parent caisse;

    Scene scene;

    Stage stage;

    @FXML
    private Label erreur;

    @FXML
    private TextField nomuser;

    @FXML
    private PasswordField passuser;

    @FXML
    protected void loger(ActionEvent e){

        if (nomuser.getText().isBlank()&&passuser.getText().isBlank()){
            erreur.setId("er");
            erreur.setText("Le login et le mot de passe vide.");
            nomuser.setText("");
            passuser.setText("");

        }else {
            validation(e);
            nomuser.setText("");
            passuser.setText("");
        }
    }
    void validation(ActionEvent ev){
        String sql = "SELECT count(1) FROM pharmacien WHERE username='"+nomuser.getText()+"' AND mdp='"+passuser.getText()+"'";
        baseconnexion con = new baseconnexion();
        Connection bd = con.connection("pharmagest","pharmacie","root");

        try {
            Statement statement = bd.createStatement();
            ResultSet queryresult = statement.executeQuery(sql);
            while (queryresult.next()){
                if (queryresult.getInt(1)==1){
                    erreur.setId("wi");
                    erreur.setText("Réussi");
                    chargescene(ev);
                }else {
                    erreur.setId("er");
                    erreur.setText("Invalide user et mot de passe.");
                }
            }
        }catch (Exception e){
            System.out.print(e);
        }
    }


    public void chargescene(ActionEvent event) throws IOException {

        caisse = FXMLLoader.load(Controlecaisse.class.getResource("Caisse.fxml"));

        // Créez une nouvelle instance de Stage
        stage = new Stage();
        scene = new Scene(caisse);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setWidth(900);
        stage.setHeight(600);
        stage.show();

        // Ferme l'ancienne fenêtre
        Stage ancienneStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ancienneStage.close();
    }




}
