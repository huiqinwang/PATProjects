package huiqin.yiji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumPrinter {
	public static void getSumNum(String num){
		
		int len=num.length();
		int sum=0;
		
		for(int i=0;i<len;i++){
			sum+=num.charAt(i)-'0';//鏂规硶锛掋�瀛楃鍒嗗壊锛媠tring.substring(index - 1, index)锛媗ist鏂规硶(鐢╣et锛氫綅缃甶鍜宻tring鐨勬槧灏�
			//鏂规硶锛撱�鍒╃敤鏁扮粍瀹氫綅鏄犲皠鍏崇郴锛屽瓧绗sc鐮佽绠�		}
		List<String> strs=new ArrayList<String>();
		while((sum>=10)){
			strs.add(String.valueOf((int)sum%(int)(Math.pow(10, 1))));
			sum/=(Math.pow(10, 1));
		}
		strs.add(String.valueOf(sum));
		
		for(int j=strs.size()-1;j>=0;j--){
			String str=strs.get(j);
			String temString=getStringNum(str);
			if(temString!=null){
				System.out.print(temString+" ");
			}
		}
	}
	}
	
	//鍙敤map杩涜鏄犲皠
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
