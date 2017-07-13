package com.company;
import java.io.IOException;
import java.util.*;
public class Main {
    static Image img_1 = new Image();
    static int[][] temp = new int[99][99];
    public static void main(String[] args) throws IOException {
        long starttime = System.currentTimeMillis();
           temp = img_1.input("Sketch.png");
           img_1.exposure(temp,20);
           img_1.print_out_std(temp,"testexpo");
        System.out.println("Mod Red pixels"+(16777215)%256 + " Patient" + (16777215)/256 );
        System.out.println("Mod Green pixels"+((16777215)%256)%256 + " Patient" + ((16777215)/256)/256 );
        System.out.println("Mod Blue pixels"+(((16777215)%256)%256)%256 + " Patient" + ((16777215)/256)/256/256 );

        long endtime = System.currentTimeMillis();
        System.out.println((endtime - starttime)/1000d + "Second");
        System.out.println((endtime-starttime)/1000d/1000 + "Second per round");
    }
/*
    static void start () throws IOException {
        int[][] c ;
        int width = 0 ;
        int height = 0 ;
        c = img_1.input();
        c = img_1.trim(c);
        width = 27;
        height = 27;
        Data_type_arrays.clone(c,width,height);
    }
    static void process () throws IOException {
        Algor.search_3();
        Data_type_arrays.plot_empty();
        Data_type_arrays.plot(Algor.save_i);
        Data_type_arrays.plot(Algor.save_j);
        Algor.final_clear(Algor.save);
        Data_type_arrays.plot(Algor.save);
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                temp[i][j] = Data_type_arrays.plot[i][j];
            }
        }
        img_1.print_out_1(img_1.detrim(temp));
        Data_type_arrays.show_plot();
        System.out.println("--------------------------------------------");
        Algor.reset();
        Data_type_arrays.reset();
        Data_type_arrays.temp();
        Algor.search_3();
        Data_type_arrays.plot_empty();
        Data_type_arrays.plot(Algor.save_i);
        Data_type_arrays.plot(Algor.save_j);
        Data_type_arrays.plot(Algor.save);
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                temp[i][j] = Data_type_arrays.plot[i][j];
            }
        }
        img_1.print_out(img_1.detrim(temp));
        Data_type_arrays.show_plot();
    }
   static void operation_1() throws IOException{ //qrcode_250px.jpg
        start();
        for (int j = 0; j <27; j++) {
            for (int i = 0; i <27; i++) {
                System.out.print(Data_type_arrays.test[j][i]);
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------");
        process();
    }*/
}
