package com.risenphoenix.vibromassager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;





/**
 * Created by Fentom on 07.05.2017.
 */

public class InputHeandler implements InputProcessor {

    private ButtonThree but;
    private Timer timer;

    public InputHeandler(ButtonThree but){

        this.but = but;
        timer = new Timer();
        //timer=new Timer(1000,new ActionListener(
        //public void actionPerformed(ActionEvent ev) {
        //    System.out.println("WOW!");
        //}
        //));
        /*timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                // Your task
                Gdx.input.vibrate(new long[]{100,200},0);

            }
        },1.0f,0.3f);*/
        //timer.schedule(new Timer.Task() {
        //                   @Override
        //                   public void run() {
        //                       // Your task
        //                       Gdx.input.vibrate(200);

        //                   }
        //               },
        //        0.3f);

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    private void vibir(int ten){
        for(int i=0;i<20000000;i++){
            Gdx.input.vibrate(200);
            timer.delay(ten);

        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if(Intersector.overlaps(new Rectangle(but.fx,but.fy,but.width,but.height),new Rectangle(screenX, Gdx.graphics.getHeight()-screenY,2,2))){

            if(but.getStatusVkl()==0) {
                but.setStatusVkl(1);
            }else{
                but.setStatusVkl(0);
            }

            if(but.getStatusVkl()==1){
                if(but.getInd()==0){


                    Gdx.input.vibrate(2000000000);
                    but.setVibroStatus(true);
                }else {
                    Gdx.input.vibrate(new long[]{but.getInd()*100,but.getInd()*100},0);
                    but.setVibroStatus(true);
                    //timer.start();
                }
            }else{
                //timer.stop();
                Gdx.input.cancelVibrate();
                but.setVibroStatus(false);

            }
        }

        if(Intersector.overlaps(new Rectangle(but.fxL,but.fyL,but.widthL,but.heightL/2),new Rectangle(screenX,Gdx.graphics.getHeight()-screenY,2,2))){
            but.setStatusStrelka(1);
            if(but.getInd()!=0){
                but.setInd(but.getInd()-1);
                Gdx.input.cancelVibrate();
                but.setVibroStatus(false);
                but.setStatusVkl(0);
            }
        }

        if(Intersector.overlaps(new Rectangle(but.fxL,but.fyL+but.heightL/2,but.widthL,but.heightL),new Rectangle(screenX,Gdx.graphics.getHeight()-screenY,2,2))){
            but.setStatusStrelka(2);
            if(but.getInd()!=20){
                but.setInd(but.getInd()+1);
                Gdx.input.cancelVibrate();
                but.setVibroStatus(false);
                but.setStatusVkl(0);
            }
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        but.setStatusStrelka(0);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
