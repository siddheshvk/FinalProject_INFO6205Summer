/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import FinalProject.BaseClasses.Layer;
import FinalProject.BaseClasses.NeuralNetwork;
import FinalProject.BaseClasses.Perceptron;
import FinalProject.BaseClasses.SigmoidActivation;

/**
 *
 * @author Siddhesh
 */
public class PSAFinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        String filename=""
                
//             CSVReader csvread = new CSVReader();
//             
//             double[][] file  = csvread.readFile(1);
    NeuralNetwork andNeuralNetwork = createAndNeuralNetwork();
        NeuralNetwork orNeuralNetwork = createOrNeuralNetwork();
        NeuralNetwork xorNeuralNetwork = createXorNeuralNetwork();

        System.out.println("Testing AND neural network");

        andNeuralNetwork.setInputs(new double[]{0, 0});
        System.out.println("0 AND 0: " + andNeuralNetwork.getOutput()[0]);

        andNeuralNetwork.setInputs(new double[]{0, 1});
        System.out.println("0 AND 1: " + andNeuralNetwork.getOutput()[0]);

        andNeuralNetwork.setInputs(new double[]{1, 0});
        System.out.println("1 AND 0: " + andNeuralNetwork.getOutput()[0]);

        andNeuralNetwork.setInputs(new double[]{1, 1});
        System.out.println("1 AND 1: " + andNeuralNetwork.getOutput()[0] + "\n");


        System.out.println("Testing OR neural network");

        orNeuralNetwork.setInputs(new double[]{0, 0});
        System.out.println("0 OR 0: " + orNeuralNetwork.getOutput()[0]);

        orNeuralNetwork.setInputs(new double[]{0, 1});
        System.out.println("0 OR 1: " + orNeuralNetwork.getOutput()[0]);

        orNeuralNetwork.setInputs(new double[]{1, 0});
        System.out.println("1 OR 0: " + orNeuralNetwork.getOutput()[0]);

        orNeuralNetwork.setInputs(new double[]{1, 1});
        System.out.println("1 OR 1: " + orNeuralNetwork.getOutput()[0] + "\n");


        System.out.println("Testing XOR neural network");

        xorNeuralNetwork.setInputs(new double[]{0, 0});
        System.out.println("0 XOR 0: " + xorNeuralNetwork.getOutput()[0]);

        xorNeuralNetwork.setInputs(new double[]{0, 1});
        System.out.println("0 XOR 1: " + xorNeuralNetwork.getOutput()[0]);

        xorNeuralNetwork.setInputs(new double[]{1, 0});
        System.out.println("1 XOR 0: " + xorNeuralNetwork.getOutput()[0]);

        xorNeuralNetwork.setInputs(new double[]{1, 1});
        System.out.println("1 XOR 1: " + xorNeuralNetwork.getOutput()[0] + "\n");

