package com.philiperequena.fizzbuzz.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.common.hash.Hashing;
import com.philiperequena.fizzbuzz.client.JurosBaixoClient;
import com.philiperequena.fizzbuzz.domain.response.GameResponse;
import com.philiperequena.fizzbuzz.utils.FizzBuzzResolver;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.minidev.json.JSONArray;

@AllArgsConstructor
@Service
public class GameService {

    private JurosBaixoClient jurosBaixoClient;

    // TODO add Comments
    public GameResponse playTheGame() {
        List<Integer> numbers = jurosBaixoClient.getFizzBuzz();

        List<String> solution = FizzBuzzResolver.solveProblem(numbers);

        String sha256hex = generateHash(solution);

        jurosBaixoClient.postFizzBuzz(sha256hex, solution);

        String treasure = jurosBaixoClient.canIHasTreasure(sha256hex).getTreasure();

        jurosBaixoClient.delete(sha256hex);

        return GameResponse.builder().numbers(numbers).solution(solution).shaHash(sha256hex).treasure(treasure).build();
    }

    private String generateHash(List<String> solution) {
        JSONArray jsArray = new JSONArray();
        jsArray.addAll(solution);
        return Hashing.sha256()
                .hashString(jsArray.toJSONString(), StandardCharsets.UTF_8)
                .toString();
    }
}
