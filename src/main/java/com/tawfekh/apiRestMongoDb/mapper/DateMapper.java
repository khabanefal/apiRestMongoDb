package com.tawfekh.apiRestMongoDb.mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class DateMapper {
    public OffsetDateTime mapLocalDateTimeToOffsetDateTime(LocalDateTime localDateTime) {
        return localDateTime.atOffset(OffsetDateTime.now().getOffset());
    }
    public LocalDateTime mapLocalDateTimeToOffsetDateTime(OffsetDateTime offsetDateTime) {
        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
        return  localDateTime;
    }
}
