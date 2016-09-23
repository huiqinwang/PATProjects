package huiqin.yiji;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * 基本没啥高逻辑性，主要是可能涉及数字的转化问题
 * @author huiqin @date 2016年9月19日 下午5:36:57
 *
 */
public class CompareThree {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int num=Integer.parseInt(scanner.nextLine());
		String[][] strs=new String[num][3];
		Map<String, String> resultMap=new LinkedHashMap<String, String>();
		
		for(int i=0;i<num;i++){
			strs[i][0]=scanner.next();
			strs[i][1]=scanner.next();
			strs[i][2]=scanner.next();
			if((Double.parseDouble(strs[i][0])+Double.parseDouble(strs[i][1]))>Double.parseDouble(strs[i][2])){
				resultMap.put("Case #"+(i+0)+":", "true");
			}else {
				resultMap.put("Case #"+(i+0)+":", "false");
			}
		}
		
		for(Entry<String, String> entry:resultMap.entrySet()){
			System.out.print(entry.getKey( )+" "+entry.getValue());
			System.out.println();
		}
	}
}
