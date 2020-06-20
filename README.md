# Algorithms_of_Networks_Min_Cost
Analysis the minimum cost for a flow through a network, the fast solution based on minimum cost path algorithm


# Some functions in Graph:

1. Create a Network:
>> * Graph graph = new Graph(numberOfNodes, k);
2. See the Network topology:
>> * graph.displayGraphStruct();
>> * graph.displayGraphCost();
>> * graph.displayGraphCapacity();
3. Get the Network from the graph:
>> * Node[] network = graph.getGraph();
4. Apply Dijisktra's algorithm on the Network:
>> * Dijasktra.minCostPathSearch(network);
5. See the network paths and costs:
>> * Dijasktra.minCostPath(network);
6. Filter all graph links with zero capacity:
>> * graph.filter(); // returns how many links are eliminated. 
