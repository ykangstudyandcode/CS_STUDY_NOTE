import java.util.Scanner;
import java.util.ArrayList;
abstract class SmartDevice{
    private int id;
    private String brand;
    private boolean PowerStatus;

    
    // Getters and setters
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public boolean isPowerStatus() {
        return PowerStatus;
    }

    public void setPowerStatus(boolean powerStatus){
        this.PowerStatus = powerStatus;
    }
    public void turnOn() {
        if (isPowerStatus()) {
            System.out.println(getBrand() + " device is already on.");
        }else {
            setPowerStatus(true);
            System.out.println(getBrand() + " device is now on.");
        }
    }

    public void turnOff() {
        if (!isPowerStatus()) {
            System.out.println(getBrand() + " device is already off.");
        }else {
            setPowerStatus(false);
            System.out.println(getBrand() + " device is now off.");
        }
   }
    public abstract void performMainFunction();
    public void printDeviceDetails(){
        System.out.println("ID: " + getId());
        System.out.println("Brand: " + getBrand());
        System.out.println("Power Status: " + isPowerStatus());
    }
}

interface Recordable{
    void startRecording();
    void stopRecording();
}

interface Rechargeable{
    void recharge();
}

interface Adjustable{
    void increaseLevel();
    void decreaseLevel();
}

class Smartlight extends SmartDevice implements Adjustable{
    private int Brightness;

    public int getBrightness(){
        return Brightness;
    }
    public void setBrightness(int brightness){
        this.Brightness = brightness;
    }
    
    @Override
    public void increaseLevel(){
        Scanner LightLevel = new Scanner(System.in);
        System.out.println("How Bright you want");
        int brighslevel = LightLevel.nextInt();
        setBrightness(brighslevel);
    }

    @Override
    public void decreaseLevel(){
        Scanner LightLevel = new Scanner(System.in);
        System.out.println("How dim you want");
        int dimlevel = LightLevel.nextInt();
        setBrightness(dimlevel);
    }

    public void performMainFunction() {
        this.increaseLevel();
        System.out.println("The smart light is now on.");
    }
    

}

class SmartSpeaker extends SmartDevice implements Adjustable{
    private int Volume;
    private String CurrentName;

    public int getVolume(){
        return Volume;
    }

    public void setVolume(int volume){
        this.Volume = volume;
    }

    public String getCurrentName(){
        return CurrentName;
    }

    public void setCurrentName(String currentName){
        this.CurrentName = currentName;
    }

    @Override
    public void increaseLevel(){
        Scanner volumeLevel = new Scanner(System.in);
        System.out.println("How loud you want");
        int Volumelevel = volumeLevel.nextInt();
        setVolume(Volumelevel);
    }

    @Override
    public void decreaseLevel(){
        Scanner volumeLevel = new Scanner(System.in);
        System.out.println("How quiet you want");
        int Volumelevel = volumeLevel.nextInt();
        setVolume(Volumelevel);
    }

    public void performMainFunction() {
        this.increaseLevel();
        System.out.println("The smart speaker is now on.");
    }
    

   
}

class SecurityCamera extends SmartDevice implements Recordable{
    private boolean recording;

    public boolean isRecording(){
        return recording;
    }

    public void setRecording(boolean recording){
        this.recording = recording;
    }

    public void startRecording() {
        if (isRecording()) {
            System.out.println(getBrand() + " device is already recording.");
        }else {
            setRecording(true);
            System.out.println(getBrand() + " device has started recording.");
        }
    }

    public void stopRecording(){
        if(!isRecording()){
            System.out.println(getBrand() + " device is not recording.");
        }else{
            setRecording(false);
            System.out.println(getBrand() + " device has stopped recording.");
        }
    }

    @Override   
    public void turnOn() {
        if (isPowerStatus()) {
            System.out.println(getBrand() + " device is already on.");
        }else {
            setPowerStatus(true);
            setRecording(true);
            System.out.println(getBrand() + " device is now on.");
            System.out.println(getBrand() + " device is now recording.");
        }
    }
    @Override
    public void turnOff() {
        if (!isPowerStatus()) {
            System.out.println(getBrand() + " device is already off.");
        }else {
            setPowerStatus(false);
            setRecording(false);
            System.out.println(getBrand() + " device is now off.");
            System.out.println(getBrand() + " device has stopped recording.");
        }
   }
   public void performMainFunction() {
        this.turnOn();
        System.out.println("The security camera is now on and recording.");
    }
}

class RobotVacuum extends SmartDevice implements Rechargeable{
    private int batteryLevel;

    public int getBatteryLevel(){
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void recharge(){
        Scanner Battery = new Scanner(System.in);
        System.out.println("How loud you want");
        int BatteryLevel = Battery.nextInt();
        setBatteryLevel(BatteryLevel);
    }

    public void performMainFunction() {
        this.recharge();
        System.out.println("The robot vacuum is now recharging.");
    }
        
}

class Manager{
    private ArrayList<SmartDevice> devices;

    public Manager(){
        devices = new ArrayList<>();
    }

    public SmartDevice findDevice(int id){
        for(int i = 0; i < devices.size();i++){
            if(devices.get(i).getId()==id){
                return devices.get(i);
            }
        }
        return null;
    }

    public void addDevice(SmartDevice device){
        devices.add(device);
    }

    public SmartDevice removeDevice(int id){
        SmartDevice device = findDevice(id);
        if(device != null){
            devices.remove(device);
            return device;
        }else{
            System.out.println("Device not found.");
            return null;
        }
    }

    public void listDevices(){
        for(SmartDevice device : devices){
            device.printDeviceDetails();
        }
    }    

    public SmartDevice performDeviceFunction(int id){
        SmartDevice device = findDevice(id);
        if(device != null){
            device.performMainFunction();
            return device;
        }else{
            System.out.println("Device not found.");
            return null;
        }
    }
    
}

public class Smart {
    public static void main(String[] args) {
        Smartlight light = new Smartlight();
        light.setId(1);
        light.setBrand("Philips");
        light.setPowerStatus(false);

        SmartSpeaker speaker = new SmartSpeaker();
        speaker.setId(2);
        speaker.setBrand("Bose");
        speaker.setPowerStatus(false);

        SecurityCamera camera = new SecurityCamera();
        camera.setId(3);
        camera.setBrand("Nest");
        camera.setPowerStatus(false);

        RobotVacuum vacuum = new RobotVacuum();
        vacuum.setId(4);
        vacuum.setBrand("Roomba");
        vacuum.setPowerStatus(false);

        Manager manager = new Manager();
        manager.addDevice(light);
        manager.addDevice(speaker);
        manager.addDevice(camera);
        manager.addDevice(vacuum);

        manager.listDevices();
        manager.performDeviceFunction(1);
        manager.performDeviceFunction(2);
        manager.performDeviceFunction(3);
        manager.performDeviceFunction(4);
    }
}
