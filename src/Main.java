import javax.swing.JButton;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        Jframe.ClickerFrame frame = new Jframe.ClickerFrame();

        JButton click = new JButton("Click");
        click.setBounds((frame.getWidth() - 120) / 2, 50, 120, 30);
        frame.add(click);

        JLabel amount = new JLabel("0");
        amount.setBounds((frame.getWidth() - 120) / 2, 100, 120, 30);
        frame.add(amount);

        button.ClickAction clickAction = new button.ClickAction(amount);
        click.addActionListener(clickAction);

        frame.setVisible(true);
    }
}