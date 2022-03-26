package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int volume;
    private int numberOfStations = 10;
    private int maxStation = setMaxStation();
    private int minStation = 0;
    private int maxVolume = 100;
    private int minVolume = 0;

    //no args constructor
    public Radio(){}

    //конструктор, позволяющий задать кол-во станций
    public Radio(int numberOfStations) {
        if (numberOfStations <= 0){
            return;
        }
        this.numberOfStations = numberOfStations;
        maxStation = setMaxStation();
    }

    //вычисление максимального номера станций
    private int setMaxStation(){
        return numberOfStations - 1;
    }

    //getter'ы на все поля
    public int getNumberOfStations() {
        return numberOfStations;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getVolume() {
        return volume;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    //setter для уровня громкости для теста
    public void setVolume(int volume) {
        if (volume > maxVolume){
            return;
        }
        if (volume < minVolume){
            return;
        }
        this.volume = volume;
    }

    //setter для номера текущей станции
    public void setCurrentStation(int currentStation) {
        if (currentStation > maxStation){
            return;
        }
        if (currentStation < minStation){
            return;
        }
        this.currentStation = currentStation;
    }

    //методы для переключения станций
    public void nextStation() {
        if (currentStation != maxStation) {
            currentStation = currentStation + 1;
        } else {
            currentStation = minStation;
        }
    }
    public void prevStation() {
        if (currentStation != minStation) {
            currentStation = currentStation - 1;
        } else {
            currentStation = maxStation;
        }
    }

    //методы для увеличения и уменьшения уровня громкости
    public void increaseVolume() {
        if (volume != maxVolume) {
            volume = volume + 1;
        }
    }

    public void decreaseVolume() {
        if (volume != minVolume) {
            volume = volume - 1;
        }
    }
}
