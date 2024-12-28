package com.example.testRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private int id;

    private String name;

    private String description;

    private LocalDateTime dateCreate;

    private LocalDateTime dateUpdate;

    private String status;
}
