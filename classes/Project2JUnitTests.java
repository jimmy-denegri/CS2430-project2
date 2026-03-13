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
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import classes.UniversalSet;
import classes.BitSet;
import classes.Bag;
import java.util.HashMap;
import java.util.Map;



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
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 0 0 0 0 1 1 1 1 1 1 2nd
        // 1 1 1 1 1 1 1 1 1 1 expected
        
        for(int i = 0; i<10; i++)
        {
            expected[i] = true;
        }
        
        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.union(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());      
    }
    
    @Test 
    public void testUnionOverlap()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {false,false,true,true,true,true,false,false,false,false}; 
        boolean[] expected = {true,true,true,true,true,true,false,false,false,false};
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 0 0 1 1 1 1 0 0 0 0 2nd
        // 1 1 1 1 1 1 0 0 0 0 expected

        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.union(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
    }
    
    @Test
    public void testNot()
    {
        boolean[] set = {true,true,true,true,false,false,false,false,false,false};
        
        boolean[] expected = {false,false,false,false,true,true,true,true,true,true,};
        
        // 1 1 1 1 0 0 0 0 0 0 in
        // 0 0 0 0 1 1 1 1 1 1 expected
        
        
        BitSet set1 = new BitSet(uni, set); 
        
        BitSet result = set1.complement();
        
        System.out.printf("Set: %s\nExpected: %s\nResult: %s\n", set1.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
    }
    
    @Test
    public void testIntersectionNoOverlap()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {false,false,false,false,true,true,false,false,false,false}; 
        boolean[] expected = {false,false,false,false,false,false,false,false,false,false};
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 0 0 0 0 1 1 0 0 0 0 2nd
        // 0 0 0 0 0 0 0 0 0 0 expected (no overlap)

        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.intersection(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
        
    }
    
    @Test
    public void testIntersectionWithOverlap()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {false,true,true,false,true,true,false,false,false,false}; 
        boolean[] expected = {false,true,true,false,false,false,false,false,false,false};
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 0 1 1 0 1 1 0 0 0 0 2nd
        // 0 1 1 0 0 0 0 0 0 0 expected

        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.intersection(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
        
    }
    
    @Test
    public void testDifferenceNoOverlap()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {false,false,false,false,true,true,false,false,false,false}; 
        boolean[] expected = {true,true,true,true,false,false,false,false,false,false};
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 0 0 0 0 1 1 0 0 0 0 2nd
        // 1 1 1 1 0 0 0 0 0 0 expected

        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.difference(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
    }
    
    @Test
    public void testDifferenceOverlap()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {true,false,false,false,true,true,false,false,false,false}; 
        boolean[] expected = {false,true,true,true,false,false,false,false,false,false};
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 1 0 0 0 1 1 0 0 0 0 2nd
        // 0 1 1 1 0 0 0 0 0 0 expected
        
        
        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.difference(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
    }
    
    @Test
    public void testSymDifferenceNoOverlap()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {false,false,false,false,true,true,false,false,false,false}; 
        boolean[] expected = {true,true,true,true,true,true,false,false,false,false};
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 0 0 0 0 1 1 0 0 0 0 2nd
        // 1 1 1 1 1 1 0 0 0 0 expected
        
        
        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.symDifference(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
    }
    
    @Test
    public void testSymDifferenceOverlap()
    {
        boolean[] first = {true,true,true,true,false,false,false,false,false,false};
        boolean[] second = {true,false,false,false,true,true,false,false,false,false}; 
        boolean[] expected = {false,true,true,true,true,true,false,false,false,false};
        
        // 1 1 1 1 0 0 0 0 0 0 1st
        // 1 0 0 0 1 1 0 0 0 0 2nd
        // 0 1 1 1 1 1 0 0 0 0 expected

        BitSet set1 = new BitSet(uni, first); 
        BitSet set2 = new BitSet(uni, second);
        BitSet result = set1.symDifference(set2);
        
        System.out.printf("Set1: %s\nSet2: \nExpecting: %s\nResult: %s\n", set1.getBoolBits().toString(), set2.getBoolBits().toString(), expected.toString(), result.getBoolBits().toString() );
        
        assertArrayEquals(expected, result.getBoolBits());
    }
            
    @Test
    public void testMSetUnionNoOverlap()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 0 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        expecting
            
        a 3
        b 3 
        c 1
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mUnion(bag2);
        
        
        
        assertEquals(3, result.getCount("a"));
        assertEquals(3, result.getCount("b"));
        assertEquals(1, result.getCount("c"));
        assertEquals(5, result.getCount("d"));
        assertEquals(4, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
        
        
    }
    
    @Test
    public void testMSetUnionOverlap()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 10 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        expecting
            
        a 3
        b 10 
        c 1
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("b", 10);
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mUnion(bag2);
        
        
        
        assertEquals(3, result.getCount("a"));
        assertEquals(10, result.getCount("b"));
        assertEquals(1, result.getCount("c"));
        assertEquals(5, result.getCount("d"));
        assertEquals(4, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
     @Test
    public void testMSetIntersectionNoOverlap()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 0 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
         /*
        expecting
            
        a 0
        b 0 
        c 0
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mIntersection(bag2);
        
        assertEquals(0, result.getCount("a"));
        assertEquals(0, result.getCount("b"));
        assertEquals(0, result.getCount("c"));
        assertEquals(0, result.getCount("d"));
        assertEquals(0, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
    @Test
    public void testMSetIntersectionOverlap()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 10 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        expecting
            
        a 0
        b 3 
        c 0
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("b", 10);
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mIntersection(bag2);
        
        assertEquals(0, result.getCount("a"));
        assertEquals(3, result.getCount("b"));
        assertEquals(0, result.getCount("c"));
        assertEquals(0, result.getCount("d"));
        assertEquals(0, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
    
     @Test
    public void testMSetDiffNoOverlap()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 0 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
         /*
        expecting
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mDifference(bag2);
        
        assertEquals(3, result.getCount("a"));
        assertEquals(3, result.getCount("b"));
        assertEquals(1, result.getCount("c"));
        assertEquals(0, result.getCount("d"));
        assertEquals(0, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
    @Test
    public void testMSetDiffOverlapNegative()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 10 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        expecting 
        
        a 3
        b 0 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("b", 10);
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mDifference(bag2);
        
        assertEquals(3, result.getCount("a"));
        assertEquals(0, result.getCount("b"));
        assertEquals(1, result.getCount("c"));
        assertEquals(0, result.getCount("d"));
        assertEquals(0, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
    @Test
    public void testMSetDiffOverlapPositive()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 1 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        expecting 
        
        a 3
        b 2 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("b", 1);
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mDifference(bag2);
        
        
        
        assertEquals(3, result.getCount("a"));
        assertEquals(2, result.getCount("b"));
        assertEquals(1, result.getCount("c"));
        assertEquals(0, result.getCount("d"));
        assertEquals(0, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
    public void testMSetSumNoOverlap()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 0 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
         /*
        expecting
            
        a 3
        b 3 
        c 1
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mSum(bag2);
        
        assertEquals(3, result.getCount("a"));
        assertEquals(3, result.getCount("b"));
        assertEquals(1, result.getCount("c"));
        assertEquals(5, result.getCount("d"));
        assertEquals(4, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
    @Test
    public void testMSetSumOverlap()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // uni = {a,b,c,d,e,f,g,h,i,j}
        
        /*
        map1
            
        a 3
        b 3 
        c 1
        d 0 
        e 0
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        map2
            
        a 0
        b 10 
        c 0
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        /*
        expecting 
        
        a 3
        b 13 
        c 1
        d 5 
        e 4
        f 0 
        g 0 
        h 0 
        i 0
        j 0
        
        */
        
        map1.put("a", 3);
        map1.put("b", 3);
        map1.put("c", 1);
        
        map2.put("b", 10);
        map2.put("d", 5);
        map2.put("e", 4);
        
        Bag bag1 = new Bag(uni, map1);
        Bag bag2 = new Bag(uni, map2);
        
        Bag result = bag1.mSum(bag2);
        
        assertEquals(3, result.getCount("a"));
        assertEquals(13, result.getCount("b"));
        assertEquals(1, result.getCount("c"));
        assertEquals(5, result.getCount("d"));
        assertEquals(4, result.getCount("e"));
        assertEquals(0, result.getCount("f"));
        assertEquals(0, result.getCount("g"));
        assertEquals(0, result.getCount("h"));
        assertEquals(0, result.getCount("i"));
        assertEquals(0, result.getCount("j"));
    }
    
}
