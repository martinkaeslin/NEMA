/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nema;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;


/**
 * @version 0.9.1
 * @author Martin
 */
public class GUI extends javax.swing.JFrame{

    /**
     * Creates new form GUI and initializes it.
     */
    public GUI() {
        initComponents();
        icon();
        setCounter(0);
        q = new LinkedList();
        s = new LinkedList();
        c = new LinkedList<>();
        CHAR = new HashSet<>();
        NUM = new HashSet<>();
        RadioSCHOOL.setSelected(true);
        initVectors();
        loadWalzes();
        Language.setSelectedItem("English");
        Language.setSelectedItem("Deutsch");
    }
    
    private void loadWalzes(){
        KeyBox1.removeAllItems();
        KeyBox2.removeAllItems();
        KeyBox3.removeAllItems();
        KeyBox4.removeAllItems();
        KeyBox5.removeAllItems();
        KeyBox6.removeAllItems();
        KeyBox7.removeAllItems();
        KeyBox8.removeAllItems();
        if(RadioSCHOOL.isSelected()){
            KeyBox1.addItem("16"); KeyBox1.addItem("19"); KeyBox1.addItem("20"); KeyBox1.addItem("21");
            KeyBox2.addItem("A"); KeyBox2.addItem("B"); KeyBox2.addItem("C"); KeyBox2.addItem("D");
            KeyBox3.addItem("16"); KeyBox3.addItem("19"); KeyBox3.addItem("20"); KeyBox3.addItem("21");
            KeyBox4.addItem("A"); KeyBox4.addItem("B"); KeyBox4.addItem("C"); KeyBox4.addItem("D");
            KeyBox5.addItem("16"); KeyBox5.addItem("19"); KeyBox5.addItem("20"); KeyBox5.addItem("21");
            KeyBox6.addItem("A"); KeyBox6.addItem("B"); KeyBox6.addItem("C"); KeyBox6.addItem("D");
            KeyBox7.addItem("16"); KeyBox7.addItem("19"); KeyBox7.addItem("20"); KeyBox7.addItem("21");
            KeyBox8.addItem("A"); KeyBox8.addItem("B"); KeyBox8.addItem("C"); KeyBox8.addItem("D");
        }else if(RadioCOMBAT.isSelected()){
            KeyBox1.addItem("12"); KeyBox1.addItem("13"); KeyBox1.addItem("14"); KeyBox1.addItem("15"); KeyBox1.addItem("17"); KeyBox1.addItem("18");
            KeyBox2.addItem("A"); KeyBox2.addItem("B"); KeyBox2.addItem("C"); KeyBox2.addItem("D"); KeyBox2.addItem("E"); KeyBox2.addItem("F");
            KeyBox3.addItem("12"); KeyBox3.addItem("13"); KeyBox3.addItem("14"); KeyBox3.addItem("15"); KeyBox3.addItem("17"); KeyBox3.addItem("18");
            KeyBox4.addItem("A"); KeyBox4.addItem("B"); KeyBox4.addItem("C"); KeyBox4.addItem("D"); KeyBox4.addItem("E"); KeyBox4.addItem("F");
            KeyBox5.addItem("12"); KeyBox5.addItem("13"); KeyBox5.addItem("14"); KeyBox5.addItem("15"); KeyBox5.addItem("17"); KeyBox5.addItem("18");
            KeyBox6.addItem("A"); KeyBox6.addItem("B"); KeyBox6.addItem("C"); KeyBox6.addItem("D"); KeyBox6.addItem("E"); KeyBox6.addItem("F");
            KeyBox7.addItem("12"); KeyBox7.addItem("13"); KeyBox7.addItem("14"); KeyBox7.addItem("15"); KeyBox7.addItem("17"); KeyBox7.addItem("18");
            KeyBox8.addItem("A"); KeyBox8.addItem("B"); KeyBox8.addItem("C"); KeyBox8.addItem("D"); KeyBox8.addItem("E"); KeyBox8.addItem("F");
        }
        else{
            KeyBox1.addItem("Error");
        }
    }
    
