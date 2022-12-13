/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondevente;

/**
 *
 * @author dhia zeiri
 */
public class Personne {
    private String nom;
    private String prenom;
    private String mail;    
    private String Adresse;
    private int tel;
    private int age;

    public Personne(String nom, String prenom, String mail, String Adresse, int tel, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.Adresse = Adresse;
        this.tel = tel;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", Adresse=" + Adresse + ", tel=" + tel + ", age=" + age + '}';
    }
    

}
