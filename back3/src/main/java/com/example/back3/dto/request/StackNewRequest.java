package com.example.back3.dto.request;

import com.example.back3.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StackNewRequest {
    String stackNm;
    long userIdFk;
}
