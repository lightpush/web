package kr.mjc.gwangmin.web.dao;

import lombok.Data;
import org.owasp.encoder.Encode;

@Data
public class Movie {
    int movieId;
    String title;
    String director;

    public String getTitleEncoded() {
        return Encode.forHtml(title);
    }

    public String getDirectorEncoded() {
        return Encode.forHtml(director);
    }

    /**
     * new line을 <br> 태그로 변환
     */
    public String getDirectorHtml() {
        return Encode.forHtml(director).replace("\n", "</br>\n");
    }
    @Override
    public String toString() {
        return String.format(
                "\nMovie{movieId=%d, title=%s, director=%s}",
                movieId, title, director);
    }
}