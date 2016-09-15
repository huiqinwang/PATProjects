package huiqin.yiji;

import java.util.Scanner;



public class PrinterFormat {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		int[] strings=new int[3];
		for(int i=0;i<3;i++){
			strings[i]=num%10;
			num=num/10;
		}
		
		for(int j=0;j<strings[2];j++){
			System.out.print("B");
		}
		for(int h=0;h<strings[1];h++){
			System.out.print("S");
		}
		for(int t=1;t<=strings[0];t++){
			System.out.print(t);
		}
		
	}
}
