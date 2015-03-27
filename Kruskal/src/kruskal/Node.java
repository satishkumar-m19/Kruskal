package kruskal;

import java.util.*;
import kruskal.*;
public class Node {

	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public float getxValue() {
		return xValue;
	}
	public void setxValue(int xValue) {
		this.xValue = xValue;
	}
	public float getyValue() {
		return yValue;
	}
	public void setyValue(int yValue) {
		this.yValue = yValue;
	}
	
	public List<Edge> getsuucEdges() {
		return succEdges;
	}
	public void setsuccEdges(List<Edge> succEdges) {
		this.succEdges = succEdges;
	}
	
	private String nodeId;
	private float xValue;
	private float yValue;
	public List<Edge> succEdges;
	
}