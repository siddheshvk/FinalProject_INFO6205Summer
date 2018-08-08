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
public class SigmoidActivation implements ActivationFunction{
    
    public double activate(double weightedSum) {
        return 1.0 / (1 + Math.exp(-1.0 * weightedSum));
    }

    public double derivative(double weightedSum) {
        return weightedSum * (1.0 - weightedSum);
    }
    
    public SigmoidActivation copy(){
        return new SigmoidActivation();
    }
}
