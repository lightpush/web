package kr.mjc.gwangmin.web.dao;

import lombok.Data;
import org.owasp.encoder.Encode;

@Data
public class Song {
    int songId;
    String title;
    String sname;
    int userId;
    String name;
    String cdate;
    String udate;

    public String getTitleEncoded() {
        return Encode.forHtml(title);
    }

    public String getSnameEncoded() {
        return Encode.forHtml(sname);
    }
    @Override
    public String toString() {
        return String.format(
                "\nSong{songId=%d, title=%s, sname=%s, userId=%d, name=%s, cdate=%s, udate=%s}",
                songId, title, sname, userId, name, cdate, udate);
    }
}