//        NeuralNetwork untrained = createUntrainedXorNeuralNetwork();
//        TrainingDataGenerator xorTrainingDataGenerator = new XorTrainingDataGenerator();
//
//        BackPropagation backpropagator = new BackPropagation(untrained, 0.1, 0.9, 0);
//        backpropagator.train(xorTrainingDataGenerator, 0.0001);
//
//        System.out.println("Testing trained XOR neural network");
//
//        untrained.setInputs(new double[]{0, 0});
//        System.out.println("0 XOR 0: " + (untrained.getOutput()[0]));
//
//        untrained.setInputs(new double[]{0, 1});
//        System.out.println("0 XOR 1: " + (untrained.getOutput()[0]));
//
//        untrained.setInputs(new double[]{1, 0});
//        System.out.println("1 XOR 0: " + (untrained.getOutput()[0]));
//
//        untrained.setInputs(new double[]{1, 1});
//        System.out.println("1 XOR 1: " + (untrained.getOutput()[0]) + "\n");
                
    }
    
        private static NeuralNetwork createAndNeuralNetwork() {
        NeuralNetwork andNeuralNetwork = new NeuralNetwork("AND Network");

        Layer inputLayer = new Layer(null);

        Perceptron a = new Perceptron(new SigmoidActivation());
        Perceptron b = new Perceptron(new SigmoidActivation());

        inputLayer.addPerceptron(a);
        inputLayer.addPerceptron(b);

        Layer outputLayer = new Layer(inputLayer);
        Perceptron andPerceptron = new Perceptron(new SigmoidActivation());
        outputLayer.addPerceptron(andPerceptron);

        andNeuralNetwork.addLayer(inputLayer);
        andNeuralNetwork.addLayer(outputLayer);

        return andNeuralNetwork;
    }

    private static NeuralNetwork createOrNeuralNetwork() {
        NeuralNetwork orNeuralNetwork = new NeuralNetwork("OR Network");

        Layer inputLayer = new Layer(null);

        Perceptron a = new Perceptron(new SigmoidActivation());
        a.setOutput(0);

        Perceptron b = new Perceptron(new SigmoidActivation());
        b.setOutput(0);

        inputLayer.addPerceptron(a);
        inputLayer.addPerceptron(b);

        Layer outputLayer = new Layer(inputLayer);
        Perceptron orPerceptron = new Perceptron(new SigmoidActivation());
        outputLayer.addPerceptron(orPerceptron);

        orNeuralNetwork.addLayer(inputLayer);
        orNeuralNetwork.addLayer(outputLayer);

        return orNeuralNetwork;
    }

    private static NeuralNetwork createXorNeuralNetwork() {
        NeuralNetwork xorNeuralNetwork = new NeuralNetwork("XOR Network");

        Layer inputLayer = new Layer(null);

        Perceptron a = new Perceptron(new SigmoidActivation());
        a.setOutput(0);

        Perceptron b = new Perceptron(new SigmoidActivation());
        b.setOutput(0);

        inputLayer.addPerceptron(a);
        inputLayer.addPerceptron(b);

        Layer hiddenLayer = new Layer(inputLayer);

        Perceptron hiddenA = new Perceptron(new SigmoidActivation());
        Perceptron hiddenB = new Perceptron(new SigmoidActivation());

        hiddenLayer.addPerceptron(hiddenA);
        hiddenLayer.addPerceptron(hiddenB);

        Layer outputLayer = new Layer(hiddenLayer);
        Perceptron xorPerceptron = new Perceptron(new SigmoidActivation());
        outputLayer.addPerceptron(xorPerceptron);

        xorNeuralNetwork.addLayer(inputLayer);
        xorNeuralNetwork.addLayer(hiddenLayer);
        xorNeuralNetwork.addLayer(outputLayer);

        return xorNeuralNetwork;
    }

    private static NeuralNetwork createUntrainedXorNeuralNetwork() {
        NeuralNetwork xorNeuralNetwork = new NeuralNetwork("Trained XOR Network");

        Perceptron inputBias = new Perceptron(new SigmoidActivation());
        inputBias.setOutput(1);
        Layer inputLayer = new Layer(null, inputBias);

        Perceptron a = new Perceptron(new SigmoidActivation());
        a.setOutput(0);

        Perceptron b = new Perceptron(new SigmoidActivation());
        b.setOutput(0);

        inputLayer.addPerceptron(a);
        inputLayer.addPerceptron(b);

        Perceptron bias = new Perceptron(new SigmoidActivation());
        bias.setOutput(1);
        Layer hiddenLayer = new Layer(inputLayer, bias);

        Perceptron hiddenA = new Perceptron(new SigmoidActivation());
        Perceptron hiddenB = new Perceptron(new SigmoidActivation());

        hiddenLayer.addPerceptron(hiddenA);
        hiddenLayer.addPerceptron(hiddenB);

        Layer outputLayer = new Layer(hiddenLayer);
        Perceptron xorPerceptron = new Perceptron(new SigmoidActivation());
        outputLayer.addPerceptron(xorPerceptron);

        xorNeuralNetwork.addLayer(inputLayer);
        xorNeuralNetwork.addLayer(hiddenLayer);
        xorNeuralNetwork.addLayer(outputLayer);

        return xorNeuralNetwork;
    }
    
//    private static NeuralNetwork
    
}
