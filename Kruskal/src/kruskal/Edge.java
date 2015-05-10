package kruskal;

public class Edge {

	private float edgeWeight;
	private Node startNode;
	private Node endNode;

	public float getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(float edgeWeight) {
		this.edgeWeight = edgeWeight;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}

}