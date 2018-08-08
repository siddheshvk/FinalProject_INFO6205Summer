package FinalProject.BaseClasses;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import FinalProject.BaseClasses.Layer;
import FinalProject.BaseClasses.NeuralNetwork;
import FinalProject.BaseClasses.Perceptron;
import FinalProject.BaseClasses.Synapse;

/**
*
* @author sneha
*/

public class NeuralNetwork implements Serializable {
	
    private String name;
    private List<Layer> layers;
    private Layer input;
    private Layer output;

    public NeuralNetwork(String name) {
        this.name = name;
        layers = new ArrayList<Layer>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Layer> getLayers() {
        return layers;
    }
    
    public NeuralNetwork copy() {
        NeuralNetwork copy = new NeuralNetwork(this.name);

        Layer previousLayer = null;
        for(Layer layer : layers) {

            Layer layerCopy;

            if(layer.hasBias()) {
                Perceptron bias = layer.getNeurons().get(0);
                Perceptron biasCopy = new Perceptron(bias.getActivationStrategy().copy());
                biasCopy.setOutput(bias.getOutput());
                layerCopy = new Layer(null, biasCopy);
            }

            else {
                layerCopy = new Layer();
            }

            layerCopy.setPreviousLayer(previousLayer);

            int biasCount = layerCopy.hasBias() ? 1 : 0;

            for(int i = biasCount; i < layer.getNeurons().size(); i++) {
            	Perceptron neuron = layer.getNeurons().get(i);

            	Perceptron neuronCopy = new Perceptron(neuron.getActivationStrategy().copy());
                neuronCopy.setOutput(neuron.getOutput());
                neuronCopy.setError(neuron.getError());

                if(neuron.getInputs().size() == 0) {
                    layerCopy.addNeuron(neuronCopy);
                }

                else {
                    double[] weights = neuron.getWeights();
                    layerCopy.addNeuron(neuronCopy, weights);
                }
            }

            copy.addLayer(layerCopy);
            previousLayer = layerCopy;
        }

        return copy;
    }
    
    public void addLayer(Layer layer) {
        layers.add(layer);

        if(layers.size() == 1) {
            input = layer;
        }

        if(layers.size() > 1) {
            //clear the output flag on the previous output layer, but only if we have more than 1 layer
            Layer previousLayer = layers.get(layers.size() - 2);
            previousLayer.setNextLayer(layer);
        }

        output = layers.get(layers.size() - 1);
    }
    
    public double[] getWeights() {

        List<Double> weights = new ArrayList<Double>();

        for(Layer layer : layers) {

            for(Perceptron neuron : layer.getNeurons()) {

                for(Synapse synapse: neuron.getInputs()) {
                    weights.add(synapse.getWeight());
                }
            }
        }

        double[] allWeights = new double[weights.size()];

        int i = 0;
        for(Double weight : weights) {
            allWeights[i] = weight;
            i++;
        }

        return allWeights;
    }

}
