/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author petersenrr
 */
public class LocalStocks implements Subject
{
    private ArrayList<ObserverMine> observers = new ArrayList<>();
    private String last;
    private String input;
    private ArrayList<String[]> snap = new ArrayList<String[]>();
    private boolean updatedTimeLine = true;
    private Scanner fin = new Scanner(System.in);
    private BufferedReader br = null;
    private CheckTicker ticker = new CheckTicker();
    

    public LocalStocks() throws IOException
    {
        System.out.println("File to read?: ");
        input = fin.nextLine();
        br = new BufferedReader(new FileReader(input));
    }
    

    public void setSnap(LocalStocks input) throws IOException
    {
        String line;
        updatedTimeLine = true;
        snap.clear();

        while ((line = br.readLine()) != null) 
        {
            if(line.trim().length() == 0)
                 break;

            if(updatedTimeLine)
            {
                last = line;
                updatedTimeLine = false;
            }
            else
                snap.add(ticker.checkTicker(line));
        }
            changed(input);
    }

    public void changed(LocalStocks input)
    {
        notifyObservers(input);
    }

    public ArrayList<String[]> getSnap()
    {
        return snap;
    }

    public String getLast()
    {
       return last;
    }


    @Override
    public void registerObserver(ObserverMine observer) 
    {
           observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverMine observer) 
    {
           observers.remove(observer);
    }

    @Override
    public void notifyObservers(LocalStocks input) 
    {
           for (ObserverMine observer : observers) {

                  observer.update(input);
           }
    }
}
