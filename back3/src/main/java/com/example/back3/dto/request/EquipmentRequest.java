package com.example.back3.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

@Getter
@Setter
@NoArgsConstructor

public class EquipmentRequest {
    private long userId;
}
