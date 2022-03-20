package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(value={
            "StationBelowLowerRangeLimit, -1, 0",
            "StationIsLowerRangeLimit, 0, 0",
            "StationOverLowerRangeLimit, 1, 1",
            "StationBelowUpperRangeLimit, 8, 8",
            "StationIsUpperRangeLimit, 9, 9",
            "StationOverUpperRangeLimit, 10, 0"})
    void shouldSetCurrentStation(String testName, int station, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(station);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value={
            "StationIsLowerRangeLimit, 0, 1",
            "StationOverLowerRangeLimit, 1, 2",
            "StationBelowUpperRangeLimit, 8, 9",
            "StationIsUpperRangeLimit, 9, 0"})
    void shouldNextStation(String testName, int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value={
            "StationIsLowerRangeLimit, 0, 9",
            "StationOverLowerRangeLimit, 1, 0",
            "StationBelowUpperRangeLimit, 8, 7",
            "StationIsUpperRangeLimit, 9, 8"})
    void shouldPrevStation(String testName, int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value={
            "VolumeBelowLowerRangeLimit, -1, 0",
            "VolumeIsLowerRangeLimit, 0, 0",
            "VolumeOverLowerRangeLimit, 1, 1",
            "VolumeBelowUpperRangeLimit, 9, 9",
            "VolumeIsUpperRangeLimit, 10, 10",
            "VolumeOverUpperRangeLimit, 11, 0"})
    void shouldSetVolume(String testName, int volume, int expected) {
        Radio radio = new Radio();
        radio.setVolume(volume);
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value={
            "VolumeIsLowerRangeLimit, 0, 1",
            "VolumeOverLowerRangeLimit, 1, 2",
            "VolumeBelowUpperRangeLimit, 9, 10",
            "VolumeIsUpperRangeLimit, 10, 10"})
    void shouldIncreaseVolume(String testName, int volume, int expected) {
        Radio radio = new Radio();
        radio.setVolume(volume);
        radio.increaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value={
            "VolumeIsLowerRangeLimit, 0, 0",
            "VolumeOverLowerRangeLimit, 1, 0",
            "VolumeBelowUpperRangeLimit, 9, 8",
            "VolumeIsUpperRangeLimit, 10, 9"})
    void shouldDecreaseVolume(String testName, int volume, int expected) {
        Radio radio = new Radio();
        radio.setVolume(volume);
        radio.decreaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }
}