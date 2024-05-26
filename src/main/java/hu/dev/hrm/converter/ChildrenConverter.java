package hu.dev.hrm.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.dev.hrm.type.Children;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ChildrenConverter implements AttributeConverter<Children, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Children attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Children convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, Children.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
