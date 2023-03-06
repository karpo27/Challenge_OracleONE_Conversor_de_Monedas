// Java Modules:
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class UnitConverter extends JFrame{
    static final int WIDTH = 512;
    static final int HEIGHT = 264;
    static final Image ICON = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/logo16.png"))).getImage();
    static final ImageIcon BG_IMAGE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            UnitConverter.class.getResource("/assets/background_alura.png")));
    final Rectangle PANEL_1_POS = new Rectangle(WIDTH/2 - 80, 41, 133, 33);
    final Rectangle PANEL_2_POS = new Rectangle(WIDTH/2 - 80, 74, 133, 33);
    final Rectangle PANEL_3_POS = new Rectangle(WIDTH/2 - 80, 107, 133, 27);
    final Rectangle LABEL_1_POS = new Rectangle(WIDTH/2 - 118, 41, 133, 33);
    final Rectangle LABEL_2_POS = new Rectangle(WIDTH/2 - 104, 74, 133, 33);
    final Rectangle LABEL_3_POS = new Rectangle(WIDTH/2 - 152, 107, 133, 33);

    // Panel 1: Currency, Length, Temperature:
    final LinkedList<String> CURRENCY_OPTIONS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen", "Won"));

    // Panel 2 - Currencies:
    final LinkedList<String> ARGENTINE = new LinkedList<>(Arrays.asList("-Select an Option-", "Dollar", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> DOLLAR = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Euro", "Pounds", "Yen", "Won"));
    final LinkedList<String> EURO = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Pounds", "Yen", "Won"));
    final LinkedList<String> POUNDS = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Yen", "Won"));
    final LinkedList<String> YEN = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Won"));
    final LinkedList<String> WON = new LinkedList<>(Arrays.asList("-Select an Option-", "Argentine Peso", "Dollar", "Euro", "Pounds", "Yen"));


    public UnitConverter() {
        // Create Main Screen:
        setTitle("Alura Currency Converter");
        setIconImage(ICON);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Label and Load Background Image:
        JLabel bgImage = new JLabel(BG_IMAGE);
        add(bgImage);

        // Panel 1 - Create Currency Panel:
        JPanelCreator currencyPanel = new JPanelCreator(PANEL_1_POS, CURRENCY_OPTIONS, true);

        // Panel 2 - Create Currency2 Panel:
        JPanelCreator currencyPanel2 = new JPanelCreator(PANEL_2_POS, CURRENCY_OPTIONS, false);

        // Panel 2 - Create Currencies Panels:
        JPanelCreator argentinePanel = new JPanelCreator(PANEL_2_POS, ARGENTINE, false);
        JPanelCreator dollarPanel = new JPanelCreator(PANEL_2_POS, DOLLAR, false);
        JPanelCreator euroPanel = new JPanelCreator(PANEL_2_POS, EURO, false);
        JPanelCreator poundsPanel = new JPanelCreator(PANEL_2_POS, POUNDS, false);
        JPanelCreator yenPanel = new JPanelCreator(PANEL_2_POS, YEN, false);
        JPanelCreator wonPanel = new JPanelCreator(PANEL_2_POS, WON, false);

        // Panel 3 - Create In Text Field:
        JTextFieldCreator inValue = new JTextFieldCreator(PANEL_3_POS, false);

        // Label 1 - Create "From" Label:
        JLabelCreator from = new JLabelCreator(LABEL_1_POS, "From", true, 12);

        // Label 2 - Create "To" Label:
        JLabelCreator to = new JLabelCreator(LABEL_2_POS, "To", false, 12);

        // Label 3 - Create "To" Label:
        JLabelCreator insertValue = new JLabelCreator(LABEL_3_POS, "Insert Value", false, 12);

        // Add Category Panels to Background Label:
            // Panel 1 - Currency Panel:
        bgImage.add(currencyPanel);
            // Panel 2 - Currency2 Panel:
        bgImage.add(currencyPanel2);
            // Panel 2 - Currencies Panels:
        bgImage.add(argentinePanel);
        bgImage.add(dollarPanel);
        bgImage.add(euroPanel);
        bgImage.add(poundsPanel);
        bgImage.add(yenPanel);
        bgImage.add(wonPanel);
            // Panel 3 - In Text Field:
        bgImage.add(inValue);

        // Add Labels to Background Label:
        bgImage.add(from);
        bgImage.add(to);
        bgImage.add(insertValue);

        //Add ActionListener to Currency Options JComboBox:
            // Add Currencies Panels to List:
        LinkedList<JPanelCreator> currencyList = new LinkedList<>();
        currencyList.add(currencyPanel2);
        currencyList.add(argentinePanel);
        currencyList.add(dollarPanel);
        currencyList.add(euroPanel);
        currencyList.add(poundsPanel);
        currencyList.add(yenPanel);
        currencyList.add(wonPanel);

        // Add Labels "From", "To, to Label List:
        LinkedList<JLabelCreator> labelList = new LinkedList<>();
        labelList.add(from);
        labelList.add(to);
        labelList.add(insertValue);

        currencyPanel.options.addActionListener(e -> {
            String selectedOption = (String) currencyPanel.options.getSelectedItem();

            // Show/Hide relevant Panel/Label based on selected option:
            switch (Objects.requireNonNull(selectedOption)) {
                case "-Select an Option-" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, false, false}, new boolean[] {true, false, false});
                case "Argentine Peso" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, true, false, false, false, false, false}, new boolean[] {true, true, false});
                case "Dollar" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, true, false, false, false, false}, new boolean[] {true, true, false});
                case "Euro" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, true, false, false, false}, new boolean[] {true, true, false});
                case "Pounds" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, true, false, false}, new boolean[] {true, true, false});
                case "Yen" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, true, false}, new boolean[] {true, true, false});
                case "Won" -> setPanelVisibility(currencyList, labelList, new boolean[] {false, false, false, false, false, false, true}, new boolean[] {true, true, false});
            }
        });

        //Add ActionListener to In Value Text Field:
            // Add In Value to List:
        LinkedList<JTextFieldCreator> inValueList = new LinkedList<>();
        inValueList.add(inValue);

        // Make Main Screen Visible:
        setVisible(true);
    }

    public static void setPanelVisibility(LinkedList<JPanelCreator> panel, LinkedList<JLabelCreator> label, boolean[] panelVisibility, boolean[] labelVisibility) {
        for (int i = 0; i < panel.size(); i++){
            panel.get(i).setVisible(panelVisibility[i]);
        }
        for (int j = 0; j < label.size(); j++){
            label.get(j).setVisible(labelVisibility[j]);
        }
    }

    public static void main(String[] args) {
        new UnitConverter();
    }
}


/*
        for (JPanelCreator panel : currencyList){
            if (panel.getName().equals("currencyPanel2")){
                System.out.println("hola");
                inValue.setVisible(false);
                insertValue.setVisible(false);
            } else {
                panel.options.addActionListener(e -> {
                    inValue.setVisible(true);
                    insertValue.setVisible(true);
                });
            }
        }

         */