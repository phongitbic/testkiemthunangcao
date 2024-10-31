package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GiaiThuaTest {

    @Test
    void tinhGiaiThua() {
        GiaiThua giaiThua = new GiaiThua();
        int expected, actual;
        actual = giaiThua.tinhGiaiThua(5);
        expected = 120;
        assertEquals(expected,actual);
    }
}