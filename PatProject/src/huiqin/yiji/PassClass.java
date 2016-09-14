package huiqin.yiji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 方法１：利用string的pattern需要对正则表达式
 * 方法2:利用len长度关系len(a)*len(b)=len(c)
 * @author huiqin @date 2016年9月13日 下午12:32:41
 *　问题：正则表示如何表示模式？？
 */
public class PassClass {
	public static List<String> judge(List<String> strs){
		List<String> resultList=new ArrayList<String>();
		
		for(String s:strs){
	        String pattern = "A*PA+TA*";  
	        String pattern1 = "PA+T";  
	        if (s.matches(pattern)) {  
	            if (s.matches(pattern1)) {  
	            	resultList.add("YES");  
	            } else {  
	                String temp[] = s.split("P|T");  
	                int aLength = temp[0].length();  
	                int bLength = temp[1].length();  
	                int cLength = temp[2].length();  
	                if ((cLength - aLength) / aLength == (bLength - 1)) {  
	                	resultList.add("YES");  
	                } else {  
	                	resultList.add("NO");  
	                }  
	  
	            }  
	        } else {  
	        	resultList.add("NO");  
	        }  
		}
		return resultList;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//int flagSum=scanner.nextInt();
		int flagSum=Integer.parseInt(scanner.nextLine());
		List<String> allInputStrings=new ArrayList<String>();
		
		for(int i=0;i<flagSum;i++){
			allInputStrings.add(scanner.nextLine());
		}
		
		//判断
		List<String> result=judge(allInputStrings);
		for(String resu:result){
			System.out.println(resu);
		}
	}
}
