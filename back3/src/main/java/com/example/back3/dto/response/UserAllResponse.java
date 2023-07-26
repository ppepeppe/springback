package com.example.back3.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.model.source.spi.AbstractAttributeKey;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserAllResponse {
//    List<String> Users;
//    List<String> stacks;
//    List<String> equips;
    List<AllResponse> userall;
}
