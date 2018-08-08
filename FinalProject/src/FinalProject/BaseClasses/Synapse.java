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
public class Synapse {
    
    private Perceptron sourcePercep;
    private double weight;

    public Synapse(Perceptron sourcePercep, double weight) {
        this.sourcePercep = sourcePercep;
        this.weight = weight;
    }

    public Perceptron getSourcePercep() {
        return sourcePercep;
    }

    public void setSourcePercep(Perceptron sourcePercep) {
        this.sourcePercep = sourcePercep;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    
    
    
}
