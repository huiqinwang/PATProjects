package huiqin.yiji;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/**
 * 利用一般小数的递归数值一定是大数的覆盖值
 * @author huiqin @date 2016年9月14日 下午1:56:14
 *　利用两个list＋一个数组即可
 */
public class GressClass2 {
	public void inputNum(Set<Integer> nums){
		List<Integer> fugaiIntegers=new ArrayList<Integer>();
		List<Integer> guanjianIntegers=new ArrayList<Integer>();
		
		for(Integer num:nums){
			while(num!=1){
				if(num%2==0){
					num/=2;
				}else {
					num=(3*num+1)/2;
				}
				fugaiIntegers.add(num);
			}
		}
		
		for(Integer num:nums){
			if(!fugaiIntegers.contains(num)){
				guanjianIntegers.add(num);
			}
		}
		
		for(Integer num:guanjianIntegers){
			System.out.print(num+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=Integer.parseInt(scanner.nextLine());
		Set<Integer> nums=new HashSet<Integer>();
		
		for(int i=0;i<num;i++){
			nums.add(Integer.parseInt(scanner.next()));
		}
		
		GressClass2 gsClass2=new GressClass2();
		gsClass2.inputNum(nums);
	}
}
