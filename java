import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo extends JFrame {
    private JLabel imageLabel;
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup group;
    
    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));

        // Create radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Add radio buttons to button group
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add radio buttons to panel
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Add panel to frame
        add(radioPanel, BorderLayout.WEST);

        // Image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Add action listeners to radio buttons
        birdButton.addActionListener(new RadioButtonListener());
        catButton.addActionListener(new RadioButtonListener());
        dogButton.addActionListener(new RadioButtonListener());
        rabbitButton.addActionListener(new RadioButtonListener());
        pigButton.addActionListener(new RadioButtonListener());

        // Set default selection
        pigButton.setSelected(true);
        updateImage("Pig");

        // Set frame size and visibility
        setSize(300, 300);
        setVisible(true);
    }

    private class RadioButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JRadioButton selectedButton = (JRadioButton) e.getSource();
            updateImage(selectedButton.getText());
        }
    }

    private void updateImage(String pet) {
        // Replace with the appropriate image path for each pet
        String imagePath = "/path/to/" + pet.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        new RadioButtonDemo();
    }
}
