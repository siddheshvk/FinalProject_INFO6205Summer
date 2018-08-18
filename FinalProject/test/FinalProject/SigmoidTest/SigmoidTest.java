/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.SigmoidTest;

import FinalProject.BaseClasses.SigmoidActivation;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author Siddhesh
 */
public class SigmoidTest {
    
    @Test
    public void sigmoidTest1(){
        // Testing activation function
        
        //Excepted values calculated using online resource : https://keisan.casio.com/exec/system/15157249643325
        SigmoidActivation sig = new SigmoidActivation();
        
        double calValue = sig.activate(0.5);
        assertEquals(0.622459, calValue, 0.1);

        calValue = sig.activate(0.35);
        assertEquals(0.586618, calValue, 0.1);

        calValue = sig.activate(1);
        assertEquals(0.731059, calValue, 0.1);

        calValue = sig.activate(10);
        assertEquals(0.999955, calValue, 0.1);

        calValue = sig.activate(15);
        assertEquals(1, calValue, 0.1);      
        
    }

}
