package ua.andrewblake.panels;


import ua.andrewblake.interfaces.GetData;
import ua.andrewblake.save.Stat;
import ua.andrewblake.settings.GlobalSettings;

import javax.swing.*;

public class PanelIntroductionError3 extends JPanel implements GetData {

    private JLabel labelAdditionalData;
    private JTextArea textAreaAdditionalData;
    private JScrollPane scrollPaneAdditionalData;
    private JButton buttonBack;
    private JButton buttonPreviousView;

    public PanelIntroductionError3() {

        this.setSize(800, 600);
        this.setLayout(null);

        labelAdditionalData = new JLabel("Додаткові дані:");
        this.add(labelAdditionalData);
        labelAdditionalData.setBounds(10, 10, 90, 15);

        scrollPaneAdditionalData = new JScrollPane();
        this.add(scrollPaneAdditionalData);
        scrollPaneAdditionalData.setBounds(10, 30, 770, 300);

        textAreaAdditionalData = new JTextArea(5, 120);
        this.add(textAreaAdditionalData);
        textAreaAdditionalData.setLineWrap(true);
        textAreaAdditionalData.setWrapStyleWord(true);
        textAreaAdditionalData.setName("textAreaAdditionalData");
        textAreaAdditionalData.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        scrollPaneAdditionalData.setViewportView(textAreaAdditionalData);

        buttonBack = new JButton("Назад");
        this.add(buttonBack);
        buttonBack.setBounds(10, 530, 100, 30);
        buttonBack.setIcon(new ImageIcon("src/ua/andrewblake/resources/Back.png"));
        buttonBack.addActionListener(this::buttonBackActionPerformed);

        buttonPreviousView = new JButton("Перегляд");
        this.add(buttonPreviousView);
        buttonPreviousView.setBounds(690, 530, 100, 30);
        buttonPreviousView.setIcon(new ImageIcon("src/ua/andrewblake/resources/PreviousView.png"));
        buttonPreviousView.addActionListener(this::buttonNextActionPerformed);


        this.setVisible(false);

        GlobalSettings.setPanelIntroductionError3(this);
    }


    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {
        GlobalSettings.getPanelIntroductionError2().setVisible(true);
        this.setVisible(false);
    }

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        GlobalSettings.getPanelPreviousView().setVisible(true);
        Stat stat = getParams(null);
        GlobalSettings.getPanelPreviousView().showSimpleRecord(stat.simpleRecord, stat.createAndEditUsers);
    }

    public void reset() {
        textAreaAdditionalData.setText("");
    }

    @Override
    public boolean canContinue() {
        return true;
    }

    @Override
    public String[] getSimple(String[] simple) {
        return new String[0];
    }

    @Override
    public Stat getParams(Stat stat) {
        stat = ((GetData) GlobalSettings.getPanelIntroductionError2()).getParams(null);
        stat.additionalData = textAreaAdditionalData.getText().trim();
        if (!stat.additionalData.equals("")) {
            String[] temp = new String[stat.simpleRecord.length + 1];
            for (int i = 0; i < stat.simpleRecord.length; i++) {
                temp[i] = stat.simpleRecord[i];
            }
            temp[temp.length - 1] = "Додаткові дані: ".concat(textAreaAdditionalData.getText().trim()).concat(";");
            stat.simpleRecord = temp;
        }
        return stat;
    }

    @Override
    public void fillParams(Stat stat) {
        textAreaAdditionalData.setText(stat.additionalData);
    }
}
