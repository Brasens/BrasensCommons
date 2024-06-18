package com.brasens.dtos;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.brasens.dtos.enums.AssetState;
import com.brasens.dtos.enums.DowntimeType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;

import static com.brasens.Commons.DEFAULT_TIMEZONE;

@Entity
@Table(name="Asset")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id")
	@JsonIgnore
	private UUID id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "asset_key", unique = true)
	private String key;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
	@Column(name = "last_communication", nullable = false)
	private ZonedDateTime lastCommunication = ZonedDateTime.now(DEFAULT_TIMEZONE.toZoneId());

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", timezone = "UTC")
	@Column(name = "added", insertable = false, updatable = false)
	private ZonedDateTime added;

	@OneToMany(targetEntity = Events.class, mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Events> events = new ArrayList<>();

	@OneToMany(targetEntity = MachineIntervals.class, mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<MachineIntervals> machineIntervals = new ArrayList<>();

	@OneToMany(targetEntity = Data.class, mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Data> dataList = new ArrayList<>();

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private FFT fftAcceleration_X;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private FFT fftAcceleration_Y;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private FFT fftAcceleration_Z;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private FFT fftSpeed_X;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private FFT fftSpeed_Y;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private FFT fftSpeed_Z;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private Downtime downtime;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private VibrationSensorReading sensorReading_X;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private VibrationSensorReading sensorReading_Y;

	@OneToOne(mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private VibrationSensorReading sensorReading_Z;

	@OneToMany(targetEntity = Alert.class, mappedBy = "Asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Alert> alerts = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;
}