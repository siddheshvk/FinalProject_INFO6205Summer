package FinalProject.BaseClasses;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import FinalProject.BaseClasses.Layer;
import FinalProject.BaseClasses.Perceptron;
import FinalProject.BaseClasses.Synapse;
import net.vivin.neural.Neuron;


public class Layer implements Serializable {

	
	  private List<Perceptron> neurons;
	    private Layer previousLayer;
	    private Layer nextLayer;
	    private Perceptron bias;

	    public Layer() {
	        neurons = new ArrayList<Perceptron>();
	        previousLayer = null;
	    }

	    public Layer(Layer previousLayer) {
	        this();
	        this.previousLayer = previousLayer;
	    }

	    public Layer(Layer previousLayer, Perceptron bias) {
	        this(previousLayer);
	        this.bias = bias;
	        neurons.add(bias);
	    }

	    public List<Perceptron> getNeurons() {
	        return this.neurons;
	    }

	    public void addNeuron(Perceptron neuron) {

	        neurons.add(neuron);

	        if(previousLayer != null) {
	            for(Perceptron previousLayerNeuron : previousLayer.getNeurons()) {
	                neuron.addInput(new Synapse(previousLayerNeuron, (Math.random() * 1) - 0.5)); //initialize with a random weight between -1 and 1
	            }
	        }
	    }
	    
	    public Layer getPreviousLayer() {
	        return previousLayer;
	    }

	    void setPreviousLayer(Layer previousLayer) {
	        this.previousLayer = previousLayer;
	    }

	    public Layer getNextLayer() {
	        return nextLayer;
	    }

	    void setNextLayer(Layer nextLayer) {
	        this.nextLayer = nextLayer;
	    }

	    public boolean isOutputLayer() {
	        return nextLayer == null;
	    }

	    public boolean hasBias() {
	        return bias != null;
	    }
	    
	    public void addNeuron(Perceptron neuron, double[] weights) {

	        neurons.add(neuron);

	        if(previousLayer != null) {

	            if(previousLayer.getNeurons().size() != weights.length) {
	                throw new IllegalArgumentException("The number of weights supplied must be equal to the number of neurons in the previous layer");
	            }

	            else {
	                List<Perceptron> previousLayerNeurons = previousLayer.getNeurons();
	                for(int i = 0; i < previousLayerNeurons.size(); i++) {
	                    neuron.addInput(new Synapse(previousLayerNeurons.get(i), weights[i]));
	                }
	            }

	        }
	    }
	    
	    public void feedForward() {

	        int biasCount = hasBias() ? 1 : 0;

	        for(int i = biasCount; i < neurons.size(); i++) {
	            neurons.get(i).activate();
	        }
	    }

	
	
	
	
	
	
	
}