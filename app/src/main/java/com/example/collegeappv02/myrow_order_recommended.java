package com.example.collegeappv02;

public class myrow_order_recommended {

    private int nImageResource;
    private String nText1;
    private String nText2;
    private String nText3;
    private String nText4;
    private String nText5;


    public myrow_order_recommended(int imageResource, String text1, String text2, String text3, String text4, String text5) {
        nImageResource = imageResource;
        nText1 = text1;
        nText2 = text2;
        nText3 = text3;
        nText4 = text4;
        nText5 = text5;

    }
    public int getImageResource() {
        return nImageResource;
    }
    public String getText1() { return nText1; }
    public String getText2() { return nText2; }
    public String getText3() {
        return nText3;
    }
    public String getText4() {
        return nText4;
    }
    public String getText5() {
        return nText5;
    }

}
