package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int volume;
    private int maxStation = 9;
    private int minStation = 0;
    private int maxVolume = 10;
    private int minVolume = 0;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > maxStation){
            return;
        }
        if (currentStation < minStation){
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStation() {
        if (currentStation != 9) {
            currentStation = currentStation + 1;
        } else {
            currentStation = 0;
        }
    }
    public void prevStation() {
        if (currentStation != 0) {
            currentStation = currentStation - 1;
        } else {
            currentStation = 9;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume > maxVolume){
            return;
        }
        if (volume < minVolume){
            return;
        }
        this.volume = volume;
    }
    public void increaseVolume() {
        if (volume != 10) {
            volume = volume + 1;
        }
    }
    public void decreaseVolume() {
        if (volume != 0) {
            volume = volume - 1;
        }
    }
}
