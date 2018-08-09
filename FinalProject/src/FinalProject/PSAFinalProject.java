/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import FinalProject.BaseClasses.ActivationFunction;
import FinalProject.BaseClasses.InputData;
import FinalProject.BaseClasses.Layer;
import FinalProject.BaseClasses.LinearActivation;
import FinalProject.BaseClasses.NeuralNetwork;
import FinalProject.BaseClasses.Perceptron;
import FinalProject.BaseClasses.SigmoidActivation;
import FinalProject.Training.Train;

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
        CSVReader fileReader = new CSVReader();
        
        InputData inputData = new InputData();
        inputData = fileReader.readFile("train2");
        System.out.println("Training file read.");
        
        System.out.println("Creating neural network.....");
        NeuralNetwork digitNetwork = digitImageNetwork(inputData);
        
        
        Train networkTrainer  = new Train(digitNetwork);
        System.out.println("Training neural network....");
        networkTrainer.training(inputData.getInputs(),inputData.getOutput());
        System.out.println("Network trained");
        
        System.out.println("Reading test data file");
        InputData inputData2 = new InputData();
        inputData2 = fileReader.readFile("test");
        System.out.println("Test file read.");
        System.out.println("Running test data now....");
        
        int correct=0;
        for(int i=0;i<inputData2.getInputs().length;i++){
            double[] input = inputData2.getInputs()[i];
            int actualOutput = (int)inputData2.getOutput()[i][0];
            
            digitNetwork.setInputs(input);
            double[] receivedOutput = digitNetwork.getOutput();

            double max = receivedOutput[0];
            double recognizedDigit = 0;
            for(int j = 0; j < receivedOutput.length; j++) {
                if(receivedOutput[j] > max) {
                    max = receivedOutput[j];
                    recognizedDigit = j;
                }
            }

            System.out.println("Recognized " + actualOutput + " as " + recognizedDigit + ". Corresponding output value was " + max);
            
            if(actualOutput == (int)recognizedDigit){
                correct++;
            }
        
        }
        
        double acc = (double)((double)correct/(double)101);
        acc = acc * 100.0;
        System.out.println("Total test cases : " + inputData2.getInputs().length);
        System.out.println("Total correct recognition : " + correct);
        System.out.println("Accuracy percentage : " + acc+"%");
    
                
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
    
    private static NeuralNetwork digitImageNetwork(InputData ipData){
        
        NeuralNetwork neuralNetwork = new NeuralNetwork("MNIST Neural Network");
        
        Perceptron inputBias = new Perceptron(new LinearActivation());
        inputBias.setOutput(1);
        
        Layer inputLayer = new Layer(null, inputBias);
        
        for(int i = 0; i < ipData.getInputs()[0].length; i++) {
            Perceptron percep = new Perceptron(new SigmoidActivation());
            percep.setOutput(0);
            inputLayer.addPerceptron(percep);
        }
        
        Perceptron hiddenBias = new Perceptron(new LinearActivation());
        hiddenBias.setOutput(1);

        Layer hiddenLayer = new Layer(inputLayer, hiddenBias);
        
        long hiddenPercepNumber = Math.round((2.0 / 3.0) * (ipData.getInputs()[0].length) + 10);
        
        for(int i = 0; i < hiddenPercepNumber; i++) {
            Perceptron percep = new Perceptron(new SigmoidActivation());
            percep.setOutput(0);
            hiddenLayer.addPerceptron(percep);
        }
        
        Layer outputLayer = new Layer(hiddenLayer);

        //10 output neurons - 1 for each digit
        for(int i = 0; i < 10; i++) {
            Perceptron precep = new Perceptron(new SigmoidActivation());
//            Perceptron precep = new Perceptron(new LinearActivation());
            precep.setOutput(0);
            outputLayer.addPerceptron(precep);
        }

        neuralNetwork.addLayer(inputLayer);
        neuralNetwork.addLayer(hiddenLayer);
        neuralNetwork.addLayer(outputLayer);
        
        return neuralNetwork;
    }
    
}
