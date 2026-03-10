/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package classes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import classes.UniversalSet;
import classes.BitSet;
import classes.Bag;



/**
 *
 * @author Ahren
 */
public class Project2JUnitTests
{
    
    private final static UniversalSet uni = new UniversalSet( new ArrayList<>( List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")) );;
    
    public Project2JUnitTests()
    {
    }
    
    @BeforeAll
    public static void setUpClass()
    {
       
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    }
    
    @BeforeEach
    public void setUp()
    {
       
    }
    
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testUnionNoOverlapUseAll()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {false,false,false,false,true,true,true,true,true,true}; 
        boolean[] expected = new boolean[10];
        
        for(int i = 0; i<10; i++)
        {
            expected[i] = true;
        }
        
        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.union(set2);
        
        System.out.println("");
        
        assertArrayEquals(expected, result.getBoolBits());
        
    }
    // @Test
    // public void hello() {}
}
