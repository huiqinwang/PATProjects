package huiqin.yiji;

import java.util.Scanner;

/**
 * 没啥技巧
 * @author huiqin @date 2016年9月19日 下午5:37:56
 *
 */
public class ContraryWord {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String wordString=scanner.nextLine();
		
		String[] woStrings=wordString.trim().split(" ");
		
		for(int j=woStrings.length-1;j>=0;j--){
			System.out.print(woStrings[j].trim()+" ");
		}
	}
}
