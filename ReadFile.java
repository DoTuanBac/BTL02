/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyarcade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Do Tuan Bac
 */
public class ReadFile {

    public int[][] map(String file) {
        String temp;
        File input = new File(file);
        FileInputStream fis;
        BufferedReader br;
        int n, m;
        int arr[][] = null;
        try {
            fis = new FileInputStream(input);
            br = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            temp = br.readLine();
            n = Integer.parseInt(temp);
            temp = br.readLine();
            m = Integer.parseInt(temp);
            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                temp = br.readLine();
                String[] item = temp.split(" ");
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(item[j]);

                }

            }

        } catch (IOException ex) {
        }
        return arr;
    }

}
