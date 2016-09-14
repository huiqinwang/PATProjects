package huiqin.yiji;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 成绩最大最小查找
 * @author huiqin @date 2016年9月14日 下午12:47:01
 *　面向对象概念
 */
public class GradesStudent {
	
	public void getRangeCore(Map<Integer,Student> stus,int core){
		int maxCore=core;
		int minCore=core;
		
		for(Integer c:stus.keySet()){
			if(c>maxCore){
				maxCore=c;
			}
			
			if(c<minCore){
				minCore=c;
			}
		}
		
		Student maxStudent=stus.get(maxCore);
		Student minStudent=stus.get(minCore);
		
		System.out.println(maxStudent.getStuName()+" "+maxStudent.getStuId());
		System.out.println(minStudent.getStuName()+" "+minStudent.getStuId());
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int num=Integer.parseInt(sc.nextLine());
		GradesStudent gStudent=new GradesStudent();
		Map<Integer,GradesStudent.Student> stusSet=new HashMap<Integer, GradesStudent.Student>();
		int coreFirst = 0;
		
		for(int i=0;i<num;i++){
			String nameString=sc.next();
			String stuIdString=sc.next();
			int core=Integer.parseInt(sc.next());
			if(i==0){
				coreFirst=core;
			}
			GradesStudent.Student student=new GradesStudent().new Student(nameString,stuIdString,core);
			stusSet.put(core, student);
			
		}
		
		gStudent.getRangeCore(stusSet,coreFirst);
	}
	
	class Student{
		private String stuName;
		private String stuId;
		private int core;
		
		public Student() {
			// TODO Auto-generated constructor stub
		}
		
		public Student(String stuName, String stuId, int core) {
			super();
			this.stuName = stuName;
			this.stuId = stuId;
			this.core = core;
		}
		public String getStuName() {
			return stuName;
		}
		public String getStuId() {
			return stuId;
		}
		public int getCore() {
			return core;
		}
		public void setStuName(String stuName) {
			this.stuName = stuName;
		}
		public void setStuId(String stuId) {
			this.stuId = stuId;
		}
		public void setCore(int core) {
			this.core = core;
		}
	}
	
	
}
