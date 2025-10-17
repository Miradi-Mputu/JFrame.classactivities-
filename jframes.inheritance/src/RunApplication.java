import javax.swing.*;
import java.awt.*;

//these last two imports are for the buttons , one listens to the instruction the other makes the action happen
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//jText field, label,
//radio button :able to select one option at a time
//check box: allows the user to select more than one option at a time
//list: in java we use a "combo box", you can select one or more than one at a time
//before using any of these options they must be decleared

//Must always add extends JFrame
public class RunApplication extends JFrame{

   //this declares labels that will show in the
    private JTextField BatmansField;
    private JTextField StadiumField;
    private JTextField RunsScoredField;

    //we use JTextArea to display the output
    private JTextArea OutPutArea;

    //here we are declering the buttons that will display to the user
    private JButton SaveButton;
    private JButton ReadButton;
    private JButton ReportButton;

  public RunApplication() {
      //this is for the format of the page

      setTitle("Cricket Runs Scored Application");
      setSize(500, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setLayout(new BorderLayout(10, 10));

      //this is the panel for the frame to hold all the text boxs.labels and ect
      JPanel InputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
//in this line we are adding the panel and a title
      InputPanel.setBorder(BorderFactory.createTitledBorder("Enter Criket Details"));

//This is what the user will see the user will be displaed the lable ,
// they will input a certain value and the system will add it to a specific variable
      //This functions like the System.out and scanner to next for input
      InputPanel.add(new JLabel("Crickter Name"));
      BatmansField = new JTextField();
      InputPanel.add(BatmansField);

      InputPanel.add(new JLabel("Stadium"));
      StadiumField = new JTextField();
      InputPanel.add(StadiumField);

      InputPanel.add(new JLabel("Runs Scored"));
      RunsScoredField = new JTextField();
      InputPanel.add(RunsScoredField);

// here we are creating the buttons
      JPanel ButtonPanel = new JPanel(new FlowLayout());
      ReportButton = new JButton("Generate report");
      SaveButton = new JButton("Save to file");
      ReadButton = new JButton("Read from file");
//here we are adding the buttons to the panel, always add to the panel by saying the action type.add("here you state what you are adding ")
      ButtonPanel.add(ReportButton);
      ButtonPanel.add(SaveButton);
      ButtonPanel.add(ReadButton);

//this is to display and output
      OutPutArea = new JTextArea();
      OutPutArea.setEditable(false);
      OutPutArea.setBorder(BorderFactory.createTitledBorder("Output"));
      JScrollPane scrollPane = new JScrollPane(OutPutArea);

      add(InputPanel, BorderLayout.NORTH);
      add(ButtonPanel, BorderLayout.CENTER);
      add(OutPutArea, BorderLayout.SOUTH);

//for every button you need an action listener
      ReportButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  String Batsman = BatmansField.getText();
                  String Stadium = StadiumField.getText();
                  int RunsScored = Integer.parseInt(RunsScoredField.getText());

                  CricketRunsScored cricketRunsScored = new CricketRunsScored(Batsman, Stadium, RunsScored);
                  OutPutArea.setText(cricketRunsScored.printReport());
              } catch (NumberFormatException ex) {
                  JOptionPane.showMessageDialog(null, "PLease enter a valid number for runs.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }
          }
      });

      SaveButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  String Batsman = BatmansField.getText();
                  String Stadium = StadiumField.getText();
                  int RunsScored = Integer.parseInt(RunsScoredField.getText());

                  CricketRunsScored cricketRunsScored = new CricketRunsScored(Batsman, Stadium, RunsScored);
                  cricketRunsScored.savetothefile();
                  JOptionPane.showMessageDialog(null, "Data successfully saved to ", "Success", JOptionPane.ERROR_MESSAGE);

              } catch (NumberFormatException ex) {
                  JOptionPane.showMessageDialog(null, "PLease enter a valid number for runs.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }
          }
      });

      ReadButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  String Batsman = BatmansField.getText();
                  String Stadium = StadiumField.getText();
                  int RunsScored = Integer.parseInt(RunsScoredField.getText());

                  CricketRunsScored cricketRunsScored = new CricketRunsScored(Batsman, Stadium, RunsScored);
                  cricketRunsScored.readfromfile();
                  JOptionPane.showMessageDialog(null, "Data successfully saved to ", "Success", JOptionPane.ERROR_MESSAGE);

              } catch (NumberFormatException ex) {
                  JOptionPane.showMessageDialog(null, "PLease enter a valid number for runs.", "Input Error", JOptionPane.ERROR_MESSAGE);
              }
          }
      });


  }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->{
            new RunApplication().setVisible(true);
        });
    }
}


