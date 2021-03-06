import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// Faut penser au DP (ou au DFS cach�) plutot que chercher des solutions directes!

public class DonutsOnTheGridEasy {
    private String[] m_grid;
    private int m_w;
    private int m_h;
    private int[][][][] m_cache;

    public int calc(String[] grid) {
        m_grid = grid;
        m_h = grid.length;
        m_w = grid[0].length();
        m_cache = new int[m_h][m_h][m_w][m_w];
        for (int i = 0; i < m_h; i++) {
            for (int ii = 0; ii < m_h; ii++) {
                for (int j = 0; j < m_w; j++) {
                    for (int jj = 0; jj < m_w; jj++) {
                        m_cache[i][ii][j][jj] = -1;
                    }
                }
            }
        }
        return compute(0, m_h - 1, 0, m_w - 1);
    }

    private int compute(int imin, int imax, int jmin, int jmax) {
        if (imax-imin<2 || jmax-jmin<2) {
            return 0;
        }
        if (m_cache[imin][imax][jmin][jmax] == -1) {
            boolean donut = true;
            for (int j = jmin; j <= jmax; j++) {
                if (m_grid[imin].charAt(j) == '.' || m_grid[imax].charAt(j) == '.') {
                    donut = false;
                    break;
                }
            }
            if (donut) {
                for (int i = imin; i <= imax; i++) {
                    if (m_grid[i].charAt(jmin) == '.' || m_grid[i].charAt(jmax) == '.') {
                        donut = false;
                        break;
                    }
                }
            }
            if (donut) {
                m_cache[imin][imax][jmin][jmax] = 1 + compute(imin + 1, imax - 1, jmin + 1, jmax - 1);
            } else {
                m_cache[imin][imax][jmin][jmax] = Math.max(compute(imin + 1, imax, jmin, jmax), Math.max(compute(imin, imax - 1, jmin, jmax), Math.max(compute(imin, imax, jmin + 1, jmax), compute(imin, imax, jmin, jmax - 1))));
            }
        }
        return m_cache[imin][imax][jmin][jmax];
    }

    public static void main(String[] args) {
        DonutsOnTheGridEasy t = new DonutsOnTheGridEasy();
        String[] biggest;
        biggest = new String[]{
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000",
                "00000000000000000000000000000000000000000000000000"
        }; // 24
        biggest = new String[]{
                ".................................................0",
                "................................................00",
                "...............................................000",
                "..............................................0000",
                ".............................................00000",
                "............................................000000",
                "...........................................0000000",
                "..........................................00000000",
                ".........................................000000000",
                "........................................0000000000",
                ".......................................00000000000",
                "......................................000000000000",
                ".....................................0000000000000",
                "....................................00000000000000",
                "...................................000000000000000",
                "..................................0000000000000000",
                ".................................00000000000000000",
                "................................000000000000000000",
                "...............................0000000000000000000",
                "..............................00000000000000000000",
                ".............................000000000000000000000",
                "............................0000000000000000000000",
                "...........................00000000000000000000000",
                "..........................000000000000000000000000",
                ".........................0000000000000000000000000",
                "........................00000000000000000000000000",
                ".......................000000000000000000000000000",
                "......................0000000000000000000000000000",
                ".....................00000000000000000000000000000",
                "....................000000000000000000000000000000",
                "...................0000000000000000000000000000000",
                "..................00000000000000000000000000000000",
                ".................000000000000000000000000000000000",
                "................0000000000000000000000000000000000",
                "...............00000000000000000000000000000000000",
                "..............000000000000000000000000000000000000",
                ".............0000000000000000000000000000000000000",
                "............00000000000000000000000000000000000000",
                "...........000000000000000000000000000000000000000",
                "..........0000000000000000000000000000000000000000",
                ".........00000000000000000000000000000000000000000",
                "........000000000000000000000000000000000000000000",
                ".......0000000000000000000000000000000000000000000",
                "......00000000000000000000000000000000000000000000",
                ".....000000000000000000000000000000000000000000000",
                "....0000000000000000000000000000000000000000000000",
                "...00000000000000000000000000000000000000000000000",
                "..000000000000000000000000000000000000000000000000",
                ".0000000000000000000000000000000000000000000000000"
//                "00000000000000000000000000000000000000000000000000"
        }; // 12
//        for (int i = 0; i < 50; i++) {
//            System.out.print("\"");
//            for (int j = 0; j < 50 - i - 1; j++) {
//                System.out.print(".");
//            }
//            for (int j = 0; j < i + 1; j++) {
//                System.out.print("0");
//            }
//            System.out.println("\",");
//        }
        int res = t.calc(biggest);
        System.out.println("res=" + res);
    }
}
