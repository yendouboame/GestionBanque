/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbanque.util;

import gestionbanque.dao.Compte;
import gestionbanque.dao.TraitementCompte;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ModelTableCompte {
    
    static DefaultTableModel model;
    
    public static DefaultTableModel avoirModelTable() {
        model = new DefaultTableModel();
        List <Compte> listEtud = new TraitementCompte().lister();
        for(Compte e : listEtud) {
            String[] donnees = {String.valueOf(e.getNumCpte()), e.getTypeCpte(), e.getSolde(), e.getDateCre().toString(), e.getEtatCpte()};
            model.addRow(donnees);
        }
        return model;
    }
    
}
