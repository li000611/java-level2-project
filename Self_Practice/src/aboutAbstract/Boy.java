package aboutAbstract;

public class Boy {
	String name;
	Boy(){
		this("zhangsanfeng");
	}
	
	Boy(String name){
		this.name = name;
	}
	
	void show() {
		System.out.println(this.name);
	}

	public static void main(String[] args) {
		Boy b = new Boy();
		b.show();
	}

}
