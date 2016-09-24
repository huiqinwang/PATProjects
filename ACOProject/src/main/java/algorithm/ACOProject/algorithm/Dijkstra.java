package algorithm.ACOProject.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import algorithm.ACOProject.bean.Vertex;

public class Dijkstra {
	private List<Vertex> vertexs;
	private int[][] edges;
	private Queue<Vertex> unVisited;
	private List<Vertex> resultVertexs;
	
	public Dijkstra(List<Vertex> vertexs, int[][] edges) {
		super();
		this.vertexs = vertexs;
		this.edges = edges;
		resultVertexs=new ArrayList<Vertex>();
		initUnVisited();
	}
	
	public void search(){
		while(!unVisited.isEmpty()){
			Vertex vertex=unVisited.element();
			if(vertex.isMarked()!=true){
				vertex.setMarked(true);
				List<Vertex> neighbors=getNeighbors(vertex);
				updateDistances(vertex,neighbors);
				Vertex neighbor=unVisited.poll();//PriorityQueue一直都是按照path排序
				resultVertexs.add(neighbor);
			}
		}
	}
	
	/**
	 * 找出邻居中最短路径的点
	 * @return
	 */
	public Vertex findMinDistance(List<Vertex> neighbors){
		int min=Integer.MAX_VALUE;
		Vertex minVertex=new Vertex();
		for(Vertex neighbor:neighbors){
			int path=neighbor.getPath();
			if(path<min){
				min=path;
				minVertex=neighbor;
			}
		}
		return minVertex;
	}
	
	/**
	 * 更新这个点的邻居节点的最短路径
	 * @param vertex　
	 * @param neighbors
	 */
	public void updateDistances(Vertex vertex,List<Vertex> neighbors){
		for(Vertex neighbor:neighbors){
			updateDistances(vertex, neighbor);
		}
	}
	
	public void updateDistances(Vertex vertex,Vertex neighbor){
		int distances=getDistances(vertex,neighbor)+vertex.getPath();
		if(distances<neighbor.getPath()){
			neighbor.setPath(distances);
		}
		
	}
	
	public int getDistances(Vertex vertex,Vertex neighbor){
		int srcVertex=vertexs.indexOf(vertex);
		int dstVertex=vertexs.indexOf(neighbor);
		
		return edges[srcVertex][dstVertex];
	}
	
	/**
	 * 获得指定节点的相邻节点
	 * @param vertex　当前节点
	 * @return　List<Vertex>　邻居节点
	 */
	public List<Vertex> getNeighbors(Vertex vertex){
		List<Vertex> neighbors=new ArrayList<Vertex>();
		int size=vertexs.size();
		int position=vertexs.indexOf(vertex);
		
		for(int i=0;i<size;i++){
			if(i==position){
				continue;
			}
			if(edges[position][i]!=Integer.MAX_VALUE){
				neighbors.add(vertexs.get(i));
			}
		}
		
		return neighbors;
	}
	
	/**
	 * 初始化未访问节点
	 */
	public void initUnVisited(){
		unVisited=new PriorityQueue<Vertex>();
		for(Vertex vertex:vertexs){
			unVisited.add(vertex);
		}
	}
	
	/**
	 * 打印图
	 */
	public void printGraph(){
		int size=vertexs.size();
		for(int i=0;i<size;i++){
			System.out.print(vertexs.get(i)+"==> ");
			for(int j=0;j<size;j++){
				if(edges[i][j]!=Integer.MAX_VALUE){
					System.out.print(vertexs.get(j)+": "+edges[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

	public List<Vertex> getVertexs() {
		return vertexs;
	}

	public int[][] getEdges() {
		return edges;
	}

	public Queue<Vertex> getUnVisited() {
		return unVisited;
	}



	public List<Vertex> getResultVertexs() {
		return resultVertexs;
	}

	public void setResultVertexs(List<Vertex> resultVertexs) {
		this.resultVertexs = resultVertexs;
	}

	public void setVertexs(List<Vertex> vertexs) {
		this.vertexs = vertexs;
	}

	public void setEdges(int[][] edges) {
		this.edges = edges;
	}

	public void setUnVisited(Queue<Vertex> unVisited) {
		this.unVisited = unVisited;
	}

	public void setResultVertexs(Stack<Vertex> resultVertexs) {
		this.resultVertexs = resultVertexs;
	}
}
