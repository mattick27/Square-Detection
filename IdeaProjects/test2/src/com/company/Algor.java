package com.company;

/**
 * Created by Matichon on 3/9/2017.
 */
public class Algor {
    static Coordinate save = new Coordinate();
    static Coordinate save_2 = new Coordinate();
    static Coordinate save_i = new Coordinate();
    static Coordinate save_j = new Coordinate();
    static int count = 0;
    static int count_co = 0; // search_3
    static int count_i = 0; // search_3
    static int count_j = 0; // search_3
    static int start_i = 0;  // search_3
    static int start_j = 0; // search_3
    static int tick_i = 0; // search_3
    static int tick_j = 0;
    static int size_i = 0; // search_3
    static int size_j = 0; // search_3
    static Coordinate travel;

    static void search_1() { // 010|101|010
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < Data_type_arrays.b[0]; j++) { // Search in first collum in beta test
                if (Data_type_arrays.test[i][j] == 1) {
                    save.crete(i, j);
                }
            }
            System.out.println("Search in Collum finish");

            for (int k = 0; k < save.lo.size(); k++) {
                travel = (Coordinate) save.lo.get(k);
                //System.out.println(travel.x + " " +travel.y);
                if (travel.y - 1 >= 0 && travel.y + 1 <= 7) { // When it don't be board of map
                    if (Data_type_arrays.test[travel.x + 1][travel.y-1] == 1) { // Check left bottom array
                        save_2.crete(travel.x + 1, travel.y-1);
                    }
                    if (Data_type_arrays.test[travel.x + 1][travel.y] == 1) { // Check bottom array
                        save_2.crete(travel.x+1, travel.y);
                    }
                    if(Data_type_arrays.test[travel.x + 1][travel.y+1] == 1){ // Check right bottom array
                        save_2.crete(travel.x+1,travel.y+1);
                    }
                        System.out.println("Search in next row finish(normal)");

                }
                else{
                    if (Data_type_arrays.test[travel.x + 1][travel.y] == 1) { // when it be board of map
                        save_2.crete(travel.x+1, travel.y);
                    }
                    System.out.println("Search in next row finish(board)");
                }

            }
        }

    }
    static void search_2(){ // square
        int start = 0;
        int end = 0;
        int size_1 = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < Data_type_arrays.b[0] - 1; j++) {
                if (Data_type_arrays.test[i][j] == Data_type_arrays.test[i][j + 1] && Data_type_arrays.test[i][j] == 1) {
                    save.crete(i, j);
                    save.crete(i, j + 1);
                }
                for (int k = 0; k < save.lo.size(); k++) {
                    if (k == 0) {
                        int start_1 = ((Coordinate) save.lo.get(k)).y;
                        int end_1 = start + save.lo.size() - 1;
                        int size_2 = save.lo.size();
                        start = start_1;
                        end = end_1;
                        size_1 = size_2;
                    }
                }

               for (int k = 1; k < 10; k++) {
                    if (Data_type_arrays.test[k][start] == Data_type_arrays.test[k - 1][start] &&
                            Data_type_arrays.test[k][end] == Data_type_arrays.test[k - 1][end]) {
                        save_2.crete(k, start);
                        save_2.crete(k, end);
                    } else {
                        break;
                    }
                }

               // for (int k = 3 ; k < 5 ; k++ ){ // 3 = Data_type_arrays.test[((Coordinate)save_2.lo.get(LASTEST-1)).y]
                                                // 5 = Data_type_arrays.test[((Coordinate)save_2.lo.get(LASTEST).y]
                 //   if (Data_type_arrays.test[3][k] == Data_type_arrays.test[3][k+1]){
                   //     save_2.crete(3,k+1); // SAVE_2 = SAVEFINAL
                    //}
            //}
            }
        }
    }
    static void search_3(){
        for (int i = 0; i < Data_type_arrays.a[0]-1 ; i++) {
            for (int j = 0; j < Data_type_arrays.b[0]-1 ; j++) {
                if (Data_type_arrays.test[i][j] == Data_type_arrays.test[i+1][j] &&
                        Data_type_arrays.test[i][j] == Data_type_arrays.test[i][j+1] &&
                        Data_type_arrays.test[i][j] == 1) {
                     count = 0;
                    int reset = 0;
                    dup(i,j);
                   // System.out.println("This is count after dup ==>" + count);
                    if (count==0) {
                        save.crete_co(i, j);
                     //   System.out.println("Show crete_co i and j " + i +" " +j);
                        crete_i(i+1,j);
                        crete_j(i,j+1);
                        if (!save_i.lo.isEmpty() && !save_j.lo.isEmpty()) {
                           /* if (j + 1 == Data_type_arrays.b[0] - 2) { // row j
                                System.out.println("Pass 1 ");
                                for (int k = i; k < Data_type_arrays.a[0] - 1; k++) {
                                    System.out.println(k + " " + j + 1);
                                    if (Data_type_arrays.test[k][j + 2] == 1) {
                                        crete_j(k,j+2);
                                        System.out.println("Pass 2 " + k + " " + j + 1);
                                    } else {
                                        break;
                                    }
                                }
                            }
                            if (i + 1 == Data_type_arrays.a[0] - 2) { // row i
                                System.out.println("Pass 1 ");
                                for (int k = j; k < Data_type_arrays.b[0] - 1; k++) {
                                    System.out.println(k + " " + j + 1);
                                    if (Data_type_arrays.test[i + 2][k] == 1) {
                                        crete_i(i+2,k);
                                        System.out.println("Pass 2 " + k + " " + j + 1);
                                    } else {
                                        break;
                                    }
                                }
                            }*/
                            // ***************warnning**********************
                            for (int k = i + 1; k < Data_type_arrays.a[0] - 1; k++) { // Row i
                         //       System.out.println(k+" ---- This is k");
                                if (Data_type_arrays.test[k][j] == Data_type_arrays.test[k + 1][j]) {
                                    crete_i(k+1,j);
                       //             System.out.println((k+1) + " HELL " +j);
                                } else { // if end of line
                                    for (int l = j; l < Data_type_arrays.b[0] - 1; l++) { // Search in Row i collum j
                                        if (Data_type_arrays.test[k][l] == Data_type_arrays.test[k][l + 1]
                                                && Data_type_arrays.test[k][l] == 1) {
                                            crete_j(k,l+1);// j in i
                                            tick_i++;
                                        }
                                        else {
                           //                 System.out.println((k+1) + " " + i);
                             //               System.out.println(save.getx(count_co-1)+"<----------- This is count_co");
                                            if (true){
                                                for (int m = k-1; m > save.getx(count_co-1) ; m--) {
                                                    for (int n = j; n < Data_type_arrays.b[0]-1 ; n++) {
                               //                             System.out.println("show m & n" + m + "&&&" + n);
                                                        if (Data_type_arrays.test[m][n] == Data_type_arrays.test[m][n + 1]
                                                                && Data_type_arrays.test[m][n] == 1) {
                                                            crete_j(m,n+1);// j in i
                                 //                           System.out.println("Crete j Complete" + m + "&&&&&"+(n+1));
                                                        }
                                                        else{
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        }
                                    break ;
                                     }
                                }
                            }
                            for (int k = j + 1; k < Data_type_arrays.b[0] - 1; k++) { // Collum j
                                if (Data_type_arrays.test[i][k] == Data_type_arrays.test[i][k + 1]) { // if has next
                                    crete_j(i,k+1);
                                   // System.out.println(i + " " +k+1);
                                } else { // if end of line
                                    for (int l = i; l < Data_type_arrays.a[0] - 1; l++) { // Search in Collum j row i
                                        if (Data_type_arrays.test[l][k] == Data_type_arrays.test[l + 1][k]
                                                && Data_type_arrays.test[l][k] == 1) {
                                            crete_i(l+1,k);// i in j
                                       }
                                        else {
                                            if (true){
                                                for (int m = k-1; m > save.gety(count_co-1) ; m--) {
                                                    for (int n = i; n < Data_type_arrays.a[0]-1 ; n++) {
                                     //                    System.out.println("show m & n" + (n+1) + "&&&&&"+(m));
                                                        if (Data_type_arrays.test[n][m] == Data_type_arrays.test[n+1][m]
                                                                && Data_type_arrays.test[n][m] == 1) {
                                                            crete_i(n+1,m);// j in i
                                       //                      System.out.println("Crete i Complete" + (n+1) + "&&&&&"+(m));
                                                        }
                                                        else{
                                                            break;
                                                        }
                                                    }
                                                }

                                            }
                                            break;
                                        }
                                    }
                                    break ;
                                }
                            }
                        }
                        ////////////////////////// reset unsquare
                        size_i = save_i.lo.size();
                        size_j = save_j.lo.size();
                        for (int k = start_i; k < save_i.lo.size() ; k++) {
                            for (int l = start_j; l < save_j.lo.size(); l++) {
                                if (save_i.getx(k) == save_j.getx(l) &&
                                        save_i.gety(k) == save_j.gety(l)){
                                    reset++;
                                }
                                //count_j++;
                            }
                            //count_i++;
                        }
                        if (reset == 0) {
                            for (int k = start_i; k < size_i; k++) {
                                save_i.lo.remove(start_i);
                                count_i--;
                             //   System.out.println("Finish");
                            }
                            for (int k = start_j; k < size_j; k++) {
                                save_j.lo.remove(start_j);
                                count_j--;
                               // System.out.println("Finish_2");
                            }
                           // System.out.println("************RESET************");
                        //    System.out.println(start_i + " |||| " + start_j);
                        }
                        start_i = count_i;
                        start_j = count_j;
                        /////////////////////////////////////////////////////
                    }
                }
            }
        }

    static void search_4(){
        Coordinate save_first = new Coordinate();
        Coordinate save_second = new Coordinate();
        Coordinate save_third = new Coordinate();
        int save_1 = save_first.lo.size();
        int save_2 = save_second.lo.size();
        int save_3= save_third.lo.size();
        for (int i = 0; i < Data_type_arrays.a[0]-1; i++) {
                for (int j = 0; j < Data_type_arrays.b[0]-1; j++) {
                            if (Data_type_arrays.test[i][j] == 1) {
                                if (Data_type_arrays.test[i][j] == Data_type_arrays.test[i+1][j-1]){
                                    save_first.crete(i+1,j-1);
                                }
                                if (Data_type_arrays.test[i][j] == Data_type_arrays.test[i+1][j]){
                                    save_second.crete(i+1,j);
                                }
                                if (Data_type_arrays.test[i][j] == Data_type_arrays.test[i+1][j+1]){
                                    save_third.crete(i+1,j+1);
                                }
                            }
                     save_1 = save_first.lo.size();
                     save_2 = save_second.lo.size();
                     save_3= save_third.lo.size();
                }
        }
    }
    static void reset (){
        save.lo.clear();
        save_i.lo.clear();
        save_j.lo.clear();
        save_2.lo.clear();
        count = 0;
        count_co = 0;
        count_j = 0;
        count_i = 0;
        start_j = 0;
        start_i = 0;
        tick_i = 0;
        size_i = 0;
        size_i = 0;
    }

    static void dup(int i, int j){
        if (count == 0){
        for (int k = 0; k < save.lo.size(); k++) {
            if (i == ((Coordinate) save.lo.get(k)).x &&
                    j == ((Coordinate) save.lo.get(k)).y){
                count++;
              //  System.out.println("Dup Finish");
                break;
            }
        }
        }
        if (count == 0) {
            for (int k = 0; k < save_i.lo.size(); k++) {
                if (i == ((Coordinate) save_i.lo.get(k)).x &&
                        j == ((Coordinate) save_i.lo.get(k)).y) {
                    count++;
                //    System.out.println("Dup Finish");
                    break;
                }
            }
        }
        if (count == 0) {
            for (int k = 0; k < save_j.lo.size(); k++) {
                if (i == ((Coordinate) save_j.lo.get(k)).x &&
                        j == ((Coordinate) save_j.lo.get(k)).y) {
                    count++;
                 //   System.out.println("Dup Finish");
                    break;
                }
            }
        }
    }

    static void crete_i (int i , int j ){
        save_i.crete_i(i,j);
        count_i++;
    }

    static void crete_j (int i , int j ){
        save_j.crete_j(i,j);
        count_j++;
    }

    static void final_clear (Coordinate a ){
        for (int i = 0 ; i < a.lo.size() ; i ++){
            if (Data_type_arrays.plot[a.getx(i)][a.gety(i)]
                    == Data_type_arrays.plot[a.getx(i)+1][a.gety(i)] &&
                    Data_type_arrays.plot[a.getx(i)][a.gety(i)]
                            == Data_type_arrays.plot[a.getx(i)][a.gety(i)+1]){
                a.lo.remove(i);
            }
        }
    }
}
