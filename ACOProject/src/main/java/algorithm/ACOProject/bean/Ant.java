package algorithm.ACOProject.bean;

import java.util.Random;
import java.util.Vector;

public class Ant {
	private Vector<Integer> tabu;//禁忌表，存储该蚂蚁已经访问过的城市
	private Vector<Integer> allowedCities;//允许搜索的城市，存储可以访问的城市
	private float[][] delta;//信息数变化矩阵，存储该蚂蚁在一次循环（或者迭代）中经过的路径释放的信息素
	private int[][] distance;//距离矩阵
	
	private float alpha;
	private float beta;
	
	private int tourLength;//路径长度，走完全程的总成本
	private int cityNum;//城市数量
	
	private int firstCity;//起始城市
	private int currentCity;//当前城市
	
	public Ant() {
		// TODO Auto-generated constructor stub
		cityNum=30;
		tourLength=0;
	}
	
	public Ant(int num){
		cityNum=num;
		tourLength=0;
	}
	
	/**
	 * 初始化蚂蚁，随机选择起始位置
	 * @param distance
	 * @param a alpha
	 * @param b beta
	 */
	public void init(int[][] distance,float a,float b){
		alpha=a;
		beta=b;
		allowedCities=new Vector<Integer>();
		tabu=new Vector<Integer>();
		this.distance=distance;
		delta=new float[cityNum][cityNum];
		
		for(int i=0;i<cityNum;i++){
			Integer integer=new Integer(i);
			allowedCities.add(integer);
			for(int j=0;j<cityNum;j++){
				delta[i][j]=0.f;
			}
		}
		
		Random random=new Random(System.currentTimeMillis());
		firstCity=random.nextInt(cityNum);
		
		for(Integer i:allowedCities){
			if(i.intValue()==firstCity){
				allowedCities.remove(i);
				break;
			}
		}
		
		tabu.add(Integer.valueOf(firstCity));
		currentCity=firstCity;
	}
	
	public void selectNextCity(float[][] pheromone){
		float[] p=new float[cityNum];
		float sum=0.0f;
		
		//计算分母部分
		for(Integer i:allowedCities){
			sum+=Math.pow(pheromone[currentCity][i.intValue()], alpha)*Math.pow(1.0/distance[currentCity][i.intValue()], beta);
		}
		
		//计算概率矩阵
		for(int i=0;i<cityNum;i++){
			boolean flag=false;
			for(Integer j:allowedCities){
				if(i==j.intValue()){
					//p[i]表示选择城市的概率
					p[i]=(float)(Math.pow(pheromone[currentCity][i],alpha)*Math.pow(1.0/distance[currentCity][i], beta))/sum;
					flag=true;
					break;
				}
			}
			
			if(flag==false){
				p[i]=0.f;
			}
		}
		
		//轮盘赌选择下一个城市
		Random random=new Random(System.currentTimeMillis());//产生的随机数一样
		float selectP=random.nextFloat();
		int selectCity=0;
		float sum1=0.f;
		for(int i=0;i<cityNum;i++){
			sum1+=p[i];
			if(sum1>=selectP){   //?
				selectCity=i;
				break;
			}
		}
		
		//从允许选择的城市中去除select city
		for(Integer i:allowedCities){
			if(i.intValue()==selectCity){
				allowedCities.remove(i);
				break;
			}
		}
		//在禁忌表中添加select city
		tabu.add(Integer.valueOf(selectCity));
		currentCity=selectCity;
		
	}
	
	/**
	 * 计算路径长度
	 * @return　路径长度
	 */
	private int calculateTourLength(){
		int len=0;
		for(int i=0;i<cityNum;i++){
			len+=distance[this.tabu.get(i).intValue()][this.tabu.get(i+1).intValue()];
		}
		
		return len;
	}

	public Vector<Integer> getTabu() {
		return tabu;
	}

	public Vector<Integer> getAllowedCities() {
		return allowedCities;
	}

	public float[][] getDelta() {
		return delta;
	}

	public int[][] getDistance() {
		return distance;
	}

	public float getAlpha() {
		return alpha;
	}

	public float getBeta() {
		return beta;
	}

	public int getTourLength() {
		tourLength = calculateTourLength();
		return tourLength;
	}

	public int getCityNum() {
		return cityNum;
	}

	public int getFirstCity() {
		return firstCity;
	}

	public int getCurrentCity() {
		return currentCity;
	}

	public void setTabu(Vector<Integer> tabu) {
		this.tabu = tabu;
	}

	public void setAllowedCities(Vector<Integer> allowedCities) {
		this.allowedCities = allowedCities;
	}

	public void setDelta(float[][] delta) {
		this.delta = delta;
	}

	public void setDistance(int[][] distance) {
		this.distance = distance;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public void setBeta(float beta) {
		this.beta = beta;
	}

	public void setTourLength(int tourLength) {
		 
		this.tourLength = tourLength;
	}

	public void setCityNum(int cityNum) {
		this.cityNum = cityNum;
	}

	public void setFirstCity(int firstCity) {
		this.firstCity = firstCity;
	}

	public void setCurrentCity(int currentCity) {
		this.currentCity = currentCity;
	}
	
	
}
