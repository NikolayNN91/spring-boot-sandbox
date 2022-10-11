package com.sandbox.config.condition;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Locale;
import java.util.Map;

public class OnOsConditional extends SpringBootCondition implements Condition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnOs.class.getName());
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        return new ConditionOutcome(attributes != null && attributes.get("value").equals(os), "***from conditional handler***");
    }
}
