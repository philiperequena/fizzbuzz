package com.philiperequena.fizzbuzz.domain.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameResponse {
    
    private List<Integer> numbers;
    private List<String> solution;
    private String shaHash;
    private String treasure;
}
