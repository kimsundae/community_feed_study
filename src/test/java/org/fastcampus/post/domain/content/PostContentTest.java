package org.fastcampus.post.domain.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PostContentTest {
    @Test
    void givenContentLengthIsOk_whenCreated_thenReturnTextContent(){
        //given
        String text = "this is a test";

        //when
        PostContent content = new PostContent(text);

        //then
        assertEquals(text,content.contentText);
    }

    @Test
    void givenContentLengthIsOver_whenCreated_thenThrowError(){
        // given
        String content = "a".repeat(501);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁, 닭, 굵, 삵, 슭"})
    void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord){
        // given
        String content = koreanWord.repeat(501);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @Test
    void givenContentLengthIsUnder_whenCreated_thenThrowError(){
        //given
        String content = "a".repeat(4);

        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentIsEmpty_whenCreated_thenThrowError(String value){
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(value));
    }

    @Test
    void givenContent_whenUpdate_thenReturnUpdatedContent(){
        //given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = "this is an updated test";

        //when
        postContent.updateContent(updatedContent);

        //then
        assertEquals(updatedContent, postContent.getContentText());
    }
    @Test
    void givenContent_whenUpdate_thenUpdateDatetimeInfo(){
        //given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = "this is an updated test";

        //when
        postContent.updateContent(updatedContent);

        //then
        assertTrue(postContent.datetimeInfo.isEdited());
    }
    @Test
    void givenContentLengthIsOver_whenUpdated_thenThrowError(){
        //given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = "a".repeat(501);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(updatedContent));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁, 닭, 굵, 삵, 슭"})
    void givenContentLengthIsOverAndKorean_whenUpdated_thenThrowError(String koreanWord){
        //given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = koreanWord.repeat(501);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(updatedContent));
    }

    @Test
    void givenContentLengthIsUnder_whenUpdated_thenThrowError(){
        //given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = "a".repeat(4);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(updatedContent));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentIsEmpty_whenUpdated_thenThrowError(String value){
        //given
        String content = "this is a test";
        PostContent postContent = new PostContent(content);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(value));
    }

    @Test
    void givenContentIsNull_whenCreated_thenThrowError() {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(null));
    }
}
