/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.BaseClasses;

/**
 *
 * @author Siddhesh
 */
public class LinearActivation {
    
    public double activate(double weightedSum) {
        return weightedSum;
    }

    public double derivative(double weightedSum) {
        return 1;
    }
    
    public LinearActivation copy(){
        return new LinearActivation();
    }
    
}
