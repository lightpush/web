package kr.mjc.gwangmin.web.dao;

import lombok.Data;
import org.owasp.encoder.Encode;

@Data
public class Song {
    int songId;
    String title;
    String name;

    public String getTitleEncoded() {
        return Encode.forHtml(title);
    }

    public String getnameEncoded() {
        return Encode.forHtml(name);
    }
    @Override
    public String toString() {
        return String.format(
                "\nSong{songId=%d, title=%s, name=%s}",
                songId, title, name);
    }
}