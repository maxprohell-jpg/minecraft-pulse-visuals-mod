package com.pulsev.config;

public class PulseConfig {
    private float effectIntensity;

    public PulseConfig() {
        this.effectIntensity = 1.0f; // Default intensity
    }

    public float getEffectIntensity() {
        return effectIntensity;
    }

    public void setEffectIntensity(float effectIntensity) {
        this.effectIntensity = effectIntensity;
    }
}