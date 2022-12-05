package org.firstinspires.ftc.teamcode;

import androidx.lifecycle.Lifecycle;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Teleop_Advanced extends OpMode{
    public enum LiftState {
        LIFT_START,
        LIFT_UP,
        LIFT_DOWN,
        BOXOPEN,
        BOXCLOSED,
        DUMP_POS


    }
    public enum ServoState{

    }

    LiftState liftState = LiftState.LIFT_START;



    @Override
    public void init() {

    }

    @Override
    public void loop() {
        switch (liftState){
            case LIFT_START:
                if(gamepad1.x){
                    //set motor position to lift up
                    liftState = LiftState.LIFT_UP;
                }
                break;
            case LIFT_UP:
                //set servo dump arm to dump position
                break;


            case DUMP_POS:
                //set servo to dump position
                liftState = LiftState.BOXOPEN;
                break;
            case BOXOPEN:
                //wait for cone to fall
                break;






        }


    }



}
