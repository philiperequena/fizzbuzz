package com.philiperequena.fizzbuzz.client;

import java.util.List;

import com.philiperequena.fizzbuzz.domain.dto.TreasureDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "juros-baixo-testcode", url = "${app.jurosbaixo.fizzbuzz.url}", configuration = JurosBaixoClientConfiguration.class)
public interface JurosBaixoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/fizzbuzz")
    List<Integer> getFizzBuzz();

    @RequestMapping(method = RequestMethod.POST, value = "/fizzbuzz/{shaHash}")
    void postFizzBuzz(@PathVariable String shaHash, @RequestBody List<String> listResult);

    @RequestMapping(method = RequestMethod.GET, value = "/fizzbuzz/{shaHash}/canihastreasure")
    TreasureDto canIHasTreasure(@PathVariable String shaHash);

    @RequestMapping(method = RequestMethod.DELETE, value = "/fizzbuzz/{shaHash}")
    void delete(@PathVariable String shaHash);
}
