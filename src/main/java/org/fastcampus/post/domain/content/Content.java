package org.fastcampus.post.domain.content;

import org.fastcampus.post.domain.common.DatetimeInfo;

public abstract class Content {
    protected String contentText;
    final DatetimeInfo datetimeInfo;

    public abstract void checkText(String contentText);

    public Content(String contentText){
        checkText(contentText);
        this.contentText = contentText;
        this.datetimeInfo = new DatetimeInfo();
    }

    public void updateContent(String updateContent){
        checkText(updateContent);
        this.contentText = updateContent;
        this.datetimeInfo.updateEditDatetime();
    }

    public String getContentText(){
        return contentText;
    }
}
