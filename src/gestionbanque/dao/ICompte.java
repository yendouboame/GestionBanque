/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbanque.dao;

import java.util.List;

/**
 *
 * @author HP
 */
public interface ICompte <Cpte> {
     public boolean enregistrer(Cpte c);
        public List<Cpte> lister();
        public boolean supprimer(Cpte t);
    
}
