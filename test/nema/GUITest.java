/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nema;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashSet;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class GUITest {
    GUI instance;
    
    public GUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new GUI();
    }
    
    @After
    public void tearDown() {
        instance = null;
        System.gc();
    }

    /**
     * Test of reinitVectors method, of class GUI.
     */
    @Test
    public void testReinitVectors() {
        instance.RadioSCHOOL.setSelected(true);
        instance.reinitVectors();
        assertEquals(instance.CHAR.size(), 4);
        assertEquals(instance.NUM.size(), 4);
        
        instance.RadioCOMBAT.setSelected(true);
        instance.reinitVectors();
        assertEquals(instance.CHAR.size(), 6);
        assertEquals(instance.NUM.size(), 6);
    }

    /**
     * Test of initVectors method, of class GUI.
     */
    @Test
    public void testInitVectors() {
        instance.RadioSCHOOL.setSelected(true);
        instance.initVectors();
        HashSet<Character> CHAR = new HashSet<>();
        CHAR.add('A'); CHAR.add('B'); CHAR.add('C'); CHAR.add('D');
        assertEquals(CHAR.equals(instance.CHAR), true);
        
        instance.RadioSCHOOL.setSelected(true);
        instance.initVectors();
        HashSet<Integer> NUM = new HashSet<>();
        NUM.add(16); NUM.add(19); NUM.add(20); NUM.add(21);
        assertEquals(NUM.equals(instance.NUM), true);
        
        instance.RadioCOMBAT.setSelected(true);
        instance.initVectors();
        CHAR = new HashSet<>();
        CHAR.clear();
        CHAR.add('A'); CHAR.add('B'); CHAR.add('C'); CHAR.add('D'); CHAR.add('E'); CHAR.add('F');
        assertEquals(CHAR.equals(instance.CHAR), true);
        
        instance.RadioCOMBAT.setSelected(true);
        instance.initVectors();
        NUM = new HashSet<>();
        NUM.clear();
        NUM.add(12); NUM.add(13); NUM.add(14); NUM.add(15); NUM.add(17); NUM.add(18);
        assertEquals(NUM.equals(instance.NUM), true);
    }

    /**
     * Test of setCounter method, of class GUI.
     */
    @Test
    public void testSetCounter() {
        int i = 0;
        instance.setCounter(i);
        assertEquals(instance.Counter.getText(), "0000");
        
        i = 100;
        instance.setCounter(i);
        assertEquals(instance.Counter.getText(), "0100");
    }

    /**
     * Test of permutation method, of class GUI.
     */
    @Test
    public void testPermutation() {
        char c = 'A';
        String str = "CHRSDKFHMJ";
        instance.KeyRed.setText("23 / 2");
        instance.setWalzes(19, 16, 20, 21, "B", "C", "A", "D");
        char expResult = 'B';
        char result = instance.permutation(c, str);
        assertEquals(expResult, result);
    }

    /**
     * Test of empty method, of class GUI.
     */
    @Test
    public void testEmpty() {
        JTextField key = null;
        boolean expResult = true;
        boolean result = instance.empty(key);
        assertEquals(expResult, result);
        
        key = new JTextField("");
        expResult = true;
        result = instance.empty(key);
        assertEquals(expResult, result);
        
        key.setText("Any");
        expResult = false;
        result = instance.empty(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of check method, of class GUI.
     */
    @Test
    public void testCheck() {
        boolean expResult = true;
        instance.setWalzes(19, 16, 20, 21, "B", "C", "A", "D");
        instance.KeyRed.setText("23 / 2");
        instance.KeyBox1.setSelectedItem("19");
        instance.KeyBox2.setSelectedItem("B");
        instance.KeyBox3.setSelectedItem("16");
        instance.KeyBox4.setSelectedItem("C");
        instance.KeyBox5.setSelectedItem("20");
        instance.KeyBox6.setSelectedItem("A");
        instance.KeyBox7.setSelectedItem("21");
        instance.KeyBox8.setSelectedItem("D");
        instance.RadioSCHOOL.setSelected(true);
        instance.OuterKey.setText("DISTE LFINK");
        instance.FastOutput.setSelected(true);
        boolean result = instance.check();
        assertEquals(expResult, result);
        
        instance.KeyBox1.setSelectedItem("16");
        expResult = false;
        result = instance.check();
        assertEquals(expResult, result);
        
        instance.KeyBox1.setSelectedItem("19");
        instance.KeyBox2.setSelectedItem("B");
        instance.OuterKey.setText("ABCDE FGHI");
        expResult = false;
        result = instance.check();
        assertEquals(expResult, result);
        
        instance.OuterKey.setText("ABCDE FGHI9");
        expResult = false;
        result = instance.check();
        assertEquals(expResult, result);
        
        instance.KeyBox2.setSelectedItem("C");
        expResult = false;
        result = instance.check();
        assertEquals(expResult, result);
        
        instance.RadioCOMBAT.setSelected(true);
        result = instance.check();
        expResult = false;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setWalzes method, of class GUI.
     */
    @Test
    public void testSetWalzes() {
        int k1 = 19; int k3 = 16; int k5 = 20; int k7 = 99;
        String k2 = "B"; String k4 = "C"; String k6 = "A"; String k8 = "D";
        instance.setWalzes(k1, k3, k5, k7, k2, k4, k6, k8);
        
        assertEquals(instance.KeyBox2.getSelectedItem(), "B");
        assertEquals(instance.KeyBox4.getSelectedItem(), "C");
        assertEquals(instance.KeyBox6.getSelectedItem(), "A");
        assertEquals(instance.KeyBox8.getSelectedItem(), "D");
        
        //if walz out of range, it doesn't change
        instance.setWalzes(k1, k3, k5, k7, k2, k4, k6, "Z");
        assertEquals(instance.KeyBox8.getSelectedItem(), "D");
    }

    /**
     * Test of vorschub method, of class GUI.
     */
    @Test
    public void testVorschub() {
        String s = "DISTELFINK";
        String expResult = "CHRSDKFHMJ";
        instance.setWalzes(19, 16, 20, 21, "B", "C", "A", "D");
        String result = instance.vorschub(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkOuterKey method, of class GUI.
     */
    @Test
    public void testCheckOuterKey() {
        boolean expResult = true;
        instance.OuterKey.setText("ABCDE FGHIJ");
        boolean result = instance.checkOuterKey();
        assertEquals(instance.OuterKey.getBackground(), Color.white);
        assertEquals(expResult, result);
        
        expResult = false;
        instance.OuterKey.setText("ABCDE FGHI2");
        result = instance.checkOuterKey();
        assertEquals(instance.OuterKey.getBackground(), Color.red);
        assertEquals(expResult, result);
        
        expResult = false;
        instance.OuterKey.setText("ABCDE FGHI");
        result = instance.checkOuterKey();
        assertEquals(instance.OuterKey.getBackground(), Color.red);
        assertEquals(expResult, result);
        
        expResult = false;
        instance.OuterKey.setText("ABCDE FGHIJ KLMNO");
        result = instance.checkOuterKey();
        assertEquals(instance.OuterKey.getBackground(), Color.red);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class GUI.
     */
    @Test
    public void testMain() {
        boolean retVal = false;
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            System.out.println("available Look and Feel: " + info.getName());
            if ("Metal".equals(info.getName())) {
                retVal = true;
            }
        }
        assertTrue(retVal);
        
        instance.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        assertTrue(dim.height > 0);
        assertTrue(dim.width > 0);
    }

    /**
     * Test of checkVariability method, of class GUI.
     */
    @Test
    public void testCheckVariability() {
        int k1 = 19; int k3 = 16; int k5 = 20; int k7 = 21;
        char k2 = 'B'; char k4 = 'C'; char k6 = 'A'; char k8 = 'D';
        instance.RadioSCHOOL.setSelected(true);
        boolean expResult = true;
        boolean result = instance.checkVariability(k1, k3, k5, k7, k2, k4, k6, k8);
        assertEquals(expResult, result);
        
        k1 = 16;
        expResult = false;
        result = instance.checkVariability(k1, k3, k5, k7, k2, k4, k6, k8);
        assertEquals(expResult, result);
        
        k1 = 19;
        k2 = 'C';
        expResult = false;
        result = instance.checkVariability(k1, k3, k5, k7, k2, k4, k6, k8);
        assertEquals(expResult, result);
    }

    /**
     * Test of print method, of class GUI.
     */
    @Test
    public void testPrint() {
        instance.RadioSCHOOL.setSelected(true);
        String input = "ESEE";
        String outerkey = "ABCDEFGHIJ";
        int counter = 0;
        instance.setWalzes(16, 19, 20, 21, "A", "B", "C", "D");
        instance.FastOutput.setSelected(true);
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            
            //encrypt input
            outerkey = instance.vorschub(outerkey);
            char d = instance.permutation(ch, outerkey);
            ++counter;

            instance.c.add(counter);
            instance.s.add(outerkey.substring(0, 5) + " " + outerkey.substring(5));
            instance.q.add(d);
        }
        
        instance.print();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        
        assertEquals("TEST", instance.Output.getText().replaceAll(" ", ""));
        assertEquals(instance.Counter.getText(), "0004");
    }
    
    @Test
    public void testA(){
        instance.RadioCOMBAT.setSelected(true);
        String input = "WTQLLGHPGPYLTXLGTMOAQHGHWUSJBLQMABYKLZDKVONXJAIXAI";
        String outerkey = "DISTELFINK";
        int counter = 0;
        instance.setWalzes(13, 15, 14, 12, "C", "B", "A", "D");
        instance.FastOutput.setSelected(true);
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            
            //encrypt input
            outerkey = instance.vorschub(outerkey);
            char d = instance.permutation(ch, outerkey);
            ++counter;
            
            instance.c.add(counter);
            instance.s.add(outerkey.substring(0, 5) + " " + outerkey.substring(5));
            instance.q.add(d);
        }
        
        instance.print();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        
        assertEquals("ICHGR ATULI EREST OPSIE HABEN DIENE MAVER STAND ENSTO PENDE ", instance.Output.getText());
        assertEquals(instance.Counter.getText(), "0050");
    }
    
    @Test
    public void testB(){
        instance.RadioSCHOOL.setSelected(true);
        String input = "YIJVEKKEGDWZBTEIQXOEPXCQTDYUJXIEMMCIEHLWHECVT";
        String outerkey = "DISTELFINK";
        int counter = 0;
        instance.setWalzes(19, 16, 20, 21, "B", "C", "A", "D");
        instance.FastOutput.setSelected(true);
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            
            //encrypt input
            outerkey = instance.vorschub(outerkey);
            char d = instance.permutation(ch, outerkey);
            ++counter;
            
            instance.c.add(counter);
            instance.s.add(outerkey.substring(0, 5) + " " + outerkey.substring(5));
            instance.q.add(d);
        }
        
        instance.print();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        
        assertEquals("GRATU LATIO NKOMM ASIEH ABEND IENEM AVERS TANDE NSTOP ", instance.Output.getText());
        assertEquals(instance.Counter.getText(), "0045");
    }
    
    @Test
    public void testC(){
        instance.RadioSCHOOL.setSelected(true);
        String input = "EXTEREXTER";
        String outerkey = "FELDWEIBEL";
        int counter = 0;
        instance.setWalzes(19, 16, 20, 21, "B", "C", "A", "D");
        instance.FastOutput.setSelected(true);
        String tmp = "";
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            outerkey = instance.vorschub(outerkey);
            tmp += instance.permutation(ch, outerkey);
        }
        outerkey = tmp;
        input = "LXHPNBHWLJYFCDZQESXPPSYNUJVOVXCLYZPLILALYPIKNPRHPHODAZC";
        for(int i=0; i<input.length(); ++i){
            char ch = input.charAt(i);
            
            //encrypt input
            outerkey = instance.vorschub(outerkey);
            char d = instance.permutation(ch, outerkey);
            ++counter;
            
            instance.c.add(counter);
            instance.s.add(outerkey.substring(0, 5) + " " + outerkey.substring(5));
            instance.q.add(d);
        }
        
        instance.print();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        
        assertEquals("BRRRA VOSIE BEHER RSCHE NDIEN EMAYQ PPXPR OZENT IGAUS RUFZE ICHEN ", instance.Output.getText());
        assertEquals(instance.Counter.getText(), "0055");
    }
    
    @Test
    public void testD(){
        instance.RadioCOMBAT.setSelected(true);
        String input = "EXTEREXTER";
        String outerkey = "FELDWEIBEL";
        int counter = 0;
        instance.setWalzes(13, 15, 14, 12, "C", "B", "A", "D");
        instance.FastOutput.setSelected(true);
        String tmp = "";
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            outerkey = instance.vorschub(outerkey);
            tmp += instance.permutation(ch, outerkey);
        }
        outerkey = tmp;
        input = "OABBXYBLZHRRCPXTGOCFPEMRIXCZQYGHRXWUHIYRJOOKJYTUUIWUFDE";
        for(int i=0; i<input.length(); ++i){
            char ch = input.charAt(i);
            
            //encrypt input
            outerkey = instance.vorschub(outerkey);
            char d = instance.permutation(ch, outerkey);
            ++counter;
            
            instance.c.add(counter);
            instance.s.add(outerkey.substring(0, 5) + " " + outerkey.substring(5));
            instance.q.add(d);
        }
        
        instance.print();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        
        assertEquals("BRAAA VOSIE BEHER RSCHE NDIEN EMAYQ PPXPR OZENT IGAUS RUFZE ICHEN ", instance.Output.getText());
        assertEquals(instance.Counter.getText(), "0055");
    }
}