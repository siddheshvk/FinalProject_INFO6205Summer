/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.NeuralNetworkTest;
import FinalProject.BaseClasses.Layer;
import FinalProject.BaseClasses.LinearActivation;
import FinalProject.BaseClasses.NeuralNetwork;
import FinalProject.BaseClasses.Perceptron;
import FinalProject.BaseClasses.SigmoidActivation;
import FinalProject.DB4OUtil;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author Siddhesh
 */
public class NeuralNetworkTest {
    
    Perceptron percep1 = new Perceptron(new SigmoidActivation());
    Perceptron percep2 = new Perceptron(new SigmoidActivation());

    Perceptron percep3 = new Perceptron(new SigmoidActivation());
    Perceptron percep4 = new Perceptron(new SigmoidActivation());
    Perceptron percep5 = new Perceptron(new SigmoidActivation());

    Perceptron percep6 = new Perceptron(new SigmoidActivation());
    
    Perceptron ipbias = new Perceptron(new LinearActivation());
    
    Perceptron hidbias = new Perceptron(new LinearActivation());

    Layer inputLayer = new Layer(null, ipbias);

    Layer hiddenLayer = new Layer (inputLayer,hidbias);        

    Layer outputLayer = new Layer(hiddenLayer);
    
    NeuralNetwork net = new NeuralNetwork("Test Network");
    
    DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    @Test
    public void percepTest1(){
        
        //Test to check the perceptrons are in their respectiev layers
        
                
        inputLayer.addPerceptron(percep1);
        inputLayer.addPerceptron(percep2);
        inputLayer.addPerceptron(ipbias);
        
        hiddenLayer.addPerceptron(percep3);
        hiddenLayer.addPerceptron(percep4);
        hiddenLayer.addPerceptron(percep5); 
        hiddenLayer.addPerceptron(hidbias); 
        
        outputLayer.addPerceptron(percep6);
        
        assertEquals(percep1,inputLayer.getPerceptrons().get(1));
        assertEquals(percep2,inputLayer.getPerceptrons().get(2));
        
        assertEquals(percep3,hiddenLayer.getPerceptrons().get(1));
        assertEquals(percep4,hiddenLayer.getPerceptrons().get(2));
        assertEquals(percep5,hiddenLayer.getPerceptrons().get(3));
        
        assertEquals(percep6,outputLayer.getPerceptrons().get(0));
        
    }
    
    @Test
    public void percepTest2(){
        // Test to check if proper layers are set
        
        assertEquals(inputLayer, hiddenLayer.getPreviousLayer());
        
        assertEquals(hiddenLayer, outputLayer.getPreviousLayer());
    }
    
    @Test
    public void percepTest3(){
        // Test to check if bias perceptron are in proper layer and have the right activation function
        
        assertTrue(inputLayer.hasBias());
        assertEquals(ipbias, inputLayer.getBias());
        assertTrue(hiddenLayer.hasBias());
        assertEquals(hidbias, hiddenLayer.getBias());
        assertFalse(outputLayer.hasBias());
        
    }
    
    @Test
    public void percepTest4(){
        
        //Test if the various layers are corrently stored and indentifed 
        
        net.addLayer(inputLayer);
        net.addLayer(hiddenLayer);
        net.addLayer(outputLayer);
        
        assertTrue(net.getLayers().get(2).isOutputLayer()); // check if output layers  automatically correctly identified 

    }
    
    @Test
    public void percepTest5(){
        
        // Testing if network is saved and retireved correctly
        
        dB4OUtil.storeSystem(net);          // save network
        
        NeuralNetwork checkNetwork = dB4OUtil.retrieveSystem();     // get network
        
        assertEquals(net.getName(),checkNetwork.getName());     // using neural network name as indicator that both saved and retrived network are same as object address of each 
                                                                //network would be different

    }
    
    
}
