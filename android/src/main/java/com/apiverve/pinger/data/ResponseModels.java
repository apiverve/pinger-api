// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     DomainandIPPingerData data = Converter.fromJsonString(jsonString);

package com.apiverve.pinger.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static DomainandIPPingerData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DomainandIPPingerData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(DomainandIPPingerData.class);
        writer = mapper.writerFor(DomainandIPPingerData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// DomainandIPPingerData.java

package com.apiverve.pinger.data;

import com.fasterxml.jackson.annotation.*;

public class DomainandIPPingerData {
    private String host;
    private String numericHost;
    private boolean alive;
    private long roundTrips;
    private long packetLoss;
    private double minMS;
    private double avgMS;
    private double maxMS;
    private double stdDev;
    private double[] times;

    @JsonProperty("host")
    public String getHost() { return host; }
    @JsonProperty("host")
    public void setHost(String value) { this.host = value; }

    @JsonProperty("numericHost")
    public String getNumericHost() { return numericHost; }
    @JsonProperty("numericHost")
    public void setNumericHost(String value) { this.numericHost = value; }

    @JsonProperty("alive")
    public boolean getAlive() { return alive; }
    @JsonProperty("alive")
    public void setAlive(boolean value) { this.alive = value; }

    @JsonProperty("roundTrips")
    public long getRoundTrips() { return roundTrips; }
    @JsonProperty("roundTrips")
    public void setRoundTrips(long value) { this.roundTrips = value; }

    @JsonProperty("packetLoss")
    public long getPacketLoss() { return packetLoss; }
    @JsonProperty("packetLoss")
    public void setPacketLoss(long value) { this.packetLoss = value; }

    @JsonProperty("minMS")
    public double getMinMS() { return minMS; }
    @JsonProperty("minMS")
    public void setMinMS(double value) { this.minMS = value; }

    @JsonProperty("avgMS")
    public double getAvgMS() { return avgMS; }
    @JsonProperty("avgMS")
    public void setAvgMS(double value) { this.avgMS = value; }

    @JsonProperty("maxMS")
    public double getMaxMS() { return maxMS; }
    @JsonProperty("maxMS")
    public void setMaxMS(double value) { this.maxMS = value; }

    @JsonProperty("stdDev")
    public double getStdDev() { return stdDev; }
    @JsonProperty("stdDev")
    public void setStdDev(double value) { this.stdDev = value; }

    @JsonProperty("times")
    public double[] getTimes() { return times; }
    @JsonProperty("times")
    public void setTimes(double[] value) { this.times = value; }
}