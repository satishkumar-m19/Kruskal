package kruskal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class InputControl {
	public int numberOfNodes = 0;
	public int numberOfEdges = 0;
	
	ArrayList<Node> nodeList = new ArrayList<Node>(); //Node list 
	ArrayList<Edge> edgeList = new ArrayList<Edge>(); //Edge list
	
	public void processInput()
	{
		
		numberOfEdges = (numberOfNodes * (numberOfNodes-1))/2;
		BufferedReader br = null;
		 
		try {
 
			//String sCurrentLine;
 
			br = new BufferedReader(new FileReader("/home/sati/inputfile.txt"));
 
			/*while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				sCurrentLine.
			}*/
 
		
		//Scanner fileInput = new Scanner(inputFile.getInputStream());	//Scans the file and parses the input

		//nodes population
		numberOfNodes = Integer.parseInt( br.readLine());
		for(int i=0;i<numberOfNodes;i++){
			Node inputNode = new Node();
			String nodeProps = br.readLine();
			String[] nodeProp;

			String delimiter = "[<,>]+";

			nodeProp = nodeProps.split(delimiter);

			//Checking result of split - temp code
			for (int j=0;j<nodeProp.length;j++)
				//System.out.print(nodeProp[j]+" ankur  1   "+j);

			inputNode.setNodeId(nodeProp[1]);
			inputNode.setxValue(Integer.parseInt(nodeProp[2]));
			inputNode.setyValue(Integer.parseInt(nodeProp[3]));
			nodeList.add(inputNode);	              
			//System.out.println();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator it=nodeList.iterator();
		//Printing the node list
		System.out.println("nodeList:");
		while(it.hasNext())
		{
			Node n=(Node) it.next();
			System.out.println("node:"+n.getNodeId()+","+n.getxValue()+","+n.getyValue());
		}
	for(int i=0;i<numberOfNodes;i++)
	{
		for(int j=i+1;j<numberOfNodes;j++)
		{
			float edgeWeight=0, edgeXWeight=0, edgeYWeight=0, edgeWeightSQRT=0;
			Node startNode=nodeList.get(i);
			Node endNode=nodeList.get(j);
			Edge newEdge=new Edge();
			newEdge.setStartNode(startNode);
			newEdge.setEndNode(endNode);
			//calculating the weight of the edges using the coordinates
			edgeXWeight=startNode.getxValue()-endNode.getxValue();
			edgeYWeight=startNode.getyValue()-endNode.getyValue();
			edgeWeight=((edgeXWeight*edgeXWeight)+(edgeYWeight*edgeYWeight));
			edgeWeightSQRT=(float) Math.sqrt(edgeWeight);
			newEdge.setEdgeWeight(edgeWeightSQRT);
			edgeList.add(newEdge);
			//addlineclique.addLine(newEdge.getStartNode().getxValue(), newEdge.getStartNode().getyValue(), newEdge.getEndNode().getxValue(), newEdge.getEndNode().getyValue(),newEdge.getEdgeWeight(),newEdge.getStartNode().getNodeId(),newEdge.getEndNode().getNodeId());
		}
	}
	Iterator itr=edgeList.iterator();
	System.out.println("edgeList:");
	while(itr.hasNext())
	{
		Edge e=(Edge) itr.next();
		System.out.println("edge:"+e.getStartNode().getNodeId()+","+e.getEndNode().getNodeId()+","+e.getEdgeWeight());
	}
}}