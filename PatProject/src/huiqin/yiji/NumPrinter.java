package huiqin.yiji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumPrinter {
	public static void getSumNum(String num){
		
		int len=num.length();
		int sum=0;
		
		for(int i=0;i<len;i++){
			sum+=num.charAt(i)-'0';//方法２　字符分割＋string.substring(index - 1, index)＋list方法(用get：位置i和string的映射)
			//方法３　利用数组定位映射关系，字符asc码计算
		}
		List<String> strs=new ArrayList<String>();
		while((sum>=10)){
			strs.add(String.valueOf((int)sum%(int)(Math.pow(10, 1))));
			sum/=(Math.pow(10, 1));
		}
		strs.add(String.valueOf(sum));
		
		for(int i=strs.size()-1;i>=0;i--){
			String str=strs.get(i);
			String temString=getStringNum(str);
			if(temString!=null){
				System.out.print(temString+" ");
			}
		}
	}
	
	//可用map进行映射
	public static String getStringNum(String str){
		String tem=null;
		switch (str) {
		case "0":
			tem="ling";
			break;
		case "1":
			tem="yi";
			break;
		case "2":
			tem="er";
			break;
		case "3":
			tem="san";
			break;
		case "4":
			tem="si";
			break;
		case "5":
			tem="wu";
			break;
		case "6":
			tem="liu";
			break;
		case "7":
			tem="qi";
			break;
		case "8":
			tem="ba";
			break;
		case "9":
			tem="jiu";
			break;
		default:
			break;
		}
		return tem;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String num=scanner.next();
		
		getSumNum(num);
	}
}
