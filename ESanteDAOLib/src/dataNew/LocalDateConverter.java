/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataNew;

/**
 *
 * @author darkman
 */
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        Instant instant = Instant.from(date);
        return Date.from(instant);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        Instant instant = value.toInstant();
        return LocalDate.from(instant);
    }
}
