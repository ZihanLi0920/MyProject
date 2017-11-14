package main.view;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * 
 * TestJTabbedPane
 *
 */
public class TestJTabbedPane {
	/**
	 * Main method for initializing the frame
	 * @param args
	 */
 public static void main(String[] args) {
    new MyFrame(); 
 }
}
/**
 * 
 * My Frame class
 *
 */
class MyFrame extends JFrame{
 /**
  * JPanel
  */
 JPanel jp=new JPanel();
 /**
  * JTabbedPane
  */
 JTabbedPane jtp =new JTabbedPane();
 /**
  * constructor
  */
 public MyFrame(){
  JPanel JButtonJP =new JPanel();
  JButtonJP.add(new JButton("鎸夐挳1"));
  JButtonJP.add(new JButton("鎸夐挳2"));
  JButtonJP.add(new JButton("鎸夐挳3"));
 
     JPanel  JLabelJP= new JPanel();
     JLabelJP.add(new JLabel("鏍囩涓�"));
     JLabelJP.add(new JLabel("鏍囩浜�"));
     JLabelJP.add(new JLabel("鏍囩涓�"));
     
     jtp.add("JButtonJP", JButtonJP);
     jtp.add("JLabelJP", JLabelJP);
     jp.add(jtp);
     this.add(jp);
     this.setTitle("閫夐」鍗TabbedPane鐨勪娇鐢�");
     this.addWindowListener(new WindowAdapter(){
      public void windowClosing(){
       System.exit(0);
      }
     });
     this.setSize(500,400);
     this.setVisible(true);
 }
}