package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Image {
    int width = 0;
    int height = 0;

    public void print_out_std(int[][] a ,String b) throws IOException {
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < img.getHeight() ; i++) {
            for (int j = 0; j < img.getWidth() ; j++) {
                img.setRGB(j, i, a[j][i]);
                //       System.out.println(count + "||" + i + "|| " + j);
            }
        }
        System.out.println(width + " | " + height);
        String path = "C:\\a\\" + b + ".png";
        File output = new File(path);
        ImageIO.write(img,"png",output);
    }

    public void print_out(int[][] a ) throws IOException {
        BufferedImage img = new BufferedImage(width+10,height+10,BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < img.getHeight() ; i++) {
            for (int j = 0; j < img.getWidth() ; j++) {
                if (a[i][j] == 0) {
                    img.setRGB(j, i, 14474200);
                }
                else{
                    img.setRGB(j,i,38612);
                }
                //       System.out.println(count + "||" + i + "|| " + j);
            }
        }
        File output = new File("C:\\a\\beta1.jpg");
        ImageIO.write(img,"jpg",output);
    }


    public void print_out_1(int[][] a ) throws IOException {
        BufferedImage img = new BufferedImage(width+10,height+10,BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < img.getHeight() ; i++) {
            for (int j = 0; j < img.getWidth() ; j++) {
                if (a[i][j] == 0) {
                    img.setRGB(j, i, 16000000);
                }
                else{
                    img.setRGB(j,i,0);
                }
                //       System.out.println(count + "||" + i + "|| " + j);
            }
        }
        File output = new File("C:\\a\\beta2.jpg");
        ImageIO.write(img,"jpg",output);
    }

    public int[][] input (String p) throws IOException {
        String path = "C:\\a\\" + p;
        BufferedImage img = ImageIO.read(new File(path));
        width = img.getWidth();
        height = img.getHeight();
        int[][] arr_int = new int[width][height];
        coverttoRGB(arr_int,img);
        System.out.println(img.getRGB(600, 50));
        System.out.println(arr_int[600][50]);
        String me ;
        return arr_int;
    }


    public void coverttoBW(int[][] arr_int, BufferedImage img) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = Math.abs(img.getRGB(j, i));
                if (temp > 4474204) {
                    arr_int[i][j] = 1;
                } else {
                    arr_int[i][j] = 0;
                }
            }
        }
    }

    public void coverttoRGB(int[][] arr_int, BufferedImage img) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = 16777216+(img.getRGB(j, i));
                if (i == 795 && j == 940){
                    System.out.println("temp = "+temp + "Origin = " + img.getRGB(j,i) );
                }
                arr_int[j][i] = temp;
            }
        }
    }



    public void exposure (int[][] arr_int,int add){ // RGB
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = arr_int[j][i];
                int temp_R = (temp/256)/256;
                int temp_G = (temp/256)%256;
                int temp_B = temp%256%256%256;
                if (i == 795 && j == 940){
                    System.out.println("temp = "+temp + "temp_R = " + temp_R +"temp_G = " + temp_G + " temp_B = " + temp_B);
                }
                temp_R = temp_R + add;
                temp_G = temp_G + add;
                temp_B = temp_B + add;
                if (i == 795 && j == 940){
                    System.out.println("temp = "+temp + "temp_R = " + temp_R +"temp_G = " + temp_G + " temp_B = " + temp_B);
                }

                if (temp_R > 255){
                    temp_R = 255;
                }

                if (temp_G > 255){
                    temp_G = 255;
                }

                if (temp_B > 255){
                    temp_B = 255;
                }
                if (temp_R <= 0){
                    temp_R = 0;
                }

                if (temp_G <= 0){
                    temp_G = 0;
                }

                if (temp_B <= 0){
                    temp_B = 0;
                }


                temp = (temp_B)+(temp_G*256)+(temp_R*256*256);
                if ( i == 795 && j == 940){
                    System.out.println("temp = " + temp +"temp B = " + temp_B + "temp G " + temp_G*256 + "temp R " + temp_R*256*256);
                }
                if (temp > 16777215){
                    temp = 16777215;
                }
                if (temp <= 0 ){
                    temp = 0;
                }
                arr_int[j][i] = temp;
            }
        }
    }

    public int[][] trim (int[][] a) {
        int[][] grim = new int[27][27];
        int du = 3;
        int dx = 3;
        int b = 1;
        int c = 1;
        for (int i = 0; i < height; i++) {
            if (i == dx ) {
                for (int j = 0; j < width; j++) {
                    if (j == du) {
                        grim[b][c] = a[i][j];
                        System.out.println(b +" "+c);
                        c++;
                        du += 10;
                    }
                }
                c = 1;
                du = 3;
                dx += 10;
                b++;
            }
        }
        return grim;
    }

    public int[][] detrim (int[][] a)throws IOException{
        int g = 0;
        int c = 0;
        int count_i = 0;
        int count_j = 0;
        int[][] arr_int = new int[height+100][width+100];
        for (int i = 0; i < height; i++) {
            c=0;
            if (count_i < 8) {
                for (int j = 0; j < width; j++) {
                    if (count_j < 8) {
                        arr_int[i][j] = a[g][c];
                        count_j++;
                      //  System.out.println(g +" "+c +"||" +i + " " +j);
                    } else {
                        c++;
                        arr_int[i][j] = a[g][c];
                        count_j = 0;
                    }
                }
                count_i++;
                count_j = 0;
            }


            else {
                g++;
                for (int j = 0; j < width; j++) {
                    //System.out.println("-------------->"+g +" "+c +"||" +i + " " +j);
                    if (count_j < 8) {
                        arr_int[i][j] = a[g][c];
                        count_j++;
                    } else {
                        c++;
                        arr_int[i][j] = a[g][c];
                        count_j = 0;
                    }
                }
                count_j = 0;
                count_i = 0;
            }



        } // end loop
        // end trim
        return arr_int;
    }
}
