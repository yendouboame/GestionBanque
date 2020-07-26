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
public interface IClient <C> {
        public boolean enregistrer(C c);
        public List<C> lister();
        public boolean supprimer(C t);

    
}
