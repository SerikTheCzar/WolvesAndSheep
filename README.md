# WolvesAndSheep

This repo is a project made by Serik Czarnecki and Jonathan Gerraughty for Artificial Intelligence

The project aims to try and create examples of Traversing the popular mathematical scenario: Wolves and Sheep (aka the Missionaries and Cannibals Problem)

# The Scenario

Imagine you have two islands adjacent to eachother, on one island you have 3 Wolves, 3 Sheep, and a Boat.
In order to complete the puzzle you must send all of the animals to the other side of the island using the Boat, the Boat can only fit two animals at a time. However the catch is that you cannot leave a Sheep outnumbered by Wolves on an Island, or the Wolves will eat the Sheep.

# Analysis

This scenario is a great way to explain traversing the option tree that is made from the puzzle, since having a boat that can fit two animals means you have only a max of 5 possible options:

1) 0 wolves and 1 sheep.
2) 1 wolf, 1 sheep.
3) 1 wolf, 0 sheep.
4) 2 Wolves, 0 sheep.
5) And lastly - 0 wolves, and 2 sheep.

The most efficient algorithms for this are to use a breadth first search traversal, and a Depth First Search traversal

# Breadth First Search (BFS)

BFS searches the tree by prioritizing the entire next layer.

![image](https://user-images.githubusercontent.com/19233409/197439875-f3fe0c26-139f-4bdb-ac75-d97a702861c2.png)

This example explains the order in which BFS traverses a tree, regardless of the number of children a node has.

BFS uses a Queue, as it operates on a LIFO ordering (First In, First Out)

# Depth First Search (DFS)

DFS searches the Tree by trying to get deeper and deeper on a single branch until you either run out of moves, or you find the solution

![image](https://user-images.githubusercontent.com/19233409/197440040-27dfeec7-430b-4a61-973e-fd7208245046.png)

The DFS functions using a Stack, because the algorithm prioritizes the current branch (Last In, First Out)

# Notes

BFS appears to be faster than DFS, because BFS takes less time retracing steps in order to find the correct path.
