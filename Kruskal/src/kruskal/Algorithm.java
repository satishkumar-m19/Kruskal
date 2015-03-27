package kruskal;
//import java.awt.//List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.JFrame;

import kruskal.Edge;

public class Algorithm {
	static InputControl inputs= new InputControl();
	List<Edge> MST;
	public static DrawGraph addlineMST = new DrawGraph();
	//List<Edge> MST, TSP; // Edge List
	// For Storing Time and Memory for all the algorithms
	
	long startAlgoTime;
	long endAlgoTime;
	long startTSPTime;
	long endTSPTime;
	// long freeMemoryStart;
	// long freeMemoryEnd;
	float totalWeight = 0; // Tsp total weight
	// HashMaps for storing
	HashMap<Node, Integer> visited = new HashMap<Node, Integer>(); // visited
																	// nodes
	HashMap<Node, Node> parentNodes = new HashMap<Node, Node>(); // parent nodes
	HashMap<Node, Integer> rank = new HashMap<Node, Integer>(); // rank for the
																// nodes
	//List<Edge> tempEdges = new ArrayList<Edge>(); // edge list for storing temp
													// edges in prim's
	Comparator<Edge> comparator = new edgeWeightComparator(); // for comparing
																// weights and
																// storing it
	PriorityQueue<Edge> tempEdge = null; // priority queue for edges in prim's
											// using min heap
	//List<Node> visitedNodes = new ArrayList<Node>(); // node list for storing
														// visited nodes
	HashMap<Node, Integer> visitedFake = new HashMap<Node, Integer>(); // storing
																		// visited
	public static void main(String args[])
	{
		//InputControl inputs= new InputControl();
		inputs.processInput();
		long starttime = System.currentTimeMillis();
		new Algorithm();
		long endtime = System.currentTimeMillis();
		
		System.out.println("Required time = "+ (endtime - starttime)+ " milliseconds");
				
		
		JFrame f1 = new JFrame("Minimum Spanning Tree");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.add(addlineMST);
		f1.setSize(1000, 1000);
		f1.setVisible(true);
		
		
	}
	public Algorithm()
	{
		MST=KruskalUnionFind();
	}
		// KRUSKAL'S UNION FIND WITHOUT PATH 
		
		private List<Edge> KruskalUnionFind() {
			// TODO Auto-generated method stub
			List<Edge> MST = new ArrayList<Edge>();
			int count = inputs.numberOfNodes - 1;
			Iterator nodeit = inputs.nodeList.iterator();
			while (nodeit.hasNext()) {
				Node n = (Node) nodeit.next();
				parentNodes.put(n, n);
				rank.put(n, 0);
			}
			Collections.sort(inputs.edgeList, new EdgeMergeSort());
			Iterator edgesItr = inputs.edgeList.iterator();
			while (edgesItr.hasNext()) {
				Edge e = (Edge) edgesItr.next();
				if (!Find(e.getStartNode()).equals(Find(e.getEndNode()))) {
					MST.add(e);
					addlineMST.addLine(e.getStartNode().getxValue(), e
							.getStartNode().getyValue(),
							e.getEndNode().getxValue(), e.getEndNode().getyValue(),
							e.getEdgeWeight(), e.getStartNode().getNodeId(), e
									.getEndNode().getNodeId());
					Union(e.getStartNode(), e.getEndNode());
					count--;
					System.out.println("MST edge added:"
							+ e.getStartNode().getNodeId() + ","
							+ e.getEndNode().getNodeId() + "," + e.getEdgeWeight());
				}
				if (count == 0)
					break;

			}
			nodeit = inputs.nodeList.iterator();
			while (nodeit.hasNext()) {
				Node n = (Node) nodeit.next();
				System.out.println("Node:" + n.getNodeId() + ",parent:"
						+ parentNodes.get(n).getNodeId() + ",rank:" + rank.get(n));
			}

			return MST;
		}

		// --------------------------------------UNION
		// FUNCTION--------------------------------------------
		private void Union(Node startNode, Node endNode) {
			// TODO Auto-generated method stub
			Node parentOfStart = Find(startNode);
			Node parentOfEnd = Find(endNode);
			int rankOfStart = rank.get(parentOfStart);
			int rankOfEnd = rank.get(parentOfEnd);
			if (rankOfStart == rankOfEnd) {
				parentNodes.put(parentOfEnd, parentOfStart);
				int newRank = rank.get(parentOfStart) + 1;
				rank.put(parentOfStart, newRank);
			} else if (rankOfStart > rankOfEnd) {
				parentNodes.put(parentOfEnd, parentOfStart);
			} else
				parentNodes.put(parentOfStart, parentOfEnd);
		}

		// -------------------------------------FIND
		// FUNCTION-------------------------------------------------------
		private Node Find(Node n) {
			// TODO Auto-generated method stub
			if (parentNodes.get(n).equals(n))
				return n;
			else
				return Find(parentNodes.get(n));
		}

}

//-------------------------- COMPARING
//WEIGHTS-------------------------------------------------------
class edgeWeightComparator implements Comparator<Edge> {
	@Override
	public int compare(Edge x, Edge y) {
		// Assume neither string is null. Real code should
		// probably be more robust
		if (x.getEdgeWeight() < y.getEdgeWeight()) {
			return -1;
		}
		if (x.getEdgeWeight() > y.getEdgeWeight()) {
			return 1;
		}
		return 0;
	}
}

//-----------------------------MERGE
//SORT-----------------------------------------------------------------
class EdgeMergeSort implements Comparator<Edge> {
	public int compare(Edge e1, Edge e2) {
		if (e1.getEdgeWeight() < e2.getEdgeWeight())
			return -1;
		else
			return 1;
	}

}