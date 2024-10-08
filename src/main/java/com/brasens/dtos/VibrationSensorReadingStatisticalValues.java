package com.brasens.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.brasens.Commons.DEFAULT_TIMEZONE;

@Entity
@Table(name="Vibration_Sensor_Reading_Statistical_Values")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VibrationSensorReadingStatisticalValues {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id")
    @JsonIgnore
    private UUID id;

    @Column(name = "crest_factor")
    double crestFactor;

    @Column(name = "k_factor")
    double kFactor;

    @Column(name = "z_score")
    double zScoreMax;

    @Column(name = "zscores_array", columnDefinition = "double precision[]")
    @Type(type = "list-array")
    public List<Double> zScores;

    double rms;
    double peak;

    double mean;
    double mode;
    double median;

    @Column(name = "standard_deviation")
    double standardDeviation;
    double variance;

    @Column(name = "peak_to_peak")
    double peakToPeak;

    double skewness;
    double kurtosis;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
    @Column(name = "added")
    private ZonedDateTime added = ZonedDateTime.now().withZoneSameInstant(DEFAULT_TIMEZONE.toZoneId());

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vibration_sensor_reading_id")
    @JsonIgnore
    private VibrationSensorReading vibrationSensorReading;
}
