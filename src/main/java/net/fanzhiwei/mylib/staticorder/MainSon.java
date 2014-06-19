package net.fanzhiwei.mylib.staticorder;

/**
 * 先执行父类静态块，再子类静态块，再父类构造器，再子类构造器
 */
public class MainSon extends Father {

	public MainSon(){
        //当父类没有无参构造器时，子类构造器必须先调用super();
        System.out.println("子类构造器");
	}

	static {
		System.out.println("mainson static");
	}

	public static void main(String[] args) {
		try{
			Class.forName("net.fanzhiwei.mylib.staticorder.Test");
            new MainSon();
		} catch(Exception e){
		}
	}
}
//father static
//mainson static
//test
//父类构造器
//子类构造器
