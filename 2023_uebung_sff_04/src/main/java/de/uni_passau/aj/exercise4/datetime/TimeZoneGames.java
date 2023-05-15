package de.uni_passau.aj.exercise4.datetime;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.LocalTime.MIDNIGHT;

@Slf4j
public class TimeZoneGames {
    public static void main(String[] args) {
        //a)
        LocalDateTime now = LocalDateTime.now();
        int monthNumber = now.getMonthValue();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy HH:mm:ss");
        String startTime1 = now.format(formatter1);
        String startTime2 = now.format(formatter2);
        ZoneId timeZone = ZoneId.systemDefault();
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        log.info("Das Programm wurde gestartet um {}, {} {} {} {} in der Zeitzone {}",now.getDayOfWeek(),  startTime1, Month.of(monthNumber).name() , startTime2, offsetDateTime.getOffset(), timeZone);

        //b) + c)
        LocalDate newYear = LocalDate.of(now.getYear(), 1, 1);
        LocalDate endYear = LocalDate.of(now.getYear(), 12 , 31);
        LocalDateTime newYearDateTime = LocalDateTime.of(newYear, MIDNIGHT);
        LocalDateTime endYearDateTime = LocalDateTime.of(endYear, MIDNIGHT);
        long secondsSinceNewYear = ChronoUnit.SECONDS.between(newYearDateTime, now);
        long secondstoendYear = ChronoUnit.SECONDS.between(now, endYearDateTime);
        log.info("Seit Neujahr sind bereits " + secondsSinceNewYear + " Sekunden vergangen.");
        log.info("Es sind noch " + secondstoendYear + " Sekunden bis zum Ende des Jahres verbleibend.");

        //d)+e)
        //ZonedDateTime start = ZonedDateTime.from(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT));
        //ZonedDateTime end = ZonedDateTime.from(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT.plusMinutes(30)));
        ZoneId.getAvailableZoneIds()
            .stream()
            .filter(d-> LocalDateTime.now(ZoneId.of(d)).isAfter(LocalDateTime.of(LocalDate.now().plusDays(1), MIDNIGHT)))
            .filter(d->LocalDateTime.now(ZoneId.of(d)).isBefore(LocalDateTime.of(LocalDate.now().plusDays(1), MIDNIGHT.plusMinutes(30))))
            .forEach(n->log.info("Die Zeitzone {} hat gerade die Datumsgrenze zu Morgen ueberschritten. Die aktuelle Uhrzeit in der betreffenden Zeitzone ist {}", n,LocalDateTime.now(ZoneId.of(n))));





//            .filter(zone -> {
//                ZonedDateTime zoneTime = ZonedDateTime.now(ZoneId.of(zone));
//                return zoneTime.isAfter(start) && zoneTime.isBefore(end);
//            })
//            .forEach(n -> log.info("Die Zeitzone {} hat gerade die Datumsgrenze zu Morgen ueberschritten.", n));
    }
}