    /**
     * Sets icon in the frame.
     */
    private void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("NEMA.png")));
    }
    protected static int counter = 0;
    protected final Queue<Character> q;   //queue ciphered text
    protected final Queue<String> s;      //queue outerkey
    protected final Queue<Integer> c;   //queue counter
    protected final HashSet<Character>  CHAR;   // Kontakt-Walze
    protected final HashSet<Integer>    NUM;    // Fortschalt-Walze
    String fileLoc = "./daten/de_NEMA.pdf";
    
    /**
     * Reinitialize vectors for "Fortschalt-Walze" and "Kontakt-Walze" when modus is changed.
     */
    protected void reinitVectors(){
        CHAR.clear();
        NUM.clear();
        initVectors();
    }
    
    /**
     * Initialize vectors for "Fortschalt-Walze" and "Kontakt-Walze".
     */
    protected final void initVectors(){
        if(RadioSCHOOL.isSelected()){
            CHAR.add('A');
            CHAR.add('B');
            CHAR.add('C');
            CHAR.add('D');
            NUM.add(16);
            NUM.add(19);
            NUM.add(20);
            NUM.add(21);
        }
        else if(RadioCOMBAT.isSelected()){
            CHAR.add('A');
            CHAR.add('B');
            CHAR.add('C');
            CHAR.add('D');
            CHAR.add('E');
            CHAR.add('F');
            NUM.add(12);
            NUM.add(13);
            NUM.add(14);
            NUM.add(15);
            NUM.add(17);
            NUM.add(18);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Modus = new javax.swing.ButtonGroup();
        Title = new javax.swing.JLabel();
        RadioSCHOOL = new javax.swing.JRadioButton();
        RadioCOMBAT = new javax.swing.JRadioButton();
        InnerKeyLabel = new javax.swing.JLabel();
        KeyRed = new javax.swing.JTextField();
        InputLabel = new javax.swing.JLabel();
        OuterKeyLabel = new javax.swing.JLabel();
        OuterKey = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Input = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        cipher = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        OutputLabel = new javax.swing.JLabel();
        FastOutput = new javax.swing.JCheckBox();
        CounterLabel = new javax.swing.JLabel();
        Counter = new javax.swing.JLabel();
        bottom = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        Info = new javax.swing.JButton();
        Language = new javax.swing.JComboBox<>();
        KeyBox1 = new javax.swing.JComboBox<>();
        KeyBox2 = new javax.swing.JComboBox<>();
        KeyBox3 = new javax.swing.JComboBox<>();
        KeyBox4 = new javax.swing.JComboBox<>();
        KeyBox5 = new javax.swing.JComboBox<>();
        KeyBox6 = new javax.swing.JComboBox<>();
        KeyBox7 = new javax.swing.JComboBox<>();
        KeyBox8 = new javax.swing.JComboBox<>();
        UKW = new javax.swing.JTextField();
        clearText = new javax.swing.JButton();
        copyButtonInput = new javax.swing.JButton();
        pasteButtonInput = new javax.swing.JButton();
        copyButtonOutput = new javax.swing.JButton();
        pasteAddButtonInput = new javax.swing.JButton();
        RamdomInnerKeyButton = new javax.swing.JButton();
        RamdomOuterKeyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 525));
        setName("frame"); // NOI18N

        Title.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        Title.setText("NEMA");

        Modus.add(RadioSCHOOL);
        RadioSCHOOL.setText("Schul-Modus");
        RadioSCHOOL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadioSCHOOLItemStateChanged(evt);
            }
        });

        Modus.add(RadioCOMBAT);
        RadioCOMBAT.setText("Kriegs-Modus");
        RadioCOMBAT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadioCOMBATItemStateChanged(evt);
            }
        });

        InnerKeyLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        InnerKeyLabel.setText("Innerer Schlüssel - Walzenstellung");

        KeyRed.setEditable(false);
        KeyRed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        KeyRed.setText("23 / 2");
        KeyRed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 4));
        KeyRed.setMinimumSize(new java.awt.Dimension(50, 25));
        KeyRed.setPreferredSize(new java.awt.Dimension(35, 25));

        InputLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        InputLabel.setText("Eingabe");

        OuterKeyLabel.setText("Äusserer Schlüssel:");

        OuterKey.setToolTipText("");
        OuterKey.setPreferredSize(new java.awt.Dimension(6, 25));
        OuterKey.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OuterKeyFocusLost(evt);
            }
        });

        Input.setColumns(20);
        Input.setRows(5);
        jScrollPane3.setViewportView(Input);

        Output.setEditable(false);
        Output.setColumns(20);
        Output.setRows(5);
        jScrollPane1.setViewportView(Output);

        cipher.setText("verschlüsseln");
        cipher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cipherActionPerformed(evt);
            }
        });

        clear.setText("alles löschen");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        OutputLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OutputLabel.setText("Ausgabe");

        FastOutput.setText("schnelle Ausgabe");

        CounterLabel.setText("Zähler: ");

        Counter.setText("0000");

        bottom.setEditable(false);
        bottom.setBackground(new java.awt.Color(240, 240, 240));
        bottom.setBorder(null);
        bottom.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bottom.setText("Dieses Programm beruht auf:\nSchmid Walter, \"Die Chiffriermaschine NEMA\", 3. überarbeitete und erweiterte Version, 2005\nProgramm umgesetzt von Käslin Martin");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        Info.setText("Infos");
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });

        Language.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deutsch", "English" }));
        Language.setSelectedIndex(0);
        Language.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LanguageItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Language, 0, 84, Short.MAX_VALUE)
                    .addComponent(Info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        KeyBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16" }));
        KeyBox1.setMinimumSize(new java.awt.Dimension(35, 20));
        KeyBox1.setPreferredSize(new java.awt.Dimension(40, 20));

        KeyBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A" }));
        KeyBox2.setMinimumSize(new java.awt.Dimension(38, 20));
        KeyBox2.setPreferredSize(new java.awt.Dimension(38, 20));

        KeyBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16" }));
        KeyBox3.setMinimumSize(new java.awt.Dimension(35, 20));
        KeyBox3.setPreferredSize(new java.awt.Dimension(40, 20));

        KeyBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A" }));
        KeyBox4.setMinimumSize(new java.awt.Dimension(38, 20));
        KeyBox4.setPreferredSize(new java.awt.Dimension(38, 20));

        KeyBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16" }));
        KeyBox5.setMinimumSize(new java.awt.Dimension(35, 20));
        KeyBox5.setPreferredSize(new java.awt.Dimension(40, 20));

        KeyBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A" }));
        KeyBox6.setMinimumSize(new java.awt.Dimension(38, 20));
        KeyBox6.setPreferredSize(new java.awt.Dimension(40, 20));

        KeyBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16" }));
        KeyBox7.setMinimumSize(new java.awt.Dimension(35, 20));
        KeyBox7.setPreferredSize(new java.awt.Dimension(40, 20));

        KeyBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A" }));
        KeyBox8.setMinimumSize(new java.awt.Dimension(38, 20));
        KeyBox8.setPreferredSize(new java.awt.Dimension(38, 20));

        UKW.setEditable(false);
        UKW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UKW.setText("UKW");
        UKW.setToolTipText("");
        UKW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        UKW.setMinimumSize(new java.awt.Dimension(40, 10));
        UKW.setPreferredSize(new java.awt.Dimension(10, 25));

        clearText.setText("Texte löschen");
        clearText.setToolTipText("");
        clearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextActionPerformed(evt);
            }
        });

        copyButtonInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nema/copy.png"))); // NOI18N
        copyButtonInput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copyButtonInput.setMaximumSize(new java.awt.Dimension(30, 30));
        copyButtonInput.setMinimumSize(new java.awt.Dimension(30, 30));
        copyButtonInput.setPreferredSize(new java.awt.Dimension(30, 30));
        copyButtonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonInputActionPerformed(evt);
            }
        });

        pasteButtonInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nema/paste.png"))); // NOI18N
        pasteButtonInput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pasteButtonInput.setMaximumSize(new java.awt.Dimension(30, 30));
        pasteButtonInput.setMinimumSize(new java.awt.Dimension(30, 30));
        pasteButtonInput.setPreferredSize(new java.awt.Dimension(30, 30));
        pasteButtonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteButtonInputActionPerformed(evt);
            }
        });

        copyButtonOutput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nema/copy.png"))); // NOI18N
        copyButtonOutput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copyButtonOutput.setMaximumSize(new java.awt.Dimension(30, 30));
        copyButtonOutput.setMinimumSize(new java.awt.Dimension(30, 30));
        copyButtonOutput.setPreferredSize(new java.awt.Dimension(30, 30));
        copyButtonOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonOutputActionPerformed(evt);
            }
        });

        pasteAddButtonInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nema/pasteAdd.png"))); // NOI18N
        pasteAddButtonInput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pasteAddButtonInput.setMaximumSize(new java.awt.Dimension(30, 30));
        pasteAddButtonInput.setMinimumSize(new java.awt.Dimension(30, 30));
        pasteAddButtonInput.setPreferredSize(new java.awt.Dimension(30, 30));
        pasteAddButtonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteAddButtonInputActionPerformed(evt);
            }
        });

        RamdomInnerKeyButton.setText("zufälliger innerer Schlüssel");
        RamdomInnerKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamdomInnerKeyButtonActionPerformed(evt);
            }
        });

        RamdomOuterKeyButton.setText("zufälliger äusserer Schlüssel");
        RamdomOuterKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamdomOuterKeyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cipher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(bottom, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RadioCOMBAT)
                    .addComponent(RadioSCHOOL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(UKW, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox1, 0, 38, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox3, 0, 38, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox5, 0, 38, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox6, 0, 38, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox7, 0, 38, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(KeyRed, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(InnerKeyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RamdomInnerKeyButton))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pasteAddButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pasteButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(InputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RamdomOuterKeyButton))
            .addGroup(layout.createSequentialGroup()
                .addComponent(OuterKeyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OuterKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OutputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(FastOutput)
                        .addGap(22, 22, 22)
                        .addComponent(CounterLabel)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Counter)
                        .addGap(6, 6, 6))
                    .addComponent(copyButtonOutput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(RadioSCHOOL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RadioCOMBAT))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InnerKeyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RamdomInnerKeyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(KeyRed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(KeyBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KeyBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UKW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(KeyBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KeyBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KeyBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KeyBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KeyBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KeyBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RamdomOuterKeyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OuterKey, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OuterKeyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pasteButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(pasteAddButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(copyButtonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cipher)
                    .addComponent(clear)
                    .addComponent(clearText))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FastOutput)
                    .addComponent(CounterLabel)
                    .addComponent(Counter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(copyButtonOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Performs actions to cipher text from input to output.
     * @param evt ActionEvent.
     */
    private void cipherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cipherActionPerformed
        //clear old output
        Output.setText("");
        //clear old pending output
        if(!c.isEmpty() || !s.isEmpty() || !q.isEmpty()){
            c.clear(); s.clear(); q.isEmpty();
        }
        
        if(!check()){
            if(Language.getSelectedItem().toString().equalsIgnoreCase("Deutsch")){
                Output.setText("Schlüsseleingabe falsch:\n");
            }
            else if(Language.getSelectedItem().toString().equalsIgnoreCase("English")){
                Output.setText("Keyphrase wrong:\n");
            } else {
                Output.setText("Keyphrase wrong:\n");
            }
            return;
        }
        //read new input
        String input = Input.getText().toUpperCase();
        String outerkey = OuterKey.getText().toUpperCase().replaceAll(" ", "");
        
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            
            if(java.util.regex.Pattern.matches("[A-Z]", ch+"")){
                //encrypt input
                outerkey = vorschub(outerkey);
                char d = permutation(ch, outerkey);
                ++counter;
                
                c.add(counter);
                s.add(outerkey.substring(0, 5) + " " + outerkey.substring(5));
                q.add(d);
            }
        }
        
        print();
    }//GEN-LAST:event_cipherActionPerformed

    /**
     * Sets counter in GUI and adds leading zeros.
     * @param i Number to set.
     */
    protected final void setCounter(int i) {
        String str = Integer.toString(i);
        while(str.length()<4){
            str = "0" + str;
        }
        //counter = i;
        Counter.setText(str);
    }
    
    /**
     * Clears all input fields.
     * @param evt ActionEvent.
     */
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        q.clear();
        s.clear();
        c.clear();
        KeyRed.setText("");
        Input.setText("");
        Output.setText("");
        setCounter(0);
        counter = 0;
        OuterKey.setText("");
        RadioCOMBAT.setSelected(true);
        RadioSCHOOL.setSelected(true);
    }//GEN-LAST:event_clearActionPerformed

    /**
     * Sets new values for the red wheel and updates valid input possibilities.
     * @param evt ItemEvent.
     */
    private void RadioSCHOOLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadioSCHOOLItemStateChanged
        KeyRed.setText("23 / 2");
        reinitVectors();
        loadWalzes();
        checkOuterKey();
    }//GEN-LAST:event_RadioSCHOOLItemStateChanged

    /**
     * Sets new values for the red wheel and updates valid input possibilities.
     * @param evt ItemEvent.
     */
    private void RadioCOMBATItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadioCOMBATItemStateChanged
        KeyRed.setText("22 / 1");
        reinitVectors();
        loadWalzes();
        checkOuterKey();
    }//GEN-LAST:event_RadioCOMBATItemStateChanged

    /**
     * Ciphers an letter.
     * @param c Character pressed which represents an button of a keyboard.
     * @param str Outer key (current walz position).
     * @return Ciphered character.
     */
    protected char permutation(char c,String str){
        int d, sum, offset;
        d = T147[c - 'A'];
        
        //right to left
        sum = (d + str.charAt(8)-'A'+26)%26;
        int ch = KeyBox8.getSelectedItem().toString().charAt(0)-'A';
        offset = (T148[ch][sum] - 'A'-sum+26) % 26;
        d = (d+offset) % 26;

        sum = (d + str.charAt(6)-'A'+26)%26;
        ch = KeyBox6.getSelectedItem().toString().charAt(0)-'A';
        offset = (T148[ch][sum] - 'A'-sum+26) % 26;
        d = (d+offset) % 26;

        sum = (d + str.charAt(4)-'A'+26)%26;
        ch = KeyBox4.getSelectedItem().toString().charAt(0)-'A';
        offset = (T148[ch][sum] - 'A'-sum+26) % 26;
        d = (d+offset) % 26;

        sum = (d + str.charAt(2)-'A'+26)%26;
        ch = KeyBox2.getSelectedItem().toString().charAt(0)-'A';
        offset = (T148[ch][sum] - 'A'-sum+26) % 26;
        d = (d+offset) % 26;
        
        //Umkehr-Walz
        sum = (d+str.charAt(0) - 'A') % 26;
        offset = T149[sum];
        d = (d+offset)%26;
        
        //left to right
        sum = (d+str.charAt(2)-'A'+26) % 26;
        ch = KeyBox2.getSelectedItem().toString().charAt(0)-'A';
        offset = (T150[ch][sum]-'A'-sum+26) % 26;
        d = (d+offset) % 26;

        sum = (d+str.charAt(4)-'A'+26) % 26;
        ch = KeyBox4.getSelectedItem().toString().charAt(0)-'A';
        offset = (T150[ch][sum]-'A'-sum+26) % 26;
        d = (d+offset) % 26;

        sum = (d+str.charAt(6)-'A'+26) % 26;
        ch = KeyBox6.getSelectedItem().toString().charAt(0)-'A';
        offset = (T150[ch][sum]-'A'-sum+26) % 26;
        d = (d+offset) % 26;

        sum = (d+str.charAt(8)-'A'+26) % 26;
        ch = KeyBox8.getSelectedItem().toString().charAt(0)-'A';
        offset = (T150[ch][sum]-'A'-sum+26) % 26;
        d = (d+offset) % 26;
        
        return T151[d];
    }

    /**
     * Checks wheter a JTextField is empty.
     * @param key JTextField to be checked for non-zero entry.
     * @return True if key is empty, else false.
     */
    protected boolean empty(JTextField key){
        return key == null || key.getText().isEmpty();
    }

    /**
     * Checks wheter all given input is valid.
     * @return False if outer empty or inner empty is wrong, true if nothing seems wrong.
     */
    protected boolean check(){
        boolean retVal = true;
        if( empty(KeyRed) )
            return false;
        int k1, k3, k5, k7;
        try{
            k1 = new Integer(KeyBox1.getSelectedItem().toString());
            k3 = new Integer(KeyBox3.getSelectedItem().toString());
            k5 = new Integer(KeyBox5.getSelectedItem().toString());
            k7 = new Integer(KeyBox7.getSelectedItem().toString());
        }catch(NumberFormatException ignore){
            Output.setText("Not able to read the number of Fortschalt-Walz.");
            return false;
        }
        char k2 = KeyBox2.getSelectedItem().toString().charAt(0);
        char k4 = KeyBox4.getSelectedItem().toString().charAt(0);
        char k6 = KeyBox6.getSelectedItem().toString().charAt(0);
        char k8 = KeyBox8.getSelectedItem().toString().charAt(0);
        
        retVal = retVal && checkVariability(k1,k3,k5,k7,k2,k4,k6,k8);
        
        retVal = retVal && checkOuterKey();
        
        //setWalzes(k1, k3, k5, k7, k2, k4, k6, k8);
        return retVal;
    }

    /**
     * Set values from walzes to internal states.
     * @param k1 Key 1 representing walz 1 (first choosable walze from left side)
     * @param k3 Key 3 representing walz 3
     * @param k5 Key 5
     * @param k7 Key 7
     * @param k2 Key 2
     * @param k4 Key 4
     * @param k6 Key 6
     * @param k8 Key 8 representing walz 8 (first choosable walze from right side)
     */
    protected void setWalzes(int k1, int k3, int k5, int k7, String k2, String k4, String k6, String k8) {
        KeyBox1.setSelectedItem(k1 + "");
        KeyBox3.setSelectedItem(k3 + "");
        KeyBox5.setSelectedItem(k5 + "");
        KeyBox7.setSelectedItem(k7 + "");
        KeyBox2.setSelectedItem(k2);
        KeyBox4.setSelectedItem(k4);
        KeyBox6.setSelectedItem(k6);
        KeyBox8.setSelectedItem(k8);
    }
    
    /**
     * Revolves the walzes.
     * @param s Outer key (current walz position).
     * @return New walz position (new outer key).
     */
    protected String vorschub(String s){
        boolean[] push = new boolean[] {false,false,false,false,false,false,false,false,false,false};

        push[1] = push[5] = push[9] = true;
        push[3] = push[7] = T146[new Integer(KeyRed.getText().substring(5))][(s.charAt(9)-'A'+17)%26] == 1;
        push[0] = (T146[new Integer(KeyBox1.getSelectedItem().toString())][(s.charAt(1) - 'A' + 16) % 26] == 1) && (push[1] == true);
        push[2] = (T146[new Integer(KeyBox3.getSelectedItem().toString())][(s.charAt(3) - 'A' + 16) % 26] == 1) && (push[3] == true);
        push[4] = (T146[new Integer(KeyBox5.getSelectedItem().toString())][(s.charAt(5) - 'A' + 16) % 26] == 1) && (push[5] == true);
        push[6] = (T146[new Integer(KeyBox7.getSelectedItem().toString())][(s.charAt(7) - 'A' + 16) % 26] == 1) && (push[7] == true);
        
        push[8] = (T146[new Integer(KeyRed.getText().substring(0, 2))][(s.charAt(9) - 'A' + 16) % 26] == 1) && (push[9] == true);
        
        String tmp="";
        for(int i=0; i<10; ++i){
            if(push[i]){
                char ch = (char) ((((int) s.charAt(i))-'A'-1+26)%26 + 'A');
                tmp += ch;
            }
            else{
                tmp += s.charAt(i);
            }
        }
        return tmp;
    }
    
    private void OuterKeyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OuterKeyFocusLost
        checkOuterKey();
    }//GEN-LAST:event_OuterKeyFocusLost

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        File file = new File(fileLoc);
        //Output.setText(System.getProperty("user.dir"));
        if(file.exists() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)){
            try{
                Desktop.getDesktop().open(file);
            } catch (IOException ignore) {
                //Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String message, title;
            if(Language.getSelectedItem().toString().equalsIgnoreCase("Deutsch")){
                message = "Die Infodatei konnte nicht gefunden werden!";
                title = "Öffnen fehlgeschlagen";
            } else {
                message = "Could not find the requested info file!";
                title = "Failed to open";
            }

            JOptionPane.showMessageDialog(null,
                message,
                title,
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_InfoActionPerformed

    private void LanguageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LanguageItemStateChanged
        if(Language.getSelectedItem().toString().equalsIgnoreCase("Deutsch")){
            Title.setText("NEMA");
            RadioCOMBAT.setText("Kriegs-Modus");
            RadioSCHOOL.setText("Schul-Modus");
            Info.setText("Infos");
            InnerKeyLabel.setText("Innerer Schlüssel - Walzenstellung");
            InputLabel.setText("Eingabe");
            OuterKeyLabel.setText("Äusserer Schlüssel: ");
            cipher.setText("verschlüsseln");
            clear.setText("alles löschen");
            OutputLabel.setText("Ausgabe");
            FastOutput.setText("schnelle Ausgabe");
            CounterLabel.setText("Zähler: ");
            bottom.setText("Dieses Programm beruht auf:\nSchmid Walter, \"Die Chiffriermaschine NEMA\", 3. überarbeitete und erweiterte Version, 2005\nProgramm umgesetzt von Käslin Martin");
            UKW.setToolTipText("<html>UKW = Umkehr-Walze<br>\nWird auch Reflektor genannt.");
            clearText.setText("Texte löschen");
            clearText.setToolTipText("<html>Lösche:<br>- äusserer Schlüssel<br>- Eingabe<br>- Ausgabe");
            OuterKey.setToolTipText("<html>10 Buchstaben<br>Leerzeichen werden ignoriert");
            copyButtonInput.setToolTipText("<html>Kopiere die Eingabe in die Zwischenablage.<br>Entspricht: <i>Ctrl</i> + <i>C</i>");
            copyButtonOutput.setToolTipText("<html>Kopiere die Ausgabe in die Zwischenablage.<br>Entspricht: <i>Ctrl</i> + <i>C</i>");
            pasteButtonInput.setToolTipText("<html>Einfügen: Ersetze die vorhandenen Eingabe mit dem Inhalt aus der Zwischenablage.");
            pasteAddButtonInput.setToolTipText("<html>Einfügen: Hänge den Inhalt aus der Zwischenablage an die vorhandenen Eingabe an.<br>Entspricht: <i>Ctrl</i> + <i>V</i> mit gesetztem Kursor am Textende.");
            RamdomInnerKeyButton.setText("zufälliger innerer Schlüssel");
            RamdomOuterKeyButton.setText("zufälliger äusserer Schlüssel");
            fileLoc = "./daten/de_NEMA.pdf";
        }
        else if(Language.getSelectedItem().toString().equalsIgnoreCase("English")){
            Title.setText("NEMA");
            RadioCOMBAT.setText("combat mode");
            RadioSCHOOL.setText("school mode");
            Info.setText("info");
            InnerKeyLabel.setText("Inner key - rotor position");
            InputLabel.setText("Input");
            OuterKeyLabel.setText("Outer key: ");
            cipher.setText("cipher");
            clear.setText("clear all");
            OutputLabel.setText("Output");
            FastOutput.setText("fast output");
            CounterLabel.setText("counter: ");
            bottom.setText("This program is based on:\nSchmid Walter, \"Die Chiffriermaschine NEMA\", 3rd revised and extended version, 2005\nProgram written by Käslin Martin");
            UKW.setToolTipText("<html>UKW = Umkehr-Walze<br>\nReturn-walz, is also called reflektor.");
            clearText.setText("clear text only");
            clearText.setToolTipText("<html>Clear:<br>- outer key<br>- input<br>- output");
            OuterKey.setToolTipText("<html>10 characters<br>ignores spaces");
            copyButtonInput.setToolTipText("<html>Copy the input into the clipboard.<br>Equivalent to: <i>Ctrl</i> + <i>C</i>");
            copyButtonOutput.setToolTipText("<html>Copy the output into the clipboard.<br>Equivalent to: <i>Ctrl</i> + <i>C</i>");
            pasteButtonInput.setToolTipText("<html>Insert: Replace the present input with the content from the clipboard.");
            pasteAddButtonInput.setToolTipText("<html>Insert: Append the content from the clipboard to the present text.<br>Entspricht: <i>Ctrl</i> + <i>V</i> with cursor placed at the end of the text.");
            RamdomInnerKeyButton.setText("random inner key");
            RamdomOuterKeyButton.setText("random outer key");
            fileLoc = "./daten/en_NEMA.pdf";
        }
        else {
            Language.setSelectedIndex(0);
        }
    }//GEN-LAST:event_LanguageItemStateChanged

    private void clearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTextActionPerformed
        OuterKey.setText("");
        Input.setText("");
        Output.setText("");
    }//GEN-LAST:event_clearTextActionPerformed
    
    /*
    StringSelection stringSelection = new StringSelection (Input.getText());
    Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
    clpbrd.setContents (stringSelection, null);
    */
    private void pasteButtonInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteButtonInputActionPerformed
        try {
            String str = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor);
            Input.setText(str);
        } catch (UnsupportedFlavorException | IOException ignore) {
            //Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pasteButtonInputActionPerformed

    private void copyButtonInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonInputActionPerformed
        StringSelection stringSelection = new StringSelection (Input.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
    }//GEN-LAST:event_copyButtonInputActionPerformed

    private void copyButtonOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonOutputActionPerformed
        StringSelection stringSelection = new StringSelection (Output.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
    }//GEN-LAST:event_copyButtonOutputActionPerformed

    private void pasteAddButtonInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteAddButtonInputActionPerformed
        try {
            String str = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor);
            Input.append(str);
        } catch (UnsupportedFlavorException | IOException ignore) {
            //Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pasteAddButtonInputActionPerformed

    private void RamdomInnerKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamdomInnerKeyButtonActionPerformed
        ArrayList<Character> ch = new ArrayList<>();
        CHAR.forEach((item) -> { ch.add(item); });
        ArrayList<Integer> n = new ArrayList<>();
        NUM.forEach((item) -> { n.add(item); });
        Collections.shuffle(ch);
        Collections.shuffle(n);
        KeyBox1.setSelectedItem(n.get(0)+"");
        KeyBox3.setSelectedItem(n.get(1)+"");
        KeyBox5.setSelectedItem(n.get(2)+"");
        KeyBox7.setSelectedItem(n.get(3)+"");
        KeyBox2.setSelectedItem(ch.get(0)+"");
        KeyBox4.setSelectedItem(ch.get(1)+"");
        KeyBox6.setSelectedItem(ch.get(2)+"");
        KeyBox8.setSelectedItem(ch.get(3)+"");
    }//GEN-LAST:event_RamdomInnerKeyButtonActionPerformed

    private void RamdomOuterKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamdomOuterKeyButtonActionPerformed
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] scram = str.split("");
        List<String> letters = Arrays.asList(scram);
        Collections.shuffle(letters);
        StringBuilder sb = new StringBuilder(str.length());
        letters.forEach((ch) -> { sb.append(ch); });
        OuterKey.setText(sb.toString().substring(0, 10));
        checkOuterKey();
    }//GEN-LAST:event_RamdomOuterKeyButtonActionPerformed

    /**
     * Checks outer key to be alphabetic and of length 10.<br>
     * Ignores whitespaces as input.<br>
     * Forms outer key to groups of 5 characters seperated by a whitespace.<p>
     * If outer key is wrong, set background colour to red.<br>
     * If outer key is right, set background colour to white.<br>
     * @return True if and only if outer key has length 10 and outer key is alphabetic, else false.
     */
    protected boolean checkOuterKey(){
        boolean retVal = false;
        String str = OuterKey.getText().toUpperCase().replaceAll(" ", "");
        boolean b = str.matches("[A-Z]{"+str.length()+"}");
        if( (str.length() != 10) || (! b) ){
            OuterKey.setBackground(Color.red);
        }
        else{
            OuterKey.setBackground(Color.white);
            retVal = true;
        }
        String tmp = "";
        //insert space all 5 chars
        for(int i=0; i<str.length(); i+=5){
            int j = str.length() > i+5 ? i+5 : str.length();
            tmp += str.substring(i, j) + (str.length()!=j ? " " : "");
        }
        OuterKey.setText(tmp);
        
        return retVal;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Metal look and feel */
        /* If Metal (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /* Possible look and feels
                 *               Metal
                 *               Nimbus
                 *               CDE/Motif
                 *               Windows
                 *               Windows Classic
                */                
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ignore) {
            //java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.pack();
            //gui.setLocationRelativeTo(null);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            gui.setLocation(dim.width/2 - gui.getSize().width/2, 10);
            gui.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel Counter;
    private javax.swing.JLabel CounterLabel;
    protected javax.swing.JCheckBox FastOutput;
    private javax.swing.JButton Info;
    private javax.swing.JLabel InnerKeyLabel;
    public javax.swing.JTextArea Input;
    private javax.swing.JLabel InputLabel;
    public javax.swing.JComboBox<String> KeyBox1;
    public javax.swing.JComboBox<String> KeyBox2;
    public javax.swing.JComboBox<String> KeyBox3;
    public javax.swing.JComboBox<String> KeyBox4;
    public javax.swing.JComboBox<String> KeyBox5;
    public javax.swing.JComboBox<String> KeyBox6;
    public javax.swing.JComboBox<String> KeyBox7;
    public javax.swing.JComboBox<String> KeyBox8;
    protected javax.swing.JTextField KeyRed;
    private javax.swing.JComboBox<String> Language;
    private javax.swing.ButtonGroup Modus;
    protected javax.swing.JTextField OuterKey;
    private javax.swing.JLabel OuterKeyLabel;
    public javax.swing.JTextArea Output;
    private javax.swing.JLabel OutputLabel;
    protected javax.swing.JRadioButton RadioCOMBAT;
    protected javax.swing.JRadioButton RadioSCHOOL;
    private javax.swing.JButton RamdomInnerKeyButton;
    private javax.swing.JButton RamdomOuterKeyButton;
    private javax.swing.JLabel Title;
    protected javax.swing.JTextField UKW;
    private javax.swing.JTextPane bottom;
    private javax.swing.JButton cipher;
    private javax.swing.JButton clear;
    private javax.swing.JButton clearText;
    private javax.swing.JButton copyButtonInput;
    private javax.swing.JButton copyButtonOutput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton pasteAddButtonInput;
    private javax.swing.JButton pasteButtonInput;
    // End of variables declaration//GEN-END:variables
    
    /**
     * T146[#Fortschalt-Walz updated][char]<br>
     * First dim is 24 (representig walz 0-23.<br>
     * Second dim is 26 (representig the alphabet).
     */
    private static final int T146[][] = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 0 (arrays are zero-based)
        {0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1},  // Walze 1
        {0,1,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},  // Walze 2
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 3
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 4
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 5
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 6
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 7
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 8
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 9
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 10
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Walze 11
        {0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,1,1},  // Walze 12
        {1,1,0,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,0},  // Walze 13
        {0,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,0,1,0,1,0,1},  // Walze 14
        {1,0,0,1,1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1},  // Walze 15
        {1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0},  // Walze 16
        {0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,0,1,0,1,1,0,1,1,0},  // Walze 17
        {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1},  // Walze 18
        {1,1,1,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},  // Walze 19
        {1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1,1,1},  // Walze 20
        {1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,0,1,0,0,1,0,0},  // Walze 21
        {1,1,0,0,1,0,1,1,0,0,1,0,1,1,0,1,1,1,1,0,0,1,1,1,0,0},  // Walze 22
        {1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0}   // Walze 23
    };
    
    /**
     * Anschlussplatte "hin"<br>
     * Dimension is 26 (representig the alphabet).
     */
    private static final int T147[]={14,1,3,12,22,11,10,9,17,8,7,6,25,0,16,15,24,21,13,20,18,2,23,4,5,19};
    
    /**
     * Kontakt rechts führt zu Kontakt links "hin"<br>
     * int = (T148[i][j]-j+26)%26<br>
     * First dim is 6 (representig walz 'A' to 'F'.<br>
     * Second dim is 26 (representig the alphabet).
     */
    private static final char T148[][]={
        {'N','S','K','I','T','C','O','Y','M','V','W','A','U','J','D','R','L','Z','X','H','F','Q','E','G','P','B'},  // Walze A
        {'K','J','Y','N','T','M','E','H','L','O','Z','Q','B','W','P','S','X','I','R','F','A','G','U','D','V','C'},  // Walze B
        {'P','N','F','U','T','E','D','I','Z','Y','A','H','V','R','W','O','J','S','G','B','Q','M','K','C','X','L'},  // Walze C
        {'W','J','B','E','Y','F','U','C','M','D','T','A','Z','K','X','P','I','Q','H','S','V','L','G','O','N','R'},  // Walze D
        {'H','R','Q','T','Y','V','X','M','N','A','C','F','U','J','E','S','W','L','Z','I','G','D','P','O','K','B'},  // Walze E
        {'Z','V','G','E','Q','M','U','T','W','L','N','S','H','P','O','A','F','Y','I','X','K','B','D','R','J','C'}   // Walze F
    };
    
    /**
     * Umkehrwalze<br>
     * int = (T149[i]-i+26)%26<br>
     * Dimension is 26 (representig the alphabet).
     */
    private static final char T149[]={10,21,13,10,2,2,24,24,13,10,16,14,8,16,10,13,7,1,25,16,18,13,5,19,16,12};    // Umkehrwalze

    /**
     * Kontakt links führt zu Kontakt rechts "retour"<br>
     * int = (T150[i][j]-j+26)%26<br>
     * First dim is 6 (representig walz 'A' to 'F'.<br>
     * Second dim is 26 (representig the alphabet).
     */
    private static final char T150[][]={
        {'L','Z','F','O','W','U','X','T','D','N','C','Q','I','A','G','Y','V','P','B','E','M','J','K','S','H','R'},  // Walze A
        {'U','M','Z','X','G','T','V','H','R','B','A','I','F','D','J','O','L','S','P','E','W','Y','N','Q','C','K'},  // Walze B
        {'K','T','X','G','F','C','S','L','H','Q','W','Z','V','B','P','A','U','N','R','E','D','M','O','Y','J','I'},  // Walze C
        {'L','C','H','J','D','F','W','S','Q','B','N','V','I','Y','X','P','R','Z','T','K','G','U','A','O','E','M'},  // Walze D
        {'J','Z','K','V','O','L','U','A','T','N','Y','R','H','I','X','W','C','B','P','D','M','F','Q','G','E','S'},  // Walze E
        {'P','V','Z','W','D','Q','C','M','S','Y','U','J','F','K','O','N','E','X','L','H','G','B','I','T','R','A'},  // Walze F
    };
    
    /**
     * Anschlussplatte "retour"<br>
     * Dimension is 26 (representig the alphabet).
     */
    private static final char T151[]={'N','B','V','C','X','Y','L','K','J','H','G','F','D','S','A','P','O','I','U','Z','T','R','E','W','Q','M'};

    /**
     * Check wheter enough different entries for Kontakt-Walze and Fortschaltwalze are given.
     * @param k1 Fortschalt-Walze
     * @param k3 Fortschalt-Walze
     * @param k5 Fortschalt-Walze
     * @param k7 Fortschalt-Walze
     * @param k2 Kontakt-Walze
     * @param k4 Kontakt-Walze
     * @param k6 Kontakt-Walze
     * @param k8 Kontakt-Walze
     * @return True if has 4 different Kontakt-Walze and 4 different Fortschalt-Walze.
     */
    protected boolean checkVariability(int k1, int k3, int k5, int k7, char k2, char k4, char k6, char k8) {
        boolean retVal = true;
        HashSet<Integer> nums = new HashSet<>();
        nums.add(k1); nums.add(k3); nums.add(k5); nums.add(k7);
        if(nums.size()!=4){
            if(Language.getSelectedItem().toString().equalsIgnoreCase("Deutsch")){
                Output.append("Nicht genug verschiedene Fortschalt-Walzen. (Benutzt: " + nums.size() + " /4 - Eventuell mehrmals gleiche Nummer.)");
            }
            else if(Language.getSelectedItem().toString().equalsIgnoreCase("English")){
                Output.append("Not enough different Fortschalt-Walzes. (Using: " + nums.size() + " /4 - possibly same number multiple times.)");
            } else {
                Output.append("Not enough different Fortschalt-Walzes. (Using: " + nums.size() + " /4 - possibly same number multiple times.)");
            }
            retVal = false;
        }

        HashSet<Character> chars = new HashSet<>();
        chars.add(k2); chars.add(k4); chars.add(k6); chars.add(k8);
        if(chars.size()!=4){
            if(Language.getSelectedItem().toString().equalsIgnoreCase("Deutsch")){
                Output.append("Nicht genügend verschiedene Walzen. (Benutzt: " + chars.size() + "/4 - Eventuell den selben Buchstaben mehrmals benutzt.)");
            }
            else if(Language.getSelectedItem().toString().equalsIgnoreCase("English")){
                Output.append("Not enough different Kontakt-Walzes. (Using: " + chars.size() + "/4 - Possibly same letter multiple times.)");
            } else {
                Output.append("Not enough different Kontakt-Walzes. (Using: " + chars.size() + "/4 - Possibly same letter multiple times.)");
            }
            retVal = false;
        }
        return retVal;
    }

    /**
     * Prints ciphered text to Output 1 character per second or 1 character per millisecond (fast output).
     */
    protected void print(){
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>(){
            @Override
            protected Void doInBackground(){
                while(!q.isEmpty() && !s.isEmpty() && !c.isEmpty()){
                    String cipher = q.poll() + "";
                    this.publish(s.poll(), cipher, c.poll().toString());
                    int delay = FastOutput.isSelected() ? 1 : 1000;
                    String message, title;
                    if(Language.getSelectedItem().toString().equalsIgnoreCase("Deutsch")){
                        message = "Es geschah ein Fehler während der Pause zwischen der Wiedergabe der einzelnen Schritte!";
                        title = "Pausieren fehlgeschlagen";
                    }
                    else if(Language.getSelectedItem().toString().equalsIgnoreCase("English")){
                        message = "There was an error inbetween the break and the printing of the single steps!";
                        title = "Error while pausing";
                    } else {
                        message = "There was an error inbetween the break and the printing of the single steps!";
                        title = "Error while pausing";
                    }
                    try{
                        Thread.sleep(delay);
                    }catch(InterruptedException e){
                        JOptionPane.showMessageDialog(null,
                            message,
                            title,
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                while(chunks.size()>=3){
                    String outer = chunks.remove(0);
                    String cipher = chunks.remove(0);
                    int count = new Integer(chunks.remove(0));
                    if(count>0 && count%5==0){
                        cipher += " ";
                    }

                    OuterKey.setText(outer);
                    Output.append(cipher);
                    setCounter(count);
                }
            }
        };
        worker.execute();
    }
}
