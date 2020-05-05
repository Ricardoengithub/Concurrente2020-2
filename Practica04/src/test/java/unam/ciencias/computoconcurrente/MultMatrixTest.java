package unam.ciencias.computoconcurrente;

import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultMatrixTest {
    MultMatrix matrixUtils;

    @Test
    void multiplica() throws InterruptedException{
        matrixUtils = new MultMatrix();
        int[][] matrix = {
                {4, 29, -6, 0},
                {15, 6, 0, 4},
                {25, 41, -10, 4},
                {0, 0, -1, 39},
        };
        int[][] matrix2 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
        };

        assertArrayEquals(matrix, matrixUtils.multiplica(matrix,matrix2));
    }

    @Test
    void multiplicaConcurrent() throws InterruptedException{
        matrixUtils = new MultMatrix(2);
        int[][] matrix = {
                {4, 29, -6, 0},
                {15, 6, 0, 4},
                {25, 41, -10, 4},
                {0, 0, -1, 39},
        };
        int[][] matrix2 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
        };

        assertArrayEquals(matrix, matrixUtils.multiplica(matrix,matrix2));
    }

    @Test
    void multiplica2() throws InterruptedException{
        matrixUtils = new MultMatrix();
        int[][] matrix = {
                {4, 29, -6, 0},
                {15, 6, 0, 4},
                {25, 41, -10, 4},
                {0, 0, -1, 39},
        };
        int[][] matrix2 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] resultado = {
            {4,0,0,0},
            {15,0,0,0},
            {25,0,0,0},
            {0,0,0,0}
        };

        assertArrayEquals(resultado, matrixUtils.multiplica(matrix,matrix2));
    }

        

    @Test
    void multiplica2Concurrent() throws InterruptedException{
        matrixUtils = new MultMatrix(3);
        int[][] matrix = {
                {4, 29, -6, 0},
                {15, 6, 0, 4},
                {25, 41, -10, 4},
                {0, 0, -1, 39},
        };
        int[][] matrix2 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] resultado = {
            {4,0,0,0},
            {15,0,0,0},
            {25,0,0,0},
            {0,0,0,0}
        };

        assertArrayEquals(resultado, matrixUtils.multiplica(matrix,matrix2));
    }

    // @Test
    // void multiplica2() throws InterruptedException{
    //     matrixUtils = new MatrixUtils();
    //     int[][] matrix = {
    //             {1, 1, 1},
    //             {1, 1, 1},
    //             {1, 1, 1}
    //     };

    //     assertEquals(1, matrixUtils.multiplica(matrix));
    // }

    // @Test
    // void multiplicaConcurrent2() throws InterruptedException{
    //     matrixUtils = new MatrixUtils(2);
    //     int[][] matrix = {
    //         {1, 1, 1},
    //         {1, 1, 1},
    //         {1, 1, 1}
    // };

    //     assertEquals(1, matrixUtils.multiplica(matrix));
    // }
}