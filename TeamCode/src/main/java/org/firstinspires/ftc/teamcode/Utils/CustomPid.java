package org.firstinspires.ftc.teamcode.Utils;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;

public class CustomPid {
    private double kp;
    private double ki;
    private double kd;
    private int targetPosition;
    private int integralSum = 0;
    private long lastTime;
    private int lastError = 0;
    private double powerLimit=1;

    public CustomPid (double _kp, double _ki, double _kd){
        kp = _kp;
        ki = _ki;
        kd = _kd;
        targetPosition = 0;
        lastTime = System.currentTimeMillis();
    }

    public void setTarget (int _targetPosition){
        targetPosition = _targetPosition;
        integralSum = 0;
        lastError = 0;
    }

    public double control(int currentPosition) {
        int err = targetPosition - currentPosition;
        int dt = (int) (System.currentTimeMillis() - lastTime);
        if (Math.abs(err) < 40) {
            integralSum += err;
        }
        int proportional = err;
        int integral = integralSum * dt;
        int derivative = (err - lastError) / dt;
        lastError = err;
        lastTime = System.currentTimeMillis();
        Hardware.telemetry.addData("targetPower", normalizePower(proportional * kp + integral * ki + derivative * kd));
        return normalizePower(proportional * kp + integral * ki + derivative * kd);
    }

    private double normalizePower(double power) {
        if (power > powerLimit) {
            return powerLimit;
        }
        if (power < -powerLimit) {
            return -powerLimit;
        }
        return power;
    }
    public void setPowerLimit(double _powerLimit){
        powerLimit=_powerLimit;
    }
    public void setPIDCoef(double _kp, double _ki, double _kd){
        kp=_kp;
        ki=_ki;
        kd=_kd;
    }
    public double getKp (){
        return kp;
    }
    public double getKi (){
        return ki;
    }
    public double getKd (){
        return kd;
    }
}