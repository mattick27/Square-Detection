package com.company;

public class Data_type_arrays {
    static int[] a = new int[1];
    static int[] b = new int[1];
    static int[] c ;
    static int count = 0 ;
    static int[][] test = new int[0][0];
    static int[][] plot = new int[0][0];
    static int[][] temp = new int[0][0];

    static void reset (){
        count = 0;
    }
    static void clone (int[][] x ,int width,int height){
        test = x ;
        a[0] = width ;
        b[0] = height ;
    }
    static void set (int[]x,int[]y,int[]z){ // new empty array map
        a = x;
        b = y;
        c = z;
        test = new int[a[0]][b[0]];
    }

    static void temp () {
        temp = new int[a[0]][b[0]];
        for (int i = 0; i < a[0]; i++) {
            for (int j = 0; j <b[0] ; j++) {
                test[i][j] = plot[i][j];
            }
        }
    }

    static void crete (){ // new array map with value
        for (int i =0 ; i < a[0] ;i++){
            for (int j =0 ; j<b[0];j++){
                test[i][j] = c[count] ;
                count ++ ;
            }
        }
    }


    static void show (){ // show map
        count = 0;
        for (int i = 0 ;i < a[0] ; i++){
            for (int j = 0 ;j<b[0];j++){
                System.out.print("("+test[i][j]+"),");
                count ++;
                if (count%b[0] == 0){
                    System.out.println("");
                }
            }
        }
    }

    static void show_plot (){
        count = 0;
        for (int i = 0 ;i < a[0] ; i++){
            for (int j = 0 ;j<b[0];j++){
                System.out.print(plot[i][j]);
                count ++;
                if (count%b[0] == 0){
                    System.out.println("");
                }
            }
        }
    }

    static void show_temp (){
        count = 0;
        for (int i = 0 ;i < a[0] ; i++){
            for (int j = 0 ;j<b[0];j++){
                System.out.print("("+temp[i][j]+"),");
                count ++;
                if (count%b[0] == 0){
                    System.out.println("");
                }
            }
        }
    }

    static void plot_empty (){ //set all plot = 0
        plot = test;
        for (int i = 0; i < a[0]; i++) {
            for (int j = 0; j <b[0] ; j++) {
                plot[i][j] = 0;
            }
        }
    }

    static void plot (Coordinate x ){

        for (int i =0 ; i < x.lo.size() ;i++){
                    Coordinate travel = (Coordinate)x.lo.get(i);
                    plot[travel.x][travel.y] = 1 ;
            }
        }

    }


