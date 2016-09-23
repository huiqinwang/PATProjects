package algorithm.ACOProject.main;

import algorithm.ACOProject.algorithm.ACO;

/**
 * 网址：http://www.cnblogs.com/biaoyu/archive/2012/09/26/2704456.html
 * @author huiqin @date 2016年9月23日 下午12:27:13
 *
 */
public class ACOMain {
	public static void main(String[] args) {
		ACO aco = new ACO(48, 100, 1000, 1.f, 5.f, 0.5f);
		aco.init("/home/huiqin/Desktop/acoData.txt");
		aco.solve();
	}
}
