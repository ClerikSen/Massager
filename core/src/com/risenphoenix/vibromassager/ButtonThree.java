package com.risenphoenix.vibromassager;

/**
 * Created by Fentom on 07.05.2017.
 */

public class ButtonThree {

    private int vkl;
    private int strelka;

    public float fx,fy,fxL,fyL,fxR,fyR,width,height,widthL,heightL;
    private int ind;
    private boolean vibro;

    public ButtonThree(float fx, float fy, float fxL, float fyL, float width, float height, float widthL, float heightL){
        this.fx = fx;
        this.fy = fy;
        this.fxL = fxL;
        this.fyL = fyL;
        this.fxR = fxR;
        this.fyR = fyR;
        this.width = width;
        this.height = height;
        this.widthL = widthL;
        this.heightL = heightL;
        vkl = 0;
        strelka=0;
        //left = false;
        //right = false;
        ind = 0;
        vibro = false;
    }

    public boolean getVibroStatus(){
        return vibro;
    }
    public void setVibroStatus(boolean flag){
        vibro = flag;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public int getStatusVkl(){
        return vkl;
    }

    public int getStatusStrelka(){
        return strelka;
    }

    public void setStatusVkl(int status){
        vkl = status;
    }

    public void setStatusStrelka(int status){
        strelka = status;
    }


}
