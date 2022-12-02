/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carModelPackage;


/**
 *
 * @author 
 */
public class Car {
    
    // плотность воздуха (Н*с^2/м*кг)
    private final double airDensity;
    
    // лобовая площадь автомобиля (м^2)
    private final double frontalArea;
    
    // вес автомобиля (кг)
    private final double weight;
    
    // мощность автомобиля (КВатт)
    private final double power;
    
    // обороты вала в минуту номинальная величина
    private final double shaftRevolutions;
    
    // передаточное число коробки передач
    private final double transmissionRatio;
    
    // передаточное число главной передачи 
    private final double mainGearRatio;
    
    // радиус колеса (м)
    private final double wheelRadius;
    
    // текущая скорость автомобиля (м/с)
    private double currentSpeed = 0;
    
    // max speed
    private double maxSpeed = 0;
    
    // время в пути (с)
    private double tripTime = 0;
    
    private double configTime = 0;
    
    // пробег автомобиля (м)
    private double tripDistance = 0;
    
    // параметры пробега для корректной работы спидометра
    private double currDist;
    
    // сила тяги автомобиля
    private final double thrustForce;
    
    // коэффициент сопротивления воздуху
    private final double airResistanceCoefficient;
    
    // сила сопротивления воздуху
    private double airResistanceForce;
    
    // коэффициент трения скольжения
    private final double slidingFrictionCoefficient;
    
    // сила трения скольжения
    private double rollingResistanceForce;
    
    /**
     *
     * @param hosePower hose powers default - 126 kia cerato
     * @param weight weight in kilograms default - 1326 kia cerato
     * @param airResistanceCoefficient коэффициент сопротивления воздуху
     * @param slidingFrictionCoefficient коэффициент трения покрытия
     */
    public Car(double hosePower, double weight, double airResistanceCoefficient, double slidingFrictionCoefficient) {
        // -- статические показатели для расчета силы трения --
            //коэффициент трения скольжения
            this.slidingFrictionCoefficient = slidingFrictionCoefficient;
            // масса автомобиля
            this.weight = weight;
            
        // -- статические показатели для расчета силы сопротивления воздуху --
            // плотность воздуха (Н*с^2/м*кг)
            this.airDensity = 1.29;
            // лобовая площадь автомобиля (м) (влияет на силу сопротивления воздуху)
            this.frontalArea = 1.557 * 1.460;
            // коэффициент сопротивления воздуху
            this.airResistanceCoefficient = airResistanceCoefficient;
            // скорость автомобиля
            this.currentSpeed = 0;
        
        // -- статические показатели для расчета силы тяги --
            // мощность 1 hp = 735 KWatt
            this.power = hosePower * 0.735;
            // обороты вала в минуту номинальная величина
            this.shaftRevolutions = 7000;
            // передаточное число коробки передач
            this.transmissionRatio = 3.27;
            // передаточное число главной передачи 
            this.mainGearRatio = 4.27;
            // радиус колеса (м)
            this.wheelRadius = 0.5;
            // сила тяги
            this.thrustForce = this.getThrustForse();
        
        this.maxSpeed = 25 * Math.cbrt(hosePower) * 1.60934;
        this.currDist = 0;
        this.tripDistance = 0;
        this.tripTime = 0;
        
    }
    
    private double getThrustForse(){
        double transmissionPowerLossCoefficient = 0.92;
        return (transmissionPowerLossCoefficient * ((this.power * 9550) / this.shaftRevolutions) * this.transmissionRatio * this.mainGearRatio) / this.wheelRadius;
    }
    
    public double getMaxSpeed(){
        return this.maxSpeed;
    }
    
    public double getThrustForseValue(){
        return this.thrustForce;
    }
    
    private double getRollingResistanceForce(double roadAngle){
        double g = 9.8;
        this.rollingResistanceForce = this.slidingFrictionCoefficient * this.weight * g * Math.cos(roadAngle);
        return this.rollingResistanceForce;
    }
    
    public double getRollingResistanceForseValue(){
        return this.rollingResistanceForce;
    }
    
    /**
     *
     * @param speed скорость в м/с
     */
    private double getAirResistanceForce(double speed){
        this.airResistanceForce = this.airResistanceCoefficient * this.frontalArea * this.airDensity * Math.pow(speed, 2) / 2;
        return this.airResistanceForce;
    }
    
    public double getAirResistanceForceValue(){
        return this.airResistanceForce;
    }
    
    private void updateSpeed(double prevDist, double currDist){
        // скорость положительная
        if (prevDist < currDist){
            this.currentSpeed = currDist - prevDist;
            return;
        }
        // скорость отрицательная
        if (prevDist > currDist){
            this.currentSpeed = this.currentSpeed - (prevDist - currDist);
            // остановились
            if(this.currentSpeed < 0){
                this.currentSpeed = 0;
            }
        }
        // скорость не меняется
    }
    
    public double getSpeed() {
        return this.currentSpeed;
    }
    
    public double getSpeedInKmh(){
        return this.currentSpeed * 3.6;
    }
    
    private void updateTripTime(double multParametr){
        this.tripTime = this.tripTime + multParametr;
    }
    
    private void updateTripDistance(double boostPerSec){
        if (boostPerSec > 0) {
            if (this.configTime == 0){
                this.configTime = this.currentSpeed / boostPerSec;    
            }
            this.configTime++;
            boostPerSec = boostPerSec * this.configTime;
            this.tripDistance = this.tripDistance + boostPerSec;
        } else {
            this.configTime = 0;
        }
        
        double prevDist = this.currDist;
        this.currDist = this.currDist + boostPerSec;
        
        // -- DEBUG --
        System.out.println("prevDist: " + String.valueOf(prevDist) + " currDist: " + String.valueOf(this.currDist));
        System.out.println("triptime: " + String.valueOf(this.configTime));

        if (this.currDist > 0){
            this.updateSpeed(prevDist, this.currDist);
        } else {
            this.currDist = 0;
        }
        
    }
    
    public double getTripTime(){
        return this.tripTime;
    }
    
    public double getTripDistance(){
        return this.tripDistance;
    }
    
    public double getTripDistanceInKm(){
        return this.tripDistance / 1000;
    }
    
    public void tick(double multParament, boolean gasOn, boolean brakeOn){
        // ускорение автомобиля
        double currentBoost = gasOn ? this.thrustForce / this.weight : 0;
        // ускорение торможение
        // сила торможения в данном случае равна 8000 Ньютонов
        double brakeBoost = brakeOn ? 8000 / this.weight : 0;
        // ускорение сопротивления воздуха
        double airBoost = this.getAirResistanceForce(this.currentSpeed) / this.weight;
        
        // -- DEBUG --
        // вывод в консоль параметров speed: -- trip: -- time: --
        //System.out.println("speed:" + String.valueOf(this.currentSpeed) + "m/s " + "trip:" + String.valueOf(this.tripDistance) + " time:" + String.valueOf(this.tripTime) + " s");

        // ускорение сопротивления трения
        double rollingBoost = this.getRollingResistanceForce(0) / this.weight;
        
        // ускорение с учетом всех сопротивлений
        double boostWithAllObstacles = currentBoost - airBoost - rollingBoost - brakeBoost;
        
        // -- DEBUG --
        // вывод в консоль ускорения
        System.out.println(String.valueOf(boostWithAllObstacles));
        
        this.updateTripDistance(boostWithAllObstacles * multParament);
        this.updateTripTime(multParament);
    }
}
