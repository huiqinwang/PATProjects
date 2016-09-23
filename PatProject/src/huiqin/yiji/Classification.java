package huiqin.yiji;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 按照要求的逻辑进行分类
 * @author huiqin @date 2016年9月19日 下午5:39:11
 * 此处太啰嗦　可想办法处理！！！ 目前只有swich
 */
public class Classification {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String numString=scanner.nextLine();
		DecimalFormat df =new DecimalFormat("#.0");
		int[] counts=new int[5];
		String[] strs=numString.split(" ");
		
		int a1=0;
		int a2=0;
		int a3=0;
		double a4=0.0;
		int a5=0;
		
		for(int j=0;j<strs.length;j++){
			int tem=Integer.parseInt(strs[j]);
			if(tem%5==0){
				if(tem%2==0){
					a1+=tem;
					counts[0]++;
				}
			}else{
				if(tem%5==1){
					a2+=tem*Math.pow(-1, counts[1]);
					counts[1]++;
				}else {
					if(tem%5==2){
						a3++;
						counts[2]++;
					}else {
						if(tem%5==3){
							//System.out.println("++");
							//System.out.println(tem);
							a4+=tem;
							counts[3]++;
						}else {
							if(tem>a5){
								a5=tem;
								counts[4]++;
							}
						}
					}
				}
			}
		}
		
		if(counts[0]!=0){
			System.out.print(a1+" ");
		}else {
			System.out.print("N"+" ");
		}
	
		if(counts[1]!=0){
			System.out.print(a2+" ");
		}else {
			System.out.print("N"+" ");
		}
		
		if(counts[2]!=0){
			System.out.print(a3+" ");
		}else {
			System.out.print("N"+" ");
		}
		
		if(counts[3]!=0){
			System.out.print(df.format(a4/counts[3])+" ");
		}else {
			System.out.print("N"+" ");
		}
		
		if(counts[4]!=0){
			System.out.print(a5+" ");
		}else {
			System.out.print("N"+" ");
		}
	}
}
