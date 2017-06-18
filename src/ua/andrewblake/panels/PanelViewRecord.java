package ua.andrewblake.panels;

import ua.andrewblake.settings.GlobalSettings;

import javax.swing.*;

public class PanelViewRecord extends JPanel{

    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JButton buttonBack;

    public PanelViewRecord() {

        this.setSize(800, 600);
        this.setLayout(null);

        scrollPane = new JScrollPane();
        this.add(scrollPane);
        scrollPane.setBounds(10, 30, 770, 480);

        textArea = new JTextArea();
        this.add(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setName("textArea");
        textArea.setFont(new java.awt.Font("Tahoma", 0, 11));
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 100, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        this.setVisible(false);

        GlobalSettings.setPanelViewRecord(this);

    }

    public void showSimpleRecord(String[] simple, String[] createAndEditUsers) {
        textArea.setText("");
        for (String s : simple) {
            textArea.append(s.concat("\n"));
        }
        textArea.append("\n");
        if ((createAndEditUsers != null) && (createAndEditUsers.length > 0)) {
            for (String s : createAndEditUsers) {
                textArea.append(s.concat("\n"));
            }
        }
    }

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelListOfRecordsFromBase().setVisible(true);
    }
}
