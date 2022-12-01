/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carModelPackage;

import java.util.Date;

/**
 *
 * @author 
 */
public class Car {
    
    // плотность воздуха
    private double airDensity = 1.29;
    
    // лобовая площадь автомобиля (м*м)
    private double frontalArea = 1557 * 1460;
    
    // вес автомобиля (кг)
    private double weight = 1326;
    
    // мощность автомобиля (КВатт)
    private double power = 126 * 0.725;
    
    // обороты вала в минуту номинальная величина
    private double shaftRevolutions = 5000;
    
    // передаточное число коробки передач
    private double transmissionRatio = 3.27;
    
    // передаточное число главной передачи 
    private double mainGearRatio = 4.27;
    
    // радиус колеса (м)
    private double wheelRadius = 0.5;
    
    // текущая скорость автомобиля
    private double currentSpeed = 0;
    
    // время в пути
    private double tripTime = 0;
    
    // пробег автомобиля
    private double tripDistance = 0;
    
    // дата-время начала движения автомобиля
    private Date startTime = new Date();
    
    // сила тяги автомобиля
    private double thrustForce;
    
    //коэффициент сопротивления воздуху
    private double airResistanceCoefficient;
    
    //коэффициент трения скольжения
    private double slidingFrictionCoefficient;
    
    /**
     *
     * @param hosePower hose powers default - 126 kia cerato
     * @param weight weight in kilograms default - 1326 kia cerato
     * @param airResistanceCoefficient коэффициент сопротивления воздуху
     * @param slidingFrictionCoefficient коэффициент трения покрытия
     */
    public Car(double hosePower, double weight, double airResistanceCoefficient, double slidingFrictionCoefficient) {
        // лобовая площадь автомобиля (влияет на силу сопротивления воздуху)
        this.frontalArea = 1557 * 1460;
        this.weight = weight;
        
        // 1 hp = 735 KWatt
        this.power = hosePower * 0.735;
        this.thrustForce = this.getThrustForse(this.power, this.shaftRevolutions, this.transmissionRatio, this.mainGearRatio, this.wheelRadius);

        this.currentSpeed = 0;
        this.tripDistance = 0;
        this.tripTime = 0;
        this.startTime = new Date();
        this.airResistanceCoefficient = airResistanceCoefficient;
        this.slidingFrictionCoefficient = slidingFrictionCoefficient;
        
    }
    
    private double getThrustForse(double power, double shaftRevolutions, double transmissionRatio, double mainGearRatio, double wheelRadius){
        double transmissionPowerLossCoefficient = 0.9;
        double thrustForce = (transmissionPowerLossCoefficient * ((power * shaftRevolutions) / 9550) * transmissionRatio * mainGearRatio) / wheelRadius;
        this.thrustForce = thrustForce;
        return thrustForce;
    }
    
    public double getThrustValue(){
        return this.thrustForce;
    }
    
    private double getRollingResistanceForce(double roadAngle){
        double g = 9.8;
        double rollingResistanceForce = this.slidingFrictionCoefficient * this.weight * g * Math.cos(roadAngle);
        return rollingResistanceForce;
    }
    
    private double getAirResistanceForce(double speed){
        return this.airResistanceCoefficient * this.frontalArea * this.airDensity * Math.pow(speed, 2) / 2;
    }
    
    public double getSpeed() {
        return this.currentSpeed;
    }
    
    private void updateTripTime(){
        this.tripTime++;
    }
    
    private void updateTripDistance(double boost){
        this.tripDistance = this.tripDistance + boost;
    }
    
    public double getTripTime(){
        return this.tripTime;
    }
    
    public double getTripDistance(){
        return this.tripDistance;
    }
    
    public void tick(){
        // ускорение автомобиля
        double currentBoost = this.thrustForce / this.weight;
        
        // массой воздуха пренебргаем
        // ускорение воздуха
        double airBoost = this.getAirResistanceForce(this.currentSpeed);
        
        // ускорение трения
        double rollingBoost = this.getRollingResistanceForce(0) / this.weight;
        
        double boostWithAllObstacles = currentBoost - airBoost - rollingBoost;
        this.updateTripDistance(boostWithAllObstacles);
        this.updateTripTime();
    }
}
