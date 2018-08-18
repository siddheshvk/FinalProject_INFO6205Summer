/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.BaseClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Siddhesh
 */
public class Perceptron {
    
    private List<Synapse> inputs;
    private ActivationFunction actFunc;
    private double output;
    private double derivative;
    private double weightedSum;
    private double error;

    public Perceptron(List<Synapse> inputs, double output, double derivative, double weightedSum, double error) {
        this.inputs = inputs;
        this.output = output;
        this.derivative = derivative;
        this.weightedSum = weightedSum;
        this.error = error;
    }
    
    public Perceptron(ActivationFunction actFunc) {
//    public Perceptron() {
        inputs = new ArrayList<Synapse>();
        this.actFunc = actFunc;
//        actFunc  = new SigmoidActivation();
        error = 0;
    }
    
    private void calculateWeightedSum() {
        weightedSum = 0;
        for(Synapse synapse : inputs) {
            weightedSum += synapse.getWeight() * synapse.getSourcePercep().getOutput();
        }
    }

    public void activate() {
        calculateWeightedSum();
        output = actFunc.activate(weightedSum);
        derivative = actFunc.derivative(output);
    }
    
    public ActivationFunction getActivation(){
        return actFunc;
    }
    
    public double[] getWeights() {
        double[] weights = new double[inputs.size()];

        int i = 0;
        for(Synapse synapse : inputs) {
            weights[i] = synapse.getWeight();
            i++;
        }

        return weights;
    }
    
    public void addInput(Synapse input){
        inputs.add(input);
    }
    public List<Synapse> getInputs() {
        return inputs;
    }

    public void setInputs(List<Synapse> inputs) {
        this.inputs = inputs;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getDerivative() {
        return derivative;
    }

    public void setDerivative(double derivative) {
        this.derivative = derivative;
    }

    public double getWeightedSum() {
        return weightedSum;
    }

    public void setWeightedSum(double weightedSum) {
        this.weightedSum = weightedSum;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }
  
}
