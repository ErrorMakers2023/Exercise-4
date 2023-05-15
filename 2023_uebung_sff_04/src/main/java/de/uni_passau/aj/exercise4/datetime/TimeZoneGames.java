package de.uni_passau.aj.exercise4.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
        ZoneId.getAvailableZoneIds()
            .stream()
            .filter(d-> LocalDateTime.now(ZoneId.of(d)).isAfter(LocalDateTime.of(LocalDate.now().plusDays(1), MIDNIGHT)))
            .filter(d->LocalDateTime.now(ZoneId.of(d)).isBefore(LocalDateTime.of(LocalDate.now().plusDays(1), MIDNIGHT.plusMinutes(30))))
            .forEach(n->log.info("Die Zeitzone {} hat gerade die Datumsgrenze zu Morgen ueberschritten. Die aktuelle Uhrzeit in der betreffenden Zeitzone ist {}", n,LocalDateTime.now(ZoneId.of(n))));

    }
}


