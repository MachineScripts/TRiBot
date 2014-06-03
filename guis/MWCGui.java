//package scripts.guis;
//
//
//import scripts.MachineWoodCutter;
//import scripts.enums.WoodCutterEnum;
//import scripts.guis.events.ChooseWcer;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
//public class MWCGui extends JFrame{
//    private JPanel mainPanel;
//    private JComboBox locationsBox, treeTypeBox;
//    private String[] locations = {"Oaks (Varrock East)", "Oaks (Varrock West)", "Willows (Draynor)", "Maples (Seers)", "Yews (Catherby)", "Yews (Seers)", "Magics (Seers)"},
//    treeTypes = {"Tree", "Oak", "Willow", "Maple", "Yew", "Magic", "Teak"};
//    private JButton startButton;
//    private JLabel directionsLabel, title, powerChoppingLable;
//    private WoodCutterEnum.CutterInfo cutterInfo;
//    private JCheckBox powerChoppingCheckBox;
//    private String powerChopTreeName;
//    private int powerChopDistance;
//    private ChooseWcer chooseWcer = new ChooseWcer();
//
//    public void buildGui(){
//        mainPanel = new JPanel();
//        startButton = new JButton("Start");
//        locationsBox = new JComboBox(locations);
//        powerChoppingCheckBox = new JCheckBox("Power Chop?");
//        directionsLabel = new JLabel("Select a location from the box below then press start");
//        powerChoppingLable = new JLabel("To powerchop, select the tree type and click the checkbox below.");
//        title = new JLabel("MachineWoodCutter");
//        treeTypeBox = new JComboBox(treeTypes);
//        this.setSize(500,400);
//        this.setTitle("MachineWoodCutter");
//        mainPanel.setLayout(null);
//
//        setupComponents();
//        setActionListeners();
//
//        mainPanel.add(locationsBox);
//        mainPanel.add(startButton);
//        mainPanel.add(directionsLabel);
//        mainPanel.add(title);
//        //mainPanel.add(powerChoppingLable);
//        //mainPanel.add(treeTypeBox);
//        //mainPanel.add(powerChoppingCheckBox);
//        this.add(mainPanel);
//        this.setResizable(false);
//    }
//
//    private void setupComponents(){
//
//        treeTypeBox.setSize(200,25);
//        treeTypeBox.setLocation(150, 290);
//        locationsBox.setSize(200, 25);
//        locationsBox.setLocation(150, 200);
//        startButton.setSize(80, 25);
//        startButton.setLocation(405, 335);
//        directionsLabel.setSize(300, 150);
//        directionsLabel.setLocation(100, 90);
//        powerChoppingLable.setSize(400, 100);
//        powerChoppingLable.setLocation(100,210);
//        powerChoppingCheckBox.setSize(20,20);
//        powerChoppingCheckBox.setLocation(120, 290);
//        title.setSize(350,100);
//        title.setLocation(135,2);
//        title.setFont(new Font(directionsLabel.getFont().getName(), Font.PLAIN, 25));
//    }
//
//    public void setActionListeners() {
//        this.startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //to be used later for adding in power chopping
//                if(powerChoppingCheckBox.isSelected()){
//                    powerChopTreeName = treeTypeBox.getSelectedItem().toString();
//                    powerChopDistance = 5;
//                    MachineWoodCutter.powerChop = true;
//                }
//                else{//case statements to decide what area to chop in based on used selection
//                    String choice = locationsBox.getSelectedItem().toString();
//                    System.out.println("Choice is: "+choice);
//                    cutterInfo = chooseWcer.getChoice(choice);
//                }
//                MachineWoodCutter.gui.dispose();
//                MachineWoodCutter.showGui = false;
//            }
//        });
//    }
//
//    public int getPowerChopDistance(){
//        return this.powerChopDistance;
//    }
//
//    public String getPowerChopTreeName(){
//        return this.powerChopTreeName;
//    }
//
//    public WoodCutterEnum.CutterInfo getCutterInfo(){
//        return this.cutterInfo;
//    }
//}
