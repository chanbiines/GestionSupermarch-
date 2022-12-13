/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestiondevente;

import com.sun.jdi.connect.spi.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dhia zeiri
 */
public class GestiondesUtilisateursController implements Initializable {
    Statement statement;
    java.sql.Connection connection;
    @FXML
    private TextField tfNum_employe;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfAge;
    @FXML
    private TableView<Employe> tvEmploye;
    @FXML
    private TableColumn<Employe, Integer> colNum_emplye;
    @FXML
    private TableColumn<Employe, String> colNom;
    @FXML
    private TableColumn<Employe, String> colPrenom;
    @FXML
    private TableColumn<Employe, String> colmail;
    @FXML
    private TableColumn<Employe, String> colAdresse;
    @FXML
    private TableColumn<Employe, Integer> colTel;
    @FXML
    private TableColumn<Employe, Integer> colAge;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btnInsert){
            insertRecord();
            showEmploye();
        }else if (event.getSource()==btnUpdate){
            updateRecord();
            showEmploye();    
        }else if(event.getSource()==btnDelete){
            deleteButton();
        }
    }
    public Connection getConnection(){
        
        try{
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
            return (Connection) connection;
        }catch(Exception ex){
            System.out.println("Error:"+ex.getMessage());
            return null;
        }
            
        }
    public ObservableList<Employe> getEmployeList(){
        try{
            ObservableList<Employe>EmployeList=FXCollections.observableArrayList();
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
            
            //Connection conn = getConnection();
            String query="SELECT * from Employe";
            Statement st;
            ResultSet rs;
            try{
                st= connection.createStatement();
                rs=st.executeQuery(query);
                Employe Employes;
                while(rs.next()){
                    Employes=new Employe(rs.getInt("num_employe"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("Adresse"),rs.getInt("tel"),rs.getInt("Age"));
                    EmployeList.add(Employes);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return EmployeList;
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(GestiondesUtilisateursController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    public void showEmploye(){
        ObservableList<Employe>List=getEmployeList();
        colNum_emplye.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("num_employe"));
        colNom.setCellValueFactory(new PropertyValueFactory<Employe,String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Employe,String>("prenom"));
        colmail.setCellValueFactory(new PropertyValueFactory<Employe,String>("mail"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<Employe,String>("Adresse"));
        colTel.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("tel"));
        colAge.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("age"));    
        tvEmploye.setItems(List);
    }
    public void insertRecord(){
        String query="INSERT INTO employe(num_employe,nom,prenom,mail,Adresse,tel,age) VALUES ("+tfNum_employe.getText()+",'"+tfNom.getText()+"','"+tfPrenom.getText()+"','"+tfmail.getText()+"','"+tfAdresse.getText()+"',"+tfTel.getText()+","+tfAge.getText()+")";
        executeQuery(query);
        showEmploye();
        
    }

    private void executeQuery(String query) {
        try {
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(GestiondesUtilisateursController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Statement st;
        try{
            st= connection.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    private void updateRecord(){
        String query=" UPDATE employe SET nom='"+tfNom.getText()+"',prenom='"+tfPrenom.getText()+"',mail='"+tfmail.getText()+"',Adresse='"+tfAdresse.getText()+"',tel='"+tfTel.getText()+"',age='"+tfAge.getText()+"'WHERE num_employe="+tfNum_employe.getText()+"";
        executeQuery(query);
        showEmploye();
    }
    private void deleteButton(){
        String query="DELETE FROM employe WHERE num_employe="+tfNum_employe.getText()+"";
        executeQuery(query);
        showEmploye();
    }
}

                              
