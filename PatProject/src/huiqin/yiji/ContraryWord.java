package huiqin.yiji;

import java.util.Scanner;

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
