/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carModelPackage;

import java.util.Date;

/**
 *
 * @author mvideo
 */
public class Car {
    
    private double weight;
    private double power;
    private double maxSpeed;
    private double maxBoost;
    private double speed;
    private double tripTime;
    private double tripDistance;
    private Date startTime;
    /**
     *
     * @param hosePower hose powers
     * @param weight weight in kilograms
     */
    public Car(double hosePower, double weight) {
        // 1 hp = 735 Watt
        this.weight = weight;
        this.power = hosePower * 735;
        // примерная максимальная скорость автомобиля,
        // может отличаться от реальных показателей на 10%
        this.maxSpeed = Math.cbrt(hosePower)*25*1.60934;
        this.maxBoost = Math.sqrt(hosePower/weight);
        this.speed = 0;
        this.tripDistance = 0;
        this.tripTime = 0;
        this.startTime = new Date();
        
    }
    
    
    
    
    
    
    
    public double getSpeed() {
        return this.speed;
    }
    
    public void updateTripTime(){
        this.tripTime++;
    }
    
    public void updateTripDistance(double boost){
        this.tripDistance = this.tripDistance + boost;
    }
    
    public 
    
    
}
