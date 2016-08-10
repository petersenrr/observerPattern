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
public class Average implements PrintOut
{
    
    @Override
    public String process(ArrayList<String[]> input, String last)
    {

            double sum = 0;
            int count = 0;
            String returnString;

            for(String[] line : input)
            {
                sum += Double.parseDouble(line[2]);
                count++;

            }
            
            
            double number = (sum / count);
            String num = String.format("%.2f",number);
            returnString = last + ", Average price: $" + num + "\n\n";
            
            return returnString;
    }
}
