package awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class PaneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Frame f = new Frame("Test Frame");
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new Button("Clik me"));
		f.add(p);
		f.setBounds(30,30,250,120);
		f.setVisible(true);
	}

}
 