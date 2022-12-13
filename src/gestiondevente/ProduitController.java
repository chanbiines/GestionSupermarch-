/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestiondevente;

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
public class ProduitController implements Initializable {
    Statement statement;
    java.sql.Connection connection;

    @FXML
    private TextField tfnum_produit;
    @FXML
    private TextField tfLibelle;
    @FXML
    private TextField tfReference;
    @FXML
    private TextField tfstock;
    @FXML
    private TextField tfprix;
    @FXML
    private TableView<Produit> tvProduit;
    @FXML
    private TableColumn<Produit, Integer> colnum_produit;
    @FXML
    private TableColumn<Produit, String> colLibelle;
    @FXML
    private TableColumn<Produit, String> colReference;
    @FXML
    private TableColumn<Produit, Integer> colstock;
    @FXML
    private TableColumn<Produit,Double> colprix;
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
        
        showProduit();
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btnInsert){
            insertRecord();
            showProduit();
        }else if (event.getSource()==btnUpdate){
            updateRecord();
            showProduit();    
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
    public ObservableList<Produit> getProduitList(){
        try{
            ObservableList<Produit>ProduitList=FXCollections.observableArrayList();
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
            
            //Connection conn = getConnection();                System.out.println("gestiondevente);

            String query="SELECT * FROM Produit";
            Statement st;
            ResultSet rs;
            try{
                st= connection.createStatement();
                rs=st.executeQuery(query);
                Produit Produits;
                while(rs.next()){
                    Produits=new Produit(rs.getInt("num_produit"),rs.getString("Libelle"),rs.getString("Reference"),rs.getInt("stock"),rs.getDouble("prix"));
                    ProduitList.add(Produits);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            System.out.println(ProduitList);
            return ProduitList;
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(GestiondesUtilisateursController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void showProduit(){
        System.out.println(getProduitList());
        ObservableList<Produit> List =getProduitList();
        //System.out.println(getProduitList());
        colnum_produit.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("num_produit"));
        colLibelle.setCellValueFactory(new PropertyValueFactory<Produit,String>("Libelle"));
        colReference.setCellValueFactory(new PropertyValueFactory<Produit,String>("Reference"));
        colstock.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("stock"));
        colprix.setCellValueFactory(new PropertyValueFactory<Produit,Double>("Prix"));
        tvProduit.setItems(List);
    }
    private void executeQuery(String query) {
        try {
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(GestiondesUtilisateursController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Statement st;
        try{
            st=connection.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void insertRecord(){
        String query="INSERT INTO produit(num_produit,Libelle,Reference,stock,prix) VALUES ("+tfnum_produit.getText()+",'"+tfLibelle.getText()+"','"+tfReference.getText()+"',"+tfstock.getText()+","+tfprix.getText()+")";
        executeQuery(query);
        showProduit();
        
    }
    private void updateRecord(){
        String query=" UPDATE employe SET Labelle='"+tfLibelle.getText()+"',Reference='"+tfReference.getText()+"',stock='"+tfstock.getText()+"',prix='"+tfprix.getText()+"'WHERE num_produit="+tfnum_produit.getText()+"";
        executeQuery(query);
        showProduit();
    }
    private void deleteButton(){
        String query="DELETE FROM employe WHERE num_produit="+tfnum_produit.getText()+"";
        executeQuery(query);
        showProduit();
    }
    
}
