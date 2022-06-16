package com.company;

public class Main {

    //Необходимо создать класс, работающий с напряжением 380 вольт и создать класс работающий с зарядным устройством 220 вольт.
    // Создать класс адаптер, который позволит заряжать телефон зарядным устройством 220 вольт через напряжение в 380 вольт.

    public static void main(String[] args) {
        Chrager ch = new Chrager();
        W380charger W380charger = new W380charger();
        PowerAdapter pa = new PowerAdapter(W380charger);

        ch.charging();

        pa.charging();
    }
}
class W380charger{
    void charging(){
        System.out.println("Заряжаю 380 вольт");
    }
}
interface W220{
    void charging();
}
class Chrager implements W220{
    @Override
    public void charging() {
        System.out.println("Заряжаю 220 вольт");
    }
}
class PowerAdapter implements W220 {
    private W380charger W380charger;

    public PowerAdapter(W380charger W380charger){
        this.W380charger = W380charger;
    }
    @Override
    public void charging() {
        W380charger.charging();
    }
}