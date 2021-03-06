package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Based on the SampleTeleOp program created by Katelin Zichittella on 9/24/2016.
 */


// This line establishes this op mode as a teleop op mode and allows for it to be displayed
// in the drop down list on the Driver Station phone to be chosen to run.
//@Disabled - temporarily takes this op mode off of the drop down list until it is
// commented out.
@TeleOp(name = "testleOP")
//@Disabled

public class TestTeleop extends OpMode {


    DcMotor thatmotor = null; // name of motor
    Servo Smartroboserbo = null;   // name of servo
    boolean currStateB =false;
    boolean currStateX =false;
    boolean prevStateB =false;
    boolean prevStateX =false;
    /**
     * init() - initialization routine that is executed when the opmode is first choosen
      */
    @Override
    public void init() {

        // Get from the hardware map the motor (dcMotor) and the servo

       thatmotor = hardwareMap.dcMotor.get("thatmotor");
       Smartroboserbo = hardwareMap.get(Servo.class, "Smartroboserbo");

    }

    /**
     * loop - main teleop loop, FTC SDK will call this over and over until the program is stopped
     */
    @Override
    public void loop() {

        // get the gamepad input...there are two gamepads, 1 and 2, for this we will use gamepad1
        // we can use either of the sticks to be the power that we will set the motor to, then
        // call the setMotorPower method to set the power to the motor
        double  motorpower;
        motorpower = -gamepad1.right_stick_y;
        setMotorPower(motorpower);

        // get the gamepad input for for buttons that will be used to apply a position to a
        // servo.  For this we will use button a and b.  Button "a" will set the position to 1.0
        // and button "b" will set the position to 0.0.

        currStateB = gamepad1.b;
        if (currStateB) setServoPosition(1.0);


//        if (currStateB && currStateB != prevStateB) {
//
//           setServoPosition(1.0);
//            prevStateB = currStateB;
//        }
//        else if (!currStateB && currStateB != prevStateB) {
//
//            prevStateB = currStateB;
//        }

        currStateX = gamepad1.x;
        if (currStateX) setServoPosition(0.0);
//        if (currStateX && currStateX != prevStateX) {
//
//            setServoPosition(1.0);
//            prevStateX = currStateX;
//        }
//        else if (!currStateX && currStateX != prevStateX) {
//
//            prevStateX = currStateX;
//        }
    }

    /**
     * setMotorPower - sets the motor power
     * @param power - value between -1.0 and 1.0
     */
    public void setMotorPower(double power) {

        // set the power (setPower) for the motor
        thatmotor.setPower(power);

    }

    /**
     * setServoPosition - sets the servo position
     * @param position - the servo position, normally between 0.0 and 1.0 for non-continuous servo
     */
    public void setServoPosition(double position) {

        // set the servo position (setPosition) for the servo
        Smartroboserbo.setPosition(position);
    }


}
