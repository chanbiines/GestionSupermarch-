/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestiondevente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dhia zeiri
 */
public class GestionDeVenteController implements Initializable {
    Statement statement;
    java.sql.Connection connection;

    @FXML
    private TextField tfnum_facture;
    @FXML
    private TextField tfnum_produit;
    @FXML
    private TextField tfLabelle;
    @FXML
    private TextField tfReference;
    @FXML
    private TextField tfstock;
    @FXML
    private TextField tfstockdeSortie;
    @FXML
    private TextField tfprix;
    @FXML
    private TableView<vente> tvvente;
    @FXML
    private TableColumn<vente, Integer> colnum_facture;
    @FXML
    private TableColumn<vente,Integer> colnum_produit;
    @FXML
    private TableColumn<vente, String> colLabelle;
    @FXML
    private TableColumn<vente, String> colReference;
    @FXML
    private TableColumn<vente, Integer> colstock;
    @FXML
    private TableColumn<vente, Integer> colstockdeSortie;
    @FXML
    private TableColumn<vente,Double> colprix;
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
            
            showvente();
        }else if (event.getSource()==btnUpdate){
            updateRecord();
            showvente();    
        }else if(event.getSource()==btnDelete){
            deleteButton();
        }
    }
    public ObservableList<vente> getventeList(){
        try{
            ObservableList<vente>venteList=FXCollections.observableArrayList();
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
            
            //Connection conn = getConnection();
            String query="SELECT * from vente";
            Statement st;
            ResultSet rs;
            try{
                st= connection.createStatement();
                rs=st.executeQuery(query);
                vente ventes;
                while(rs.next()){
                    ventes=new vente(rs.getInt("num_facture"),rs.getInt("num_produit"),rs.getString("Labelle"),rs.getString("Reference"),rs.getInt("stock"),rs.getInt("stockdeSortie"),rs.getDouble("prix"));
                    venteList.add(ventes);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return venteList;
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(GestiondesUtilisateursController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    public void showvente(){
        ObservableList<vente>List=getventeList();
        colnum_facture.setCellValueFactory(new PropertyValueFactory<vente,Integer>("num_facture"));
        colnum_produit.setCellValueFactory(new PropertyValueFactory<vente,Integer>("num_produit"));
        colLabelle.setCellValueFactory(new PropertyValueFactory<vente,String>("Libelle"));
        colReference.setCellValueFactory(new PropertyValueFactory<vente,String>("Reference"));
        colstock.setCellValueFactory(new PropertyValueFactory<vente,Integer>("stock"));
        colstockdeSortie.setCellValueFactory(new PropertyValueFactory<vente,Integer>("stockdeSortie"));
        colprix.setCellValueFactory(new PropertyValueFactory<vente,Double>("prix"));    
        tvvente.setItems(List);
    }
    private void updateRecord(){
        String query=" UPDATE employe SET num_produit='"+tfnum_produit.getText()+"',Libelle='"+tfLabelle.getText()+"',Reference='"+tfReference.getText()+"',stock='"+tfstock.getText()+"',stockdeSortie='"+tfstockdeSortie.getText()+"',prix='"+tfprix.getText()+"'WHERE num_facture="+tfnum_facture.getText()+"";
        executeQuery(query);
        showvente();
    }
    private void deleteButton(){
        String query="DELETE FROM employe WHERE num_facture="+tfnum_facture.getText()+"";
        executeQuery(query);
        showvente();
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
}
