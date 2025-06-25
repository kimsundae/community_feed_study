package org.fastcampus.common.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PositiveIntegerCounterTest {
    @Test
    void givenCreated_whenIncrease_thenCountIsOne(){
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        //when
        counter.increase();
        //then
        assertEquals(1, counter.getCount());
    }
}
