package scripts.guis;

import javax.swing.*;


public class AgilityGui extends JFrame{
    private JPanel mainPanel;
    private JButton startButton;
    private JLabel title;

    public void buildGui() {
        mainPanel = new JPanel();
        startButton = new JButton("Start");
        title = new JLabel("MachineAgility");

        this.setSize(500,400);
        this.setTitle("MachineWoodCutter");
        mainPanel.setLayout(null);

        mainPanel.add(startButton);
        mainPanel.add(title);
        this.add(mainPanel);
        this.setResizable(false);
    }

}
