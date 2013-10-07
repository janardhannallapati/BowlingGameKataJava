/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bowlinggame.test;

import bowlinggame.main.Game;
import org.junit.After;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janardhan
 */
public class BowlingGameTest {
    
    private Game g;
    
    public BowlingGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g=new Game();
    }
    
    @After
    public void tearDown() {
    }

    private void rollMany(int n,int pins)
    {
        for(int i=0;i<n;i++)
             g.roll(pins);
    }
             
     @Test
     public void testGutterGame() throws Exception {
         
         rollMany(20,0);
         assertEquals(0,g.score());
     }
     @Test
     public void testAllOnes() throws Exception{
          rollMany(20,1);
         assertEquals(20,g.score());
     }
     @Test
     public void testOneSpare() throws Exception{
         rollSpare();
         //System.out.println(g.score());
         g.roll(3);
         //System.out.println(g.score());
         rollMany(17,0);
         //System.out.println(g.score());
         assertEquals(16,g.score());
     }
     private void rollSpare(){
         g.roll(5);
         g.roll(5);
     }
     @Test
     public void testOneStrike(){
         g.roll(10);
         g.roll(3);
         g.roll(4);
         rollMany(16,0);
         assertEquals(24,g.score());
     }
     
     @Test
     public void testPerfectGame(){
         rollMany(12,10);
         assertEquals(300,g.score());
     }
}

