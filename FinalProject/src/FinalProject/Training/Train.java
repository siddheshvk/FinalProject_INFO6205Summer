package FinalProject.Training;

import FinalProject.BaseClasses.NeuralNetwork;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Siddhesh
 */
public class Train {
    
    private NeuralNetwork neuralNetwork;
    private BackPropogation backProp;

    public Train(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        
        this.backProp = new BackPropogation(neuralNetwork);
    }
    
    public void training(double[][] input, double [][] output){
        
        double error;
        
//        for(int i=0;i<500;i++){
            error = backProp.backPropogate(input, output);
//        }
    }
    
}
