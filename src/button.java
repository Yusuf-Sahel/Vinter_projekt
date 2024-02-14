import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class button {

    public static class ClickAction implements ActionListener {
        private JLabel amount;
        private int count;

        public ClickAction(JLabel amount) {
            this.amount = amount;
            this.count = 0;
        }

        @Override
        public void actionPerformed(ActionEvent ev) {
            count++;
            amount.setText("" + count);
        }
    }
}