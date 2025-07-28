package org.fastcampus.post.domain.common;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatetimeInfoTest {

    @Test
    void givenCreated_whenUpdated_thenTimeAndStateArsUpdated(){
        //given
        DatetimeInfo dateTimeInfo = new DatetimeInfo();
        LocalDateTime localDateTime = dateTimeInfo.getDatetime();

        //when
        dateTimeInfo.updateEditDatetime();

        //then
        assertTrue(dateTimeInfo.isEdited());
        assertNotEquals(localDateTime, dateTimeInfo.getDatetime());
    }
}
