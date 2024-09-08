package com.brasens.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.brasens.Commons.DEFAULT_TIMEZONE;

@Entity
@Table(name="Distribution")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Distribution extends Reading {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vibration_sensor_reading_id")
    @JsonIgnore
    private VibrationSensorReading vibrationSensorReading;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
    @Column(name = "added")
    private ZonedDateTime added = ZonedDateTime.now().withZoneSameInstant(DEFAULT_TIMEZONE.toZoneId());
}
