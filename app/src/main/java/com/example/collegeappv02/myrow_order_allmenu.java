package com.example.collegeappv02;

public class myrow_order_allmenu {

    private int bImageResource;
    private String bText1;
    private String bText2;
    private String bText3;
    private String bText4;
    private String bText5;
    private String bText6;


    public myrow_order_allmenu(int imageResource, String text1, String text2, String text3, String text4, String text5, String text6) {
        bImageResource = imageResource;
        bText1 = text1;
        bText2 = text2;
        bText3 = text3;
        bText4 = text4;
        bText5 = text5;
        bText6 = text6;

    }
    public int getImageResource() {
        return bImageResource;
    }
    public String getText1() { return bText1; }
    public String getText2() { return bText2; }
    public String getText3() {
        return bText3;
    }
    public String getText4() {
        return bText4;
    }
    public String getText5() { return bText5; }
    public String getText6() { return bText6; }

}