/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author petersenrr
 */
public interface Subject 
{
    
       public void registerObserver(ObserverMine observer);

       public void removeObserver(ObserverMine observer);

       public void notifyObservers(LocalStocks input);
}

