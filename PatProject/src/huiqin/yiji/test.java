package huiqin.yiji;

public class test {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};//一维int数组
		for(int i = 0;i<array.length/2;i++){
		    int temp = array[i];//中间变量
		 
		    array[i] = array[array.length-i-1];//进行转置
		 
		    array[array.length-i-1]=temp;//转置完成
		 
		}
		
		for(int j=0;j<array.length;j++){
			System.out.print(array[j]+" ");
		}
	}
}
