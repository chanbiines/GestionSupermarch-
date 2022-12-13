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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dhia zeiri
 */
public class SignInController implements Initializable {

   
    @FXML
    private TextField CIN;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField Username;

    @FXML
    private Button button;

    
    @FXML
            public void next(ActionEvent e) throws IOException
    {    
        Stage st = new Stage();
                button.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Scene scene = new Scene(rootA);
                st.setScene(scene);
                st.show();
                st.setResizable(false);
                
        
}
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
}
