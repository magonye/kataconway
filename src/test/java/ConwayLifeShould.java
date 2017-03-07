import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConwayLifeShould {


    @Test public void
    satisfact_rule_number_1(){
        int[][][] gliders = {
                {{0,0,0}, {0,1,0}, {0,0,0}},
                {{0,0,0}, {0,0,0}, {0,0,0}}
        };
        System.out.println("Glider");
        LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.getGeneration(gliders[0], 1);
        assertTrue("Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]), LifeDebug.equals(res, gliders[1]));

    }

    @Test public void
    satisfact_rule_number_2(){
        int[][][] gliders = {
                {{1,0,1}, {0,1,0}, {1,0,1}},
                {{0,0,0}, {0,0,0}, {0,0,0}}
        };
        System.out.println("Glider");
        LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.getGeneration(gliders[0], 1);
        assertTrue("Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]), LifeDebug.equals(res, gliders[1]));

    }

    @Test public void
    satisfact_rule_number_3(){
        int[][][] gliders = {
                {{0,0,0}, {0,1,0}, {1,1,1}},
                {{0,0,0}, {0,1,0}, {1,1,1}}
        };
        System.out.println("Glider");
        LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.getGeneration(gliders[0], 1);
        assertTrue("Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]), LifeDebug.equals(res, gliders[1]));

    }



}