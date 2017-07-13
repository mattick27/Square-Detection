package com.company;

import java.util.ArrayList;

public class Coordinate {
    ArrayList lo = new ArrayList<Coordinate>();
    int x=0 , y=0;
    private int log= 0;
    private String savelog = "";
    Coordinate (int a , int b){
        x = a;
        y = b;
    }
    Coordinate (){}
    void test (int a , int b ){
    }
    void crete_i (int a , int b){

        lo.add(new Coordinate(a,b));
        Coordinate dup = new Coordinate(a,b); //Check Dupplicate
        Coordinate travel;
        for (int i = 0; i < lo.size()-1; i++) { // lo.size()-1 check before element
            travel = (Coordinate) lo.get(i);
            if (dup.x == travel.x && dup.y == travel.y){
                lo.remove(i);
                Algor.count_i--;
            }
            if (i == 0) {
                //System.out.println("Check Dupplicate finish");
            }
        } /////////////////////////////////////////////////////////

    }void crete_j (int a , int b){

        lo.add(new Coordinate(a,b));
        Coordinate dup = new Coordinate(a,b); //Check Dupplicate
        Coordinate travel;
        for (int i = 0; i < lo.size()-1; i++) { // lo.size()-1 check before element
            travel = (Coordinate) lo.get(i);
            if (dup.x == travel.x && dup.y == travel.y){
                lo.remove(i);
                Algor.count_j--;
            }
            if (i == 0) {
             //   System.out.println("Check Dupplicate finish");
            }
        } /////////////////////////////////////////////////////////

    }
    void crete_co (int a , int b){
        Algor.count_co++;
        lo.add(new Coordinate(a,b));
        Coordinate dup = new Coordinate(a,b); //Check Dupplicate
        Coordinate travel;
        for (int i = 0; i < lo.size()-1; i++) { // lo.size()-1 check before element
            travel = (Coordinate) lo.get(i);
            if (dup.x == travel.x && dup.y == travel.y){
                lo.remove(i);
                Algor.count_co--;
            }
            if (i == 0) {
               // System.out.println("Check Dupplicate finish");
            }
        } /////////////////////////////////////////////////////////

    }
    void crete (int a , int b){

        lo.add(new Coordinate(a,b));
        Coordinate dup = new Coordinate(a,b); //Check Dupplicate
        Coordinate travel;
        for (int i = 0; i < lo.size()-1; i++) { // lo.size()-1 check before element
            travel = (Coordinate) lo.get(i);
            if (dup.x == travel.x && dup.y == travel.y){
                lo.remove(i);
            }
            if (i == 0) {
             //   System.out.println("Check Dupplicate finish");
            }
        } /////////////////////////////////////////////////////////

    }


    void show (){
        Coordinate travel;  // show save coordinate
        for (int i = 0; i < lo.size(); i++) {
            travel = (Coordinate)lo.get(i);
            System.out.println("{"+i+"}"+"[" + travel.x + "," +travel.y +"]");
            log ++;
            savelog += "{"+log+"}" +"["+ travel.x +","+travel.y+"]"+"";
        }
    }
    static void merge (Coordinate a , Coordinate b){
        for (int i = 0; i < b.lo.size(); i++) {
            a.crete(((Coordinate)(b.lo.get(i))).x,((Coordinate)(b.lo.get(i))).y);
        }
    }
    int getx(int a ){
        int x = ((Coordinate)lo.get(a)).x;
        return x;
    }

    int gety(int a ){
        int y = ((Coordinate)lo.get(a)).y;
        return y;
    }
    void log (){
        System.out.println(savelog);
    }
    void transfer (Coordinate a){
        lo = a.lo;
    }
}
