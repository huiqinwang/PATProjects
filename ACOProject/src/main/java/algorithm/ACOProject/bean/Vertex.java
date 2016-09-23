package algorithm.ACOProject.bean;

public class Vertex implements Comparable<Vertex>{
	private String name;
	private int path;
	private boolean isMarked;
	
	
	
	public Vertex(String name,int path) {
		super();
		this.path = path;
		this.name = name;
		isMarked=false;
	}

	public Vertex(String name) {
		super();
		this.name = name;
		path=Integer.MAX_VALUE;
		isMarked=false;
	}

	public Vertex() {
		// TODO Auto-generated constructor stub
	}
	
	public Vertex(int path, String name, boolean isMarked) {
		super();
		this.path = path;
		this.name = name;
		this.isMarked = isMarked;
	}
	public int getPath() {
		return path;
	}
	public String getName() {
		return name;
	}
	public boolean isMarked() {
		return isMarked;
	}
	public void setPath(int path) {
		this.path = path;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}

	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return o.getPath()<this.getPath()? 1:-1;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", path=" + path + "]";
	}
}
