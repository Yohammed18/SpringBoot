package net.example.blog.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record Run(
        @Positive
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @PositiveOrZero
        Integer miles,
        Location location
) {
    //Validate
    public Run{
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed on Must be after Started On.");
        }

        if(title.isEmpty()){
            throw new IllegalArgumentException("You must insert a title.");
        }
    }
}
