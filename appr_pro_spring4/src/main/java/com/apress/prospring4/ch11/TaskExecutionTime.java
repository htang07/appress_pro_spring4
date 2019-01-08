package com.apress.prospring4.ch11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TaskExecutionTime {
	
	private LocalTime targetTime;
	

	private LocalDateTime targetDateTime;
	private Long initialDelay;
	private Long periodInterval;
	private DateTimeFormatter timeFormatter;
	private ChronoUnit intervalUnit;
	private LocalDateTime goalDateTime;
	
	public TaskExecutionTime() {}
	public TaskExecutionTime(String  targetTime, String periodInterval, String intervalUnit) {
		this.targetTime = LocalTime.parse(targetTime, timeFormatter);
		this.targetDateTime = LocalDateTime.of(LocalDate.now(), this.targetTime);
		this.periodInterval = Long.parseLong(periodInterval);
		this.intervalUnit = TaskExecutionTime.selectGivenChronoUnit(intervalUnit);
		this.goalDateTime = targetDateTime.plus(this.periodInterval, this.intervalUnit);
		this.initialDelay = java.sql.Timestamp.valueOf(this.goalDateTime).getTime() - java.sql.Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
	
	public long getInitialDelay() {
		return initialDelay;
	}
	public LocalTime getTargetTime() {
		return targetTime;
	}

	public LocalDateTime getTargetDateTime() {
		return targetDateTime;
	}

	public Long getPeriodInterval() {
		return periodInterval;
	}

	public DateTimeFormatter getTimeFormatter() {
		return timeFormatter;
	}

	public ChronoUnit getIntervalUnit() {
		return intervalUnit;
	}

	public LocalDateTime getGoalDateTime() {
		return goalDateTime;
	}
	
	
	
	public static ChronoUnit selectGivenChronoUnit(String unit) {
		
		switch(unit) {
		case "day":
			return ChronoUnit.DAYS;
		case "hour":
			return ChronoUnit.HOURS;
		case "minute":
			return ChronoUnit.MINUTES;
		case "second":
			return ChronoUnit.SECONDS;
		}
		return null;
	}
	
	
}
