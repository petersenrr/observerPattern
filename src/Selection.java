/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author petersenrr
 */
public class Selection implements PrintOut
{
    private String[] tickers = {"ALL","BA","BC","GBEL",
        "KFT","MCD","TR","WAG"};

    @Override
    public String process(ArrayList<String[]> input, String last)
    {
        String returnString = last + ":\n";
        for(String[] line : input)
        {
            if (Arrays.asList(this.tickers).contains(line[1]))
            {
                StringBuilder str = new StringBuilder();
                for (String s : line)
                {
                    str.append(s);
                    str.append(" ");
                }
                str.append("\n");
                returnString += str;
            }

        }
        return returnString + "\n";
    }
}
