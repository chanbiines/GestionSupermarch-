/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondevente;

import gestiondevente.impl.EmployeImplement;

/**
 *
 * @author dhia zeiri
 */




/**
 *
 * @author dhia zeiri
 */
public class Employe extends Personne {
    private int num_employe;
    public Employe(int num_employe,String nom, String prenom, String mail, String Adresse, int tel, int age) {
        super(nom, prenom, mail, Adresse, tel, age);
        this.num_employe = num_employe;
        
        
    }

    public int getNum_employe() {
        return num_employe;
    }

    public void setNum_employe(int num_employe) {
        this.num_employe = num_employe;
    }
   
}