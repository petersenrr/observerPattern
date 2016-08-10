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
public interface PrintOut 
{
    public String process(ArrayList<String[]> input, String last);
}
