package huiqin.yiji;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * 不知道原题目的意思,可以进行观察逻辑
 * @author huiqin @date 2016年9月19日 下午1:01:16
 *
 */
public class Derivation {
	 public static void main(String[] args){ 
		 Scanner scanner=new Scanner(System.in);
		 String num=scanner.nextLine();
		 String[] strs=num.trim().split("\\s+");
		 Set<Integer> list=new LinkedHashSet<Integer>();
		 
		 for(int i=0,j=1;i<strs.length&&j<strs.length;i+=2,j=i+1){
			 int value1=Integer.parseInt(strs[i]);
			 int value2=Integer.parseInt(strs[j]);
			 
			 int valueMult=value1*value2;
			 int valueRedu=0;
			 if(value2!=0){
				valueRedu=value2-1;
			 }
			 if(valueMult==valueRedu&&valueMult==0){
				 list.add(0);
			 }else{
				 list.add(valueMult);
				 list.add(valueRedu);
			 }
		 }
		 
		 if(list.isEmpty()){
			 list.add(0);
			 list.add(0);
		 }
		 
		 for(Integer in:list){
			 System.out.print(in+" ");
		 }
	 }
}
