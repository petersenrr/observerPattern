/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;

/**
 *
 * @author petersenrr
 */
public class CheckTicker 
{
    public String[] checkTicker(String line)
    {
        String[] formatted = formatTicker(line);

        return formatted;
    }

    public String[] formatTicker(String line)
    {
        String[] parts = line.split(" +");

        for(int i = 0; i < parts.length; i++)
        {
            ArrayList<String> inputArray = new ArrayList<>();
            String companyName = "";
            
            if(checkUntilNumber(parts[i]))
            {
                for(int j = 0; j <= (i - 2); j++)
                {
                    companyName += parts[j] + " ";
                }
                
                inputArray.add(companyName);
                inputArray.add(parts[i-1]);
                
                for(int j = i; j < parts.length; j++)
                {
                    inputArray.add(parts[j]);
                }
                
                String[] returnArray = inputArray.toArray(new String[inputArray.size()]);

                return returnArray;
            }
        }
        return parts;
    }


    public boolean checkUntilNumber(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
