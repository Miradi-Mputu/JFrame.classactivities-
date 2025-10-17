import javax.swing.*;
import java.awt.*;
public class ListButtonApplication {
    public static void main(String[] args) {
JFrame frame = new JFrame("List Button");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(350,200);
frame.setLayout(new FlowLayout());

JButton listButton = new JButton("Select Fruit");

JPopupMenu popupMenu = new JPopupMenu();
String[] options = {"Apple","Grape","Strawberry","Orange"};
for (String option : options){
    JMenuItem item = new JMenuItem(option);
    item.addActionListener(e->{
        JOptionPane.showMessageDialog(frame,"You selected:"+option);
    });
    popupMenu.add(item);
}
listButton.addActionListener(e->{
    popupMenu.show(listButton,0,listButton.getHeight());
        });
frame.add(listButton);
frame.setVisible(true);
    }
}