package algorithm.ACOProject.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.ACOProject.bean.Ant;

/**
 * 蚂蚁之间并没有直接联系，而是通过路径上的信息素来进行间接的信息传递
 * @author huiqin @date 2016年9月22日 下午5:58:07
 *
 */
public class ACO {
	private Ant[] ants;//蚂蚁
	private int antNum;//蚂蚁数量
	private int cityNum;//城市数量
	private int MAX_GEN;//运行代数
	private float[][] pheromone;//信息素矩阵
	private int[][] distance;//距离矩阵
	private int bestLength;//最佳长度
	private int[] bestTour;//最佳路径
	
	//三个参数
	private float alpha;
	private float beta;
	private float rho;
	
	public ACO(){
		
	}

	public ACO(int antNum, int cityNum, int mAX_GEN, float alpha,
			float beta, float rho) {
		super();
		this.ants = new Ant[antNum];
		this.antNum = antNum;
		this.cityNum = cityNum;
		MAX_GEN = mAX_GEN;
		this.alpha = alpha;
		this.beta = beta;
		this.rho = rho;
	}
	
	public void init(String filename){
		//读取数据
		int[] x;
		int[] y;
		String strbuff;
		distance=new int[cityNum][cityNum];
		x=new int[cityNum];
		y=new int[cityNum];
        File file=new File(filename);
        FileInputStream fStream=null;
        InputStreamReader iStreamReader=null;
        BufferedReader bf=null;
        
    	try {
			fStream=new FileInputStream(file);
			iStreamReader=new InputStreamReader(fStream);
			bf=new BufferedReader(iStreamReader);
			for(int  i=0;i<cityNum;i++){
				strbuff=bf.readLine();
				System.out.println(strbuff);
				if(strbuff!=null){
					System.out.println(strbuff);
					String[] strcol=strbuff.split(" ");
					x[i]=Integer.valueOf(strcol[1]);
					y[i]=Integer.valueOf(strcol[2]);
				}
			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		
		
		//计算距离矩阵，针对具体问题，距离计算方法不一样，此处用的是att48作为案例，它有48个城市，距离计算方法为伪欧氏距离，最优值为10628
		for(int i=0;i<cityNum-1;i++){
			distance[i][i]=0;
			for(int j=i+1;j<cityNum;j++){
				double rij=Math.sqrt(((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))/10.0);
				int tij=(int)Math.round(rij);//取整数部分，数值+0.5后向下取值
				if(tij<rij){
					distance[i][j]=tij+1;
					distance[j][i]=distance[i][j];
				}else{
					distance[i][j]=tij;
					distance[j][i]=distance[i][j];
				}
			}
		}
		distance[cityNum-1][cityNum-1]=0;
		
		//初始化信息素矩阵
		pheromone=new float[cityNum][cityNum];
		for(int i=0;i<cityNum;i++){
			for(int j=0;j<cityNum;j++){
				pheromone[i][j]=0.1f;//初始化为0.1
			}
		}
		bestLength=Integer.MAX_VALUE;
		bestTour=new int[cityNum+1];
		
		//随机放置蚂蚁
		for(int i=0;i<antNum;i++){
			ants[i]=new Ant(cityNum);
			ants[i].init(distance, alpha, beta);
		}
	}
	
	public void solve(){
		for(int g=0;g<MAX_GEN;g++){
			for(int i=0;i<antNum;i++){
				for(int j=0;j<cityNum;j++){
					ants[i].selectNextCity(pheromone);
				}
				ants[i].getTabu().add(ants[i].getFirstCity());
				if(ants[i].getTourLength()<bestLength){
					bestLength=ants[i].getTourLength();
					for(int k=0;k<cityNum+1;k++){
						bestTour[k]=ants[i].getTabu().get(k).intValue();
					}
				}
				for(int j=0;j<cityNum;j++){
					ants[i].getDelta()[ants[i].getTabu().get(j).intValue()][ants[i].getTabu().get(i+1).intValue()]=(float)(1./ants[i].getTourLength());
					ants[i].getDelta()[ants[i].getTabu().get(j+1).intValue()][ants[i].getTabu().get(j).intValue()] = (float) (1./ants[i].getTourLength());
				}
			}
			
			//更新信息素
			updatePheromone();
			//重新初始化蚂蚁
			for(int i=0;i<antNum;i++){
				ants[i].init(distance, alpha, beta);//最佳成本路径（根据距离，迭代过程产生最低路径），信息素在每次迭代是会变的，信息素是一个重要的指标
			}
		}
		
		//打印最佳结果
		printOptimal();
	}
	
	//更新信息素
	private void updatePheromone(){
		//信息素挥发,避免算法陷入局部最优
		for(int i=0;i<cityNum;i++){
			for(int j=0;j<cityNum;j++){
				pheromone[i][j]=pheromone[i][j]*(1-rho);
			}
		}
		//更新信息素
		for(int i=0;i<cityNum;i++){
			for(int j=0;j<cityNum;j++){
			    for (int k = 0; k < antNum; k++) {
			    	pheromone[i][j] += ants[k].getDelta()[i][j];
			     } 
			}
		}
	}
	
	private void printOptimal(){
		System.out.println("The optimal length is: "+bestLength);
		System.out.println("The optimal tour is: ");
		for(int i=0;i<cityNum;i++){
			System.out.println(bestTour[i]);
		}
	}

	public Ant[] getAnts() {
		return ants;
	}

	public int getAntNum() {
		return antNum;
	}

	public int getCityNum() {
		return cityNum;
	}

	public int getMAX_GEN() {
		return MAX_GEN;
	}

	public float[][] getPheromone() {
		return pheromone;
	}

	public int[][] getDistance() {
		return distance;
	}

	public int getBestLength() {
		return bestLength;
	}

	public int[] getBestTour() {
		return bestTour;
	}

	public float getAlpha() {
		return alpha;
	}

	public float getBeta() {
		return beta;
	}

	public float getRho() {
		return rho;
	}

	public void setAnts(Ant[] ants) {
		this.ants = ants;
	}

	public void setAntNum(int antNum) {
		this.antNum = antNum;
	}

	public void setCityNum(int cityNum) {
		this.cityNum = cityNum;
	}

	public void setMAX_GEN(int mAX_GEN) {
		MAX_GEN = mAX_GEN;
	}

	public void setPheromone(float[][] pheromone) {
		this.pheromone = pheromone;
	}

	public void setDistance(int[][] distance) {
		this.distance = distance;
	}

	public void setBestLength(int bestLength) {
		this.bestLength = bestLength;
	}

	public void setBestTour(int[] bestTour) {
		this.bestTour = bestTour;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public void setBeta(float beta) {
		this.beta = beta;
	}

	public void setRho(float rho) {
		this.rho = rho;
	}
	
}
