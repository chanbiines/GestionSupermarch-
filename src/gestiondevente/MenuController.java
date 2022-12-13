/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestiondevente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dhia zeiri
 */
public class MenuController implements Initializable {

    
      @FXML
    private Button quitter;
      @FXML
    private Button gest;
     @FXML
    private Button prod;
     @FXML 
     private Button vente;

    @FXML
            public void got(ActionEvent e) throws IOException
    {    
        Stage st = new Stage();
                vente.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("Gestion de vente.fxml"));
                Scene scene = new Scene(rootA);
                st.setScene(scene);
                st.show();
                st.setResizable(false);
                
        
}
    @FXML
            public void quit(ActionEvent e) throws IOException
    {    
                quitter.getScene().getWindow().hide();
                 
}
            @FXML
            public void next(ActionEvent e) throws IOException
    {    
        Stage st = new Stage();
                gest.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("GestiondesUtilisateurs.fxml"));
                Scene scene = new Scene(rootA);
                st.setScene(scene);
                st.show();
                st.setResizable(false);
                
        
}
            
            
            
             @FXML
            public void gestproduit(ActionEvent e) throws IOException
    {    
        Stage st = new Stage();
                prod.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("Produit.fxml"));
                Scene scene = new Scene(rootA);
                st.setScene(scene);
                st.show();
                st.setResizable(false);
                
        
}
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
