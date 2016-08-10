/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author petersenrr
 */
public class Observe implements ObserverMine

{
    private ArrayList<String[]> snap;
    private String reportWasProcessed;
    private String lastUpdated;
    private PrintWriter out;
    private PrintOut report;

    public Observe(Subject subject, PrintOut reportInput, String reportName)
    {
        subject.registerObserver(this);
        report = reportInput;
        try
        {
            out = new PrintWriter(reportName + ".dat");
        }
        catch (FileNotFoundException nfe)
        {
            System.out.print("Error");
        }

    }

    @Override
    public void update(LocalStocks localStocks)
    {
        if(localStocks instanceof LocalStocks)
        {
            LocalStocks localStocksSubject = (LocalStocks) localStocks;
            snap = localStocksSubject.getSnap();
            lastUpdated = localStocksSubject.getLast();
            reportWasProcessed = report.process(snap, lastUpdated);
            writeToFile();
        }
    }

    private void writeToFile()
    {
        out.print(reportWasProcessed);
        out.flush();
    }
}
