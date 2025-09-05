package org.fastcampus.common.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PageableTest {

    @Test
    void givenPageableIndexIsNull_whenGetOffset_thenShouldBeReturn0(){
        Pageable pageable = new Pageable();

        int offset = pageable.getOffset();
        int limit = pageable.getLimit();

        Assertions.assertEquals(0, offset);
        Assertions.assertEquals(10, limit);
    }

    @Test
    void givenPageableIndexIs2Size10_whenGetOffset_thenShouldBeReturn10(){
        Pageable pageable = new Pageable(2, 10);

        int offset = pageable.getOffset();
        int limit = pageable.getLimit();

        Assertions.assertEquals(10, offset);
        Assertions.assertEquals(10, limit);
    }
}
