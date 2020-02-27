package stringSplit;


public class StringSplitTest {

	public static void main(String[] args) {
		
			String str = "Welcome:dear guest";
			String[] arrOfStr = str.split(":");
			for (String a: arrOfStr)
				System.out.println(a);
	}
  }


