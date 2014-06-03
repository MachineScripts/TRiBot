package scripts.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CookerGui extends JFrame{
    private boolean showGui = true;
    private JButton startButton;
    private JTextField foodNameField, amountTextField;
    private JComboBox locationsBox;
    private Container mainContainer;
    private JLabel title, directions, locationsText, amountPrompt;
    private String[] locationsArray = {"Catherby (Range)", "Rogues Den"};
    private String locationName, foodName;
    private int amountToCook;

    public CookerGui(){
        buildGui();
    }

    private void buildGui(){
        startButton = new JButton("Start");
        foodNameField = new JTextField("Enter the food name here.");
        locationsBox = new JComboBox(locationsArray);
        mainContainer = new Container();
        title = new JLabel("Machine Cooker");
        directions = new JLabel("Enter the food name, and select the location to use.");
        locationsText = new JLabel("Location: ");
        amountPrompt = new JLabel("How many do you want to cook before stopping?");
        amountTextField = new JTextField("Enter amount here.");

        //set overall gui settings (for this)
        this.setSize(500,400);
        this.setTitle("Machine Cooker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupComponents();

        mainContainer.add(startButton);
        mainContainer.add(foodNameField);
        mainContainer.add(locationsBox);
        mainContainer.add(title);
        mainContainer.add(directions);
        mainContainer.add(locationsText);
        mainContainer.add(amountPrompt);
        mainContainer.add(amountTextField);
        this.add(mainContainer);
        this.setVisible(true);
    }

    private void setupComponents(){//setup the size and location of each component for the gui
        mainContainer.setLayout(null);

        startButton.setSize(80, 25);
        startButton.setLocation(405, 335);

        foodNameField.setSize(200, 25);
        foodNameField.setLocation(150, 150);

        locationsBox.setSize(200, 25);
        locationsBox.setLocation(150, 200);

        directions.setSize(350,100);
        directions.setLocation(115,70);

        locationsText.setSize(350,100);
        locationsText.setLocation(90,160);

        amountPrompt.setSize(350, 100);
        amountPrompt.setLocation(115, 200);

        amountTextField.setSize(200, 25);
        amountTextField.setLocation(150, 270);

        title.setSize(350,100);
        title.setLocation(156,2);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 25));

        registerStartButtonActionListener();
    }

    public  void registerStartButtonActionListener(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodName = foodNameField.getText();
                locationName = locationsBox.getSelectedItem().toString();
                amountToCook = Integer.parseInt(amountTextField.getText());
                showGui = false;

            }
        });

    }

    public String getFoodName(){
        return this.foodName;
    }

    public String getLocationName(){
        return this.locationName;
    }

    public boolean isShowGui(){
        return this.showGui;
    }

    public int getAmountToCook(){
        return this.amountToCook;
    }
}
