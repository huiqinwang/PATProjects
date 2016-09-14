package huiqin.yiji;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepCount {
	public boolean isNumber(String num){
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher mc=pattern.matcher(num);
		
		return mc.matches();
	}
	
	public int getStepsCount(int num){
		int count=0;
		
		if(!isNumber(String.valueOf(num))){
			System.out.println("please input the right format number!!");
		}else {
			while(num!=1){
				if(num%2==0){
					num=num/2;
				}else{
					num=(3*num+1)/2;
				}
				
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("please input the number:");
		int num=scanner.nextInt();
		StepCount sCount=new StepCount();
		int count=sCount.getStepsCount(num);
		System.out.println(count);
	}
}
