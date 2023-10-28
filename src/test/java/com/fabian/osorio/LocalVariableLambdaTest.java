package com.fabian.osorio;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
public class LocalVariableLambdaTest {

    @Test
    void varInLambdas() {
        Optional<Integer> optNumber1 = Optional.of(3);
        Optional<Integer> optNumber2 = Optional.of(3);

        BiFunction<Integer, Integer, Integer> add = (var x, var y ) -> x + y;

        var result = optNumber1.flatMap(n1 -> optNumber2.map( n2 -> add.apply(n1, n2)));

        assertTrue(result.isPresent());
    }

}
