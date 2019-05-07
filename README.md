# Neural Network

## Description
Neural network developed in JAVA based on Object Oriented Principles. 
Developed as a final project for the Program Structures and Algorithms course(Summer 2018). 
The Neural network developed was trained and tested on the hand written digits database(MNIST database) and was henced used to detect the digits. The object state and all the neural network paramters that are calculated during training of model are saved using DB4O utility. The state is revived back when the application loads.

## Introduction
Neural Network is a computational model based on the structure and functions of biological neural networks. Information that flows through the network affects the structure of the neural network because a neural network changes - or learns, in a sense - based on that input and output.

### Object Description

**Neural Network**

The neural network class holds the complete neural network comprised of various layers and perceptron. The neural network class stores the input layer, output layer and list of hidden layers. Provided with input the class is used to get the predicted output of the neural network.

**Layer**

The layer class performs the important operation of calculating the feed forward output of the entire later by traversing all the perceptron in the layer and calling them activate function

**Synapse**

The synapse object is used to store the connection between two perceptron. The object consist of following variable:
- Source Perceptron: used to store the source perceptron object that the synapse is used to connect.
- Weight: Each connection is associated with a weight that is used to multiply to the input which passes through it

**Perceptron**

The perceptron object in the project consist of following variables –
1. List of input synapses: List used to store the synapses i.e a list of connections that the other perceptron is connected to
2. Activation function object: Stores an instance of the activation function type object (sigmoid or linear) that the perceptron uses to      generate the output from the weighted sum.
3. Output: Used to store the output of program.
4. Derivative of the output: Output of the program after the weighted sum is passed through the derivative of the activation function.    Used    during back propagation.
5. Weighted sum value: The value found after multiplying the inputs with their corresponding weight and summing the individual product.
6. Error value: the difference in the expected output and the actual output of neuron

Further details of the project are furhter explained in the pdf file [Project Report](https://github.com/siddheshvk/FinalProject_INFO6205Summer/blob/master/Neural%20Networks.pdf)
