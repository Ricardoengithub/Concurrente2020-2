package unam.ciencias.computoconcurrente;

import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    Graph graph;

    @Test
    void diametro() throws InterruptedException{
        graph = new Graph();
        int[][] matrix = { { 0, 1, 0, 0}, 
                            { 1, 0, 1, 0}, 
                            { 0, 1, 0, 1}, 
                            { 0, 0, 1, 0} }; 
        assertEquals(3, graph.findDiametro(matrix, 0));
    }

    @Test
    void diametro3() throws InterruptedException{
        graph = new Graph();
        int[][] matrix = { { 0, 1, 1, 1}, 
                            { 1, 0, 1, 1}, 
                            { 1, 1, 0, 1}, 
                            { 1, 1, 1, 0} }; 
        assertEquals(1, graph.findDiametro(matrix, 0));
    }

    @Test
    void diametro4() throws InterruptedException{
        graph = new Graph();
        int[][] matrix = { { 0, 1, 1, 0}, 
                            { 1, 0, 0, 1}, 
                            { 1, 0, 0, 1}, 
                            { 0, 1, 1, 0} }; 
        assertEquals(2, graph.findDiametro(matrix, 0));
    }


    @Test
    void diametro2() throws InterruptedException{
        graph = new Graph();
        int[][] matrix = { { 0, 1, 0, 0, 1, 0, 0, 1}, 
                            { 1, 0, 0, 0, 0, 0, 0, 0},
                            { 0, 0, 0, 1, 1, 1, 0, 0},
                            { 0, 0, 1, 0, 0, 1, 0, 0},
                            { 1, 0, 1, 0, 0, 0, 0, 0},
                            { 0, 0, 1, 1, 0, 0, 1, 0},
                            { 0, 0, 0, 0, 0, 1, 0, 1},
                            { 1, 0, 0, 0, 0, 0, 1, 0} }; 
        assertEquals(4, graph.findDiametro(matrix, 1));
    }


    


    @Test
    void diametroParalelo() throws InterruptedException{
        graph = new Graph(3);
        int[][] matrix = { { 0, 1, 0, 0}, 
                            { 1, 0, 1, 0}, 
                            { 0, 1, 0, 1}, 
                            { 0, 0, 1, 0} }; 
        assertEquals(3, graph.findDiametro(matrix, 0));
    }

    @Test
    void diametro3Paralelo() throws InterruptedException{
        graph = new Graph(3);
        int[][] matrix = { { 0, 1, 1, 1}, 
                            { 1, 0, 1, 1}, 
                            { 1, 1, 0, 1}, 
                            { 1, 1, 1, 0} }; 
        assertEquals(1, graph.findDiametro(matrix, 0));
    }

    @Test
    void diametro4Paralelo() throws InterruptedException{
        graph = new Graph(3);
        int[][] matrix = { { 0, 1, 1, 0}, 
                            { 1, 0, 0, 1}, 
                            { 1, 0, 0, 1}, 
                            { 0, 1, 1, 0} }; 
        assertEquals(2, graph.findDiametro(matrix, 0));
    }


    @Test
    void diametro2Paralelo() throws InterruptedException{
        graph = new Graph(3);
        int[][] matrix = { { 0, 1, 0, 0, 1, 0, 0, 1}, 
                            { 1, 0, 0, 0, 0, 0, 0, 0},
                            { 0, 0, 0, 1, 1, 1, 0, 0},
                            { 0, 0, 1, 0, 0, 1, 0, 0},
                            { 1, 0, 1, 0, 0, 0, 0, 0},
                            { 0, 0, 1, 1, 0, 0, 1, 0},
                            { 0, 0, 0, 0, 0, 1, 0, 1},
                            { 1, 0, 0, 0, 0, 0, 1, 0} }; 
        assertEquals(4, graph.findDiametro(matrix, 1));
    }
}