/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbanque.dao;

import DataBase.ConnectDB;
import gestionbanque.entite.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class TraitementClient implements IClient<Client>{

    public boolean enregistrer(Client c, Compte cpte) {
        Connection connect = ConnectDB.avoirConnexion();
        boolean enreg = false;
        String query = "INSERT INTO client (idClient, nomCli, prenomCli, dateNaiss, sexeClient, numTel, adrCli)" + 
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        
          try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setString(1, c.getId());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getPrenom());
            ps.setDate(4, new java.sql.Date(c.getDateNaiss().getTime()));
            ps.setString(5, c.getSexe());
            ps.setString(6, c.getNumTel()+"");
            ps.setString(7, c.getAdresse());
            enreg = ps.executeUpdate() == 1;
            //enr = true;
        } catch (SQLException ex) {
            Logger.getLogger(TraitementClient.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          String req = "INSERT INTO compte (idCompte, typeCompte, idClient, montantCompte,dateCreation, etatCompte)" + "VALUES(?, ?, ?, ?, ?, ?)";
          try {
            PreparedStatement pst = connect.prepareStatement(req);
           pst.setString(1, cpte.getNumCpte());
           pst.setString(2, cpte.getTypeCpte());
           pst.setString(3, cpte.getIdClient());
           pst.setString(4, cpte.getSolde());
           pst.setDate(5, new java.sql.Date(cpte.getDateCre().getTime()));
           pst.setString(6, cpte.getEtatCpte());
            enreg = pst.executeUpdate() == 1;
            JOptionPane.showMessageDialog(null, "Inscription éffectuée avec succès");
            
            
        } catch (Exception e) {
            Logger.getLogger(TraitementClient.class.getName()).log(Level.SEVERE, null, e);
        }
          
          
        return enreg;
        
    }

    @Override
    public List<Client> lister() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Client c) {
   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enregistrer(Client c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
