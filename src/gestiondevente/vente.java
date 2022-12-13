/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondevente;
/**
 *
 * @author dhia zeiri
 */
public class vente extends Produit {
    private int num_facture;
    private int stockdeSortie;

    public vente(int num_facture,int num_produit, String Libelle, String Reference, int stock,int stockdeSortie, double prix) {
        super(num_produit, Libelle, Reference, stock, prix);
    }
    
}
