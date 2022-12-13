/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondevente;

/**
 *
 * @author dhia zeiri
 */
public class Produit {
    private int num_produit;
    private String Libelle;
    private String Reference;
    private int stock;
    private double prix;
    public Produit(int num_produit,String Libelle,String Reference,int stock,double prix){
        this.num_produit=num_produit;
        this.Libelle=Libelle;
        this.Reference=Reference;
        this.stock=stock;
        this.prix=prix;
    }
    public int getnum_produit(){
        return num_produit;
    }
    public String getlibelle(){
        return Libelle;
    }
    public String getRefernce(){
        return Reference;
    }
    public int getstock(){
        return stock;
    }
    public double getprix(){
        return prix;
    }
}
