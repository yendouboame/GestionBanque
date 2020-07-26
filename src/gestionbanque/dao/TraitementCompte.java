/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbanque.dao;

import DataBase.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class TraitementCompte implements ICompte<Compte>{

    @Override
    public boolean enregistrer(Compte cpte) {
        
          Connection connect = ConnectDB.avoirConnexion();
        boolean enreg = false;
        String query = "INSERT INTO compte (typeCompte, dateCreation, etatCompte)" + 
                "VALUES (?, ?, ?)";
       
         try {
            PreparedStatement pst = connect.prepareStatement(query);
            pst.setString(1, cpte.getNom());
            pst.setString(2, cpte.getPrenom());
            pst.setDate(3, new java.sql.Date(cpte.getDateNaiss().getTime()));
            pst.setString(4, cpte.getSexe());
//            pst.setInt(5, cpte.getNumTel());
            pst.setString(5, cpte.getAdresse());
            enreg = pst.executeUpdate() == 1;
            JOptionPane.showMessageDialog(null, "Le compte a été créée avec succès");
            //enr = true;
        } catch (SQLException ex) {
            Logger.getLogger(TraitementClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           String req = "INSERT INTO client(nomCli, prenomCli, dateNaiss, sexeClient, adrCli)"+"VALUES(?, ?, ?, ?, ?)";
          try {
            PreparedStatement ps = connect.prepareStatement(req);
            ps.setString(1, cpte.getTypeCpte());
//            ps.setString(2, cpte.getIdClient());
//            ps.setString(3, cpte.getSolde());
            ps.setDate(2, new java.sql.Date(cpte.getDateCre().getTime()));
            ps.setString(3, cpte.getEtatCpte());
            enreg = ps.executeUpdate() == 1;
            JOptionPane.showMessageDialog(null, "Le compte a été créée avec succès");
            //enr = true;
        } catch (SQLException ex) {
            Logger.getLogger(TraitementClient.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
        return enreg;
    }

    @Override
    public List<Compte> lister() {
Connection connect = ConnectDB.avoirConnexion();
        List <Compte> listCompte = new ArrayList<>();
        ResultSet res;
        String query = "SELECT idCompte, typeCompte, montantCompte, dateCreation, etatCompte FROM compte";
        try {
            Statement st = connect.createStatement();
            res = st.executeQuery(query);
            while(res.next()) {
                Compte e = new Compte();
                e.setNumCpte(res.getInt("idCompte"));
                e.setNom(res.getString("typeCompte"));
                e.setSolde(res.getString("montantCompte"));
                e.setDateCre(res.getDate("dateCreation"));
                e.setEtatCpte(res.getString("etatCompte"));
                listCompte.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCompte;    
    }

    @Override
    public boolean supprimer(Compte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
