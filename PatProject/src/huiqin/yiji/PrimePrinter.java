package huiqin.yiji;

import java.util.Scanner;

/**
 * 字符串位置，看清楚题目要求。具体数值之间的范围
 * @author huiqin @date 2016年9月22日 下午12:47:13
 *
 */
public class PrimePrinter {
	public static boolean isPrime(int num){
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String tString=scanner.nextLine();
		int m=Integer.parseInt(tString.split(" ")[0].trim());
		int n=Integer.parseInt(tString.split(" ")[1].trim());
		
		int[] strsStrings=new int[n];
		int count=0;
		int num=2;
		while(count<n-1&&num>0){
		 
				if(isPrime(num)){
					count++;
					strsStrings[count]=num;
				}
			
			
			num++;
		}
		
		
		for(int i=1;i<=n-m;i++){
			System.out.print(strsStrings[i+m-1]+" ");
			if((i)%10==0){
				System.out.println();
			}
		}
	}
}
