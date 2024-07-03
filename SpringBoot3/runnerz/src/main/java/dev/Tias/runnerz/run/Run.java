package dev.Tias.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        @NotNull
        LocalDateTime startedOn,
        @NotNull
        LocalDateTime endedOn,
        @Positive
        Integer miles,
        Location location
) {
        public Run {
                if (startedOn == null || endedOn == null) {
                        throw new IllegalArgumentException("Start time and end time cannot be null");
                }
                if (startedOn.isAfter(endedOn)) {
                        throw new IllegalArgumentException("Run cannot end before it starts");
                }
        }
}
