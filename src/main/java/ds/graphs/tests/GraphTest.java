package ds.graphs.tests;

import ds.graphs.GNode;
import ds.graphs.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {

	public static void main(String[] args) throws Exception {
		GNode<String> nodeA = new GNode<String>("A");
		GNode<String> nodeB = new GNode<String>("B");
		GNode<String> nodeC = new GNode<String>("C");
		GNode<String> nodeD = new GNode<String>("D");
		GNode<String> nodeE = new GNode<String>("E");
		GNode<String> nodeF = new GNode<String>("F");
		GNode<String> nodeG = new GNode<String>("G");

		// Attach B, C, D as NodeA adjacent nodes;
		nodeA.adjacentNodes.add(nodeB);
		nodeA.adjacentNodes.add(nodeC);
		nodeA.adjacentNodes.add(nodeD);

		// Attach E, F as NodeB adjacent nodes;
		nodeB.adjacentNodes.add(nodeE);
		nodeB.adjacentNodes.add(nodeF);

		// Attach A, G as NodeC adjacent nodes;
		nodeC.adjacentNodes.add(nodeA);
		nodeC.adjacentNodes.add(nodeG);

		Graph<String> graph = new Graph<>();
//		List<String> result = graph.BFS(nodeA);
//		System.out.print(">>>>>>>>>> GRAPH BFS Traversal >>>>>");
//		System.out.println(result);

//		List<String> dfsResult = graph.DFSUsingStack(nodeA);
		System.out.print(">>>>>>>>>> GRAPH DFS Traversal >>>>>");
//		System.out.println(dfsResult);
	}
}
