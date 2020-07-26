/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbanque.dao;

import gestionbanque.entite.Client;
import java.util.Date;
/**
 *
 * @author HP
 */
public class Compte extends Client{
    private int NumCpte;
   private String etatCpte;
   private Date dateCre;
   private String typeCpte;
   private String idClient;
   private String solde;

    public Compte() {
    }
   
   

    public Compte(int NumCpte, String etatCpte, Date dateCre, String typeCpte, String idClient, String solde) {
        this.NumCpte = NumCpte;
        this.etatCpte = etatCpte;
        this.dateCre = dateCre;
        this.typeCpte = typeCpte;
        this.idClient = idClient;
        this.solde = solde;
    }

    public Compte(int NumCpte, String etatCpte, Date dateCre, String typeCpte, String idClient, String solde, String id, String nom, String prenom, Date dateNaiss, String sexe, int numTel, String adresse) {
        super(id, nom, prenom, dateNaiss, sexe, numTel, adresse);
        this.NumCpte = NumCpte;
        this.etatCpte = etatCpte;
        this.dateCre = dateCre;
        this.typeCpte = typeCpte;
        this.idClient = idClient;
        this.solde = solde;
    }

    public int getNumCpte() {
        return NumCpte;
    }

    public void setNumCpte(int NumCpte) {
        this.NumCpte = NumCpte;
    }

    public String getEtatCpte() {
        return etatCpte;
    }

    public void setEtatCpte(String etatCpte) {
        this.etatCpte = etatCpte;
    }

    public Date getDateCre() {
        return dateCre;
    }

    public void setDateCre(Date dateCre) {
        this.dateCre = dateCre;
    }

    public String getTypeCpte() {
        return typeCpte;
    }

    public void setTypeCpte(String typeCpte) {
        this.typeCpte = typeCpte;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public void getDateCre(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
   
   
   
 
}
