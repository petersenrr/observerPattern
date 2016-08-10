/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author petersenrr
 */
public class Change implements PrintOut
{

    @Override
    public String process(ArrayList<String[]> input, String last)
    {
        String report = last + ":\n";
        for (Iterator<String[]> it = input.iterator(); it.hasNext();) 
        {
            String[] line = it.next();
            double change = Double.parseDouble(line[4]);
            if (change >= 10.0 || change <= -10.0)
            {
                report += line[1] + " " + line[2] + " " + line[4] + "\n";
            }
        }
        return report + "\n";

    }
}
