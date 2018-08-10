package FinalProject.BaseClasses;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import FinalProject.BaseClasses.Layer;
import FinalProject.BaseClasses.Perceptron;
import FinalProject.BaseClasses.Synapse;



public class Layer{

	
	  private List<Perceptron> perceptrons;
	    private Layer previousLayer;
	    private Layer nextLayer;
	    private Perceptron bias;

	    public Layer() {
	        perceptrons = new ArrayList<Perceptron>();
	        previousLayer = null;
	    }

	    public Layer(Layer previousLayer) {
	        this();
	        this.previousLayer = previousLayer;
	    }

	    public Layer(Layer previousLayer, Perceptron bias) {
	        this(previousLayer);
	        this.bias = bias;
	        perceptrons.add(bias);
	    }

            public void addPerceptron(Perceptron percep) {

	        perceptrons.add(percep);

	        if(previousLayer != null) {
	            for(Perceptron previousLayerNeuron : previousLayer.getPerceptrons()) {
	                percep.addInput(new Synapse(previousLayerNeuron, (Math.random() * 1) - 0.5)); //initialize with a random weight between -1 and 1
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

            public List<Perceptron> getPerceptrons() {
                return perceptrons;
            }

            public void setPerceptrons(List<Perceptron> perceptrons) {
                this.perceptrons = perceptrons;
            }

            public Perceptron getBias() {
                return bias;
            }

            public void setBias(Perceptron bias) {
                this.bias = bias;
            }
            
            
	    
//	    public void addNeuron(Perceptron percep, double[] weights) {
//
//	        perceptrons.add(percep);
//
//	        if(previousLayer != null) {
//
//	            if(previousLayer.getPerceptrons().size() != weights.length) {
//	                throw new IllegalArgumentException("The number of weights supplied must be equal to the number of percep in the previous layer");
//	            }
//
//	            else {
//	                List<Perceptron> previousLayerNeurons = previousLayer.getPerceptrons();
//	                for(int i = 0; i < previousLayerNeurons.size(); i++) {
//	                    percep.addInput(new Synapse(previousLayerNeurons.get(i), weights[i]));
//	                }
//	            }
//
//	        }
//	    }
	    
	    public void feedForward() {

	        int biasCount = hasBias() ? 1 : 0;

	        for(int i = biasCount; i < perceptrons.size(); i++) {
	            perceptrons.get(i).activate();
	        }
	    }

	
	
	
	
	
	
	
}