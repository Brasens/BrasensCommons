package com.brasens.dtos;

import com.brasens.dtos.Asset;
import com.brasens.dtos.Downtime;
import com.brasens.dtos.FFT;
import com.brasens.dtos.VibrationSensorReading;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name="History")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id")
    @JsonIgnore
    private UUID id;

    @Column(name = "asset_key")
    private String key;

    private double rms_acc_peak_x;
    private double rms_acc_peakpeak_x;
    private double rms_acc_peak_y;
    private double rms_acc_peakpeak_y;
    private double rms_acc_peak_z;
    private double rms_acc_peakpeak_z;

    private double rms_speed_peak_x;
    private double rms_speed_peakpeak_x;
    private double rms_speed_peak_y;
    private double rms_speed_peakpeak_y;
    private double rms_speed_peak_z;
    private double rms_speed_peakpeak_z;

    private double temperature_mean;
    private double temperature_peak;

    private double waveform_rms;
    private double waveform_peak;
    private double waveform_peakpeak;
    private double waveform_skewness;
    private double waveform_kurtosis;
    private double waveform_crest;
    private double waveform_k_factor;
    private double waveform_standard_deviation;
    private double waveform_variance;

    private double fft_acc_rms;
    private double fft_acc_peak;
    private double fft_acc_peakpeak;
    private double fft_acc_skewness;
    private double fft_acc_kurtosis;
    private double fft_acc_variance;

    private double fft_speed_rms;
    private double fft_speed_peak;
    private double fft_speed_peakpeak;
    private double fft_speed_skewness;
    private double fft_speed_kurtosis;
    private double fft_speed_variance;
    private double fft_speed_standard_deviation;

    private double downtime;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;
}
