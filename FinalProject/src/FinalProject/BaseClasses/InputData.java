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
public class InputData {
    
    double[][] inputs;
    double[][] output;

    public InputData(double[][] inputs, double[][] output) {
        this.inputs = inputs;
        this.output = output;
    }
    
    public double[][] getInputs() {
        return inputs;
    }

    public void setInputs(double[][] inputs) {
        this.inputs = inputs;
    }

    public double[][] getOutput() {
        return output;
    }

    public void setOutput(double[][] output) {
        this.output = output;
    }
    
    
    
}
