package com.example.eventsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class EventSystem {

    private String id;
    private String description;
    private int capacity;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime startDate = LocalDateTime.now();
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime endDate = LocalDateTime.now();
}
