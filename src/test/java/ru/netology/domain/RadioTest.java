package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource(value = {
            "StationBelowLowerRangeLimit, -1, 0",
            "StationIsLowerRangeLimit, 0, 0",
            "StationOverLowerRangeLimit, 1, 1",
            "StationBelowUpperRangeLimit, 8, 8",
            "StationIsUpperRangeLimit, 9, 9",
            "StationOverUpperRangeLimit, 10, 0"})
    void shouldSetCurrentStation(String testName, int station, int expected) {
        radio.setCurrentStation(station);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "StationIsLowerRangeLimit, 0, 1",
            "StationOverLowerRangeLimit, 1, 2",
            "StationBelowUpperRangeLimit, 8, 9",
            "StationIsUpperRangeLimit, 9, 0"})
    void shouldNextStation(String testName, int currentStation, int expected) {
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "StationIsLowerRangeLimit, 0, 9",
            "StationOverLowerRangeLimit, 1, 0",
            "StationBelowUpperRangeLimit, 8, 7",
            "StationIsUpperRangeLimit, 9, 8"})
    void shouldPrevStation(String testName, int currentStation, int expected) {
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "VolumeBelowLowerRangeLimit, -1, 0",
            "VolumeIsLowerRangeLimit, 0, 0",
            "VolumeOverLowerRangeLimit, 1, 1",
            "VolumeBelowUpperRangeLimit, 99, 99",
            "VolumeIsUpperRangeLimit, 100, 100",
            "VolumeOverUpperRangeLimit, 101, 0"})
    void shouldSetVolume(String testName, int volume, int expected) {
        radio.setVolume(volume);
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "VolumeIsLowerRangeLimit, 0, 1",
            "VolumeOverLowerRangeLimit, 1, 2",
            "VolumeBelowUpperRangeLimit, 99, 100",
            "VolumeIsUpperRangeLimit, 100, 100"})
    void shouldIncreaseVolume(String testName, int volume, int expected) {
        radio.setVolume(volume);
        radio.increaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "VolumeIsLowerRangeLimit, 0, 0",
            "VolumeOverLowerRangeLimit, 1, 0",
            "VolumeBelowUpperRangeLimit, 99, 98",
            "VolumeIsUpperRangeLimit, 100, 99"})
    void shouldDecreaseVolume(String testName, int volume, int expected) {
        radio.setVolume(volume);
        radio.decreaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "NumberOfStationsBelowLowerRangeLimit, 0, 10",
            "NumberOfStationsIsLowerRangeLimit, 1, 1",
            "NumberOfStationsOverLowerRangeLimit, 2, 2",
            "NumberOfStationsIsRandom, 100, 100",
            "NumberOfStationsIsNegative, -5, 10"})
    void shouldCreateWithNumberOfStations (String testName, int numberOfStations, int expected){
        Radio radio1 = new Radio(numberOfStations);
        int actual = radio1.getNumberOfStations();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "NumberOfStationsBelowLowerRangeLimit, 0, 9",
            "NumberOfStationsIsLowerRangeLimit, 1, 0",
            "NumberOfStationsOverLowerRangeLimit, 2, 1",
            "NumberOfStationsIsRandom, 100, 99",
            "NumberOfStationsIsNegative, -5, 9"})
    void shouldSetMaxStation (String testName, int numberOfStations, int expected){
        Radio radio1 = new Radio(numberOfStations);
        int actual = radio1.getMaxStation();
        assertEquals(expected, actual);

    }
}