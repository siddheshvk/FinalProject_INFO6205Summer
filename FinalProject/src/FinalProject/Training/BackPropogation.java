/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Training;

import FinalProject.BaseClasses.Layer;
import FinalProject.BaseClasses.NeuralNetwork;
import FinalProject.BaseClasses.Perceptron;
import FinalProject.BaseClasses.Synapse;
import java.util.List;

/**
 *
 * @author Siddhesh
 */
public class BackPropogation {
    
    private NeuralNetwork neuralNetwork;
    private double learningRate;
    private double momentum;
    private double characteristicTime;
    private double currentEpoch;
    
    public double backtrain(double[][] inputs, double[][] expectedOutputs){
        
        
        for(int i=0; i<inputs.length;i++){
            
            double[] input = inputs[i];
            double[] expectedOutput = expectedOutputs[i];
            
            List<Layer> layers = neuralNetwork.getLayers();

            neuralNetwork.setInputs(input);
            double[] output = neuralNetwork.getOutput();
            
            for (int j = layers.size() - 1; j > 0; j--) {
                Layer layer = layers.get(j);

                for (int k = 0; k < layer.getPercepList().size(); k++) {
                    Perceptron percep = layer.getPerceptrons().get(k);
                    double percepError = 0;

                    if (layer.isOutputLayer()) {
                        //the order of output and expected determines the sign of the delta. if we have output - expected, we subtract the delta
                        //if we have expected - output we add the delta.
                        percepError = percep.getDerivative() * (output[k] - expectedOutput[k]);
                    } else {
                        percepError = percep.getDerivative();

                        double sum = 0;
                        List<Perceptron> downstreamPerceptrons = layer.getNextLayer().getPercepList();
                        for (Perceptron downstreamPerceptron : downstreamPerceptrons) {

                            int l = 0;
                            boolean found = false;
                            while (l < downstreamPerceptron.getInputs().size() && !found) {
                                Synapse synapse = downstreamPerceptron.getInputs().get(l);

                                if (synapse.getSourcePercep() == percep) {
                                    sum += (synapse.getWeight() * downstreamPerceptron.getError());
                                    found = true;
                                }

                                l++;
                            }
                        }

                        percepError *= sum;
                    }

                    percep.setError(percepError);
                }
            }
            
            for(int j = layers.size() - 1; j > 0; j--) {
                Layer layer = layers.get(j);

                for(Perceptron percep : layer.getNeurons()) {

                    for(Synapse synapse : percep.getInputs()) {

                        double newLearningRate = characteristicTime > 0 ? learningRate / (1 + (currentEpoch / characteristicTime)) : learningRate;
                        double delta = newLearningRate * percep.getError() * synapse.getSourcePercep().getOutput();

//                        if(synapseNeuronDeltaMap.get(synapse) != null) {
//                            double previousDelta = synapseNeuronDeltaMap.get(synapse);
//                            delta += momentum * previousDelta;
//                        }

//                        synapseNeuronDeltaMap.put(synapse, delta);
                        synapse.setWeight(synapse.getWeight() - delta);
                    }
                }
            }

            output = neuralNetwork.getOutput();
            error += error(output, expectedOutput);
        }

        return error;
        }
        
    }
    
}
