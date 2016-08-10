/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.io.IOException;

/**
 *
 * @author petersenrr
 */
public class Driver 
{
    public static void main(String[] args) throws IOException
    {
        LocalStocks localStock = new LocalStocks();
        Observe average = new Observe(localStock, new Average(), "Average");
        Observe change = new Observe(localStock, new Change(), "Change");
        Observe selection = new Observe(localStock, new Selection(), 
                "Selection");
        localStock.setSnap(localStock);
        localStock.setSnap(localStock);
        localStock.setSnap(localStock);
        localStock.setSnap(localStock);
        localStock.setSnap(localStock);
        localStock.removeObserver(selection);
        localStock.removeObserver(change);
        localStock.removeObserver(average);

    }
}
