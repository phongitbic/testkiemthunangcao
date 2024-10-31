package com.example.demo;

public class GiaiThua {

    public int tinhGiaiThua(int n) {

        int ketQua = 1;

            for (int i = 1; i < n; i++) {
                ketQua *=i;
            }

        return ketQua;
    }
    public static void main (String[]args){
        GiaiThua giaiThua = new GiaiThua();
        System.out.println(giaiThua.tinhGiaiThua(6));
    }
}
