package org.fastcampus.post.domain.common;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DatetimeInfo {

    private boolean isEdited;
    private LocalDateTime datetime;

    public DatetimeInfo(){
        this.isEdited = false;
        this.datetime = LocalDateTime.now();
    }

    public void updateEditDatetime(){
        this.isEdited = true;
        this.datetime = LocalDateTime.now();
    }

    public boolean isEdited(){
        return this.isEdited;
    }

    public LocalDateTime getDatetime(){
        return this.datetime;
    }
}
