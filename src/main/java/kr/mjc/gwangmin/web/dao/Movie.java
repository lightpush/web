package kr.mjc.gwangmin.web.dao;

import lombok.Data;
import org.owasp.encoder.Encode;

@Data
public class Movie {
    int movieId;
    String title;
    int userId;

    String director;
    String name;
    String cdate;
    String udate;

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
                "\nMovie{movieId=%d, title=%s, director=%s, userId=%d, name=%s, cdate=%s, udate=%s}",
                movieId, title, director, userId, name, cdate, udate);
    }
}