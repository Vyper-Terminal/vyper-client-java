package com.vyper.sdk.models;

public class MigrationState {
    private int durationMinutes;
    private int makers;
    private long migrationTimestamp;
    private double volume;

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public int getMakers() { return makers; }
    public void setMakers(int makers) { this.makers = makers; }
    public long getMigrationTimestamp() { return migrationTimestamp; }
    public void setMigrationTimestamp(long migrationTimestamp) { this.migrationTimestamp = migrationTimestamp; }
    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }
}