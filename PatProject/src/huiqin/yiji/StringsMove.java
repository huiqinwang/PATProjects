package huiqin.yiji;

import java.util.Scanner;

/**
 * 第一种方法不断进行转置
 * @author huiqin @date 2016年9月18日 下午12:04:44
 *　倒置：(0,n-1)={5,4,3,2,1} (0,m-1)={4,5,3,2,1} (m-1,n-1)={4,5,1,2,3}
 */
public class StringsMove {
	public static String[] reserver(String[] strs,int m,int n){
		for(int i=0;i<(n-m)/2;i++){
			String temp=strs[i+m];
			strs[i+m]=strs[n-i-1];
			strs[n-i-1]=temp;
		}

		for(String str:strs){
			System.out.print(str+" ");
		}
		System.out.println();
		return strs;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//如何获取输入
		int len=Integer.parseInt(scanner.next());
		int n=Integer.parseInt(scanner.next());
		//System.out.println(len+" "+n);
		String[] strs=new String[len];
		for(int i=0;i<len;i++){
			strs[i]=scanner.next();
		}
/*		System.out.println("first");
		for(int i=0;i<len;i++){
			System.out.println(strs[i]);
		}*/
		
		String[] strs2=reserver(strs, 0, len);
		String[] strs3=reserver(strs2, 0, n);
		String[] strs4=reserver(strs3, n, len);
		
/*		for(String str:strs4){
			System.out.print(str+" ");
		}*/
	}
}
