import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class threeXDGAME extends JPanel {
    JButton[] buttons = new JButton[81];
    public void initializeButtons(){
        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttons[i].setText("-");
            buttons[i].setBackground(Color.blue);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JButton buttonClicked = (JButton) event.getSource();
                    buttonClicked.setText(String.valueOf('x'));
                }
            }
        }
    }
    public threeXDGAME(){
        setLayout(new GridLayout(3,3));
        initializeButtons();
    }
}
