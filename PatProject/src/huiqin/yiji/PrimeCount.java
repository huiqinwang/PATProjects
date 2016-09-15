package huiqin.yiji;

import java.util.Scanner;
/**
 *  因为如果一个数不是素数是合数，
	那么一定可以由两个自然数相乘得到，
	其中一个大于或等于它的平方根，一个小于或等于它的平方根。并且成对出现。
 * @author huiqin @data 2016年9月15日 下午4:26:49
 *
 */
public class PrimeCount {
	
	//通过一个函数判断是否为素数,小于2的数即不是合数也不是素数
	public boolean prime(int num){
		if(num%2==0&&num!=2){
			return false;
		}
		
		for(int g=3;g<=Math.sqrt(num);g++){
			if(num%g==0){
				return false;
			}
		}
		
		return num!=1;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		int[] nums=new int[num];
		int count=2;
		int counts=0;
		
		
		if(num==1){
			System.out.println(0);
		}else {
			while(count<=num){
				boolean flag=true;
				for(int i=1;i<count;i++){
					if(count%2==0){
						flag=false;
						break;
					}
				}
				if(flag){
					System.out.println(counts+" "+count);
					nums[counts]=count;
					counts++;
				}
				count++;
			}
		}
		
		int primeCount=0;
		for(int j=1;j<nums.length;j++){
			if(nums[j]-nums[j-1]==2){
				primeCount++;
			}
		}
		
		System.out.println(primeCount/2);
		
	}
}
