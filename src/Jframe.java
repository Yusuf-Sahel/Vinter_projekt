
import javax.swing.JFrame;
public class Jframe {


    public static class ClickerFrame extends JFrame {
        private static final long serialVersionUID = -4474128135645137881L;

        public ClickerFrame() {
            buildWindow();
        }

        private void buildWindow() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Clicker");
            this.setSize(300, 500);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setLayout(null);
        }
    }
}
