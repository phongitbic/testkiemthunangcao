package com.example.demo;

public class GiaiThua {

    public int tinhGiaiThua(int n) {

        int ketQua = 1;

            for (int i = 2; i <= n; i++) {
                System.out.println(ketQua);
                ketQua = ketQua * i;
            }
        System.out.println("OK");
//         i = 2 , i = 3 x2 = 6 , i = 4 x 6 = 24 , i = 5 x 24 =  120
//        i = 1 , i = 2 x 1 = 2 , i = 3 x 2 = 6 , i = 4 x 6 = 24 , i = 5 x 24 = 120


        return ketQua;
    }
    public static void main (String[]args){
        GiaiThua giaiThua = new GiaiThua();
        System.out.println(giaiThua.tinhGiaiThua(5));
    }
}
