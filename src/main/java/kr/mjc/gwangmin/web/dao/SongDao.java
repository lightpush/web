package kr.mjc.gwangmin.web.dao;

import kr.mjc.gwangmin.web.dao.Limit;
import kr.mjc.gwangmin.web.dao.Song;
import kr.mjc.gwangmin.web.dao.Song;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SongDao {

    private static final String LIST_SONGS = """
      select songId, title, userId, name, cdate, udate from song
      order by songId desc limit ?,?
      """;

    private static final String GET_SONG = """
      select songId, title, sname, userId, name, cdate, udate from song
      where songId=?
      """;

    private static final String GET_USER_SONG = """
      select songId, title, sname, userId, name, cdate, udate from song
      where songId=? and userId=?
      """;

    private static final String ADD_SONG = """
      insert article(title, sname, userId, name)
      values (:title, :sname, :userId, :name)
      """;

    private static final String UPDATE_SONG = """
      update article set title=:title, sname=:sname
      where songId=:songId and userId=:userId
      """;

    private static final String DELETE_SONG =
            "delete from song where songId=? and userId=?";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    /**
     * resultSet을 article 오브젝트로 자동 매핑하는 매퍼
     */
    private final RowMapper<Song> songRowMapper =
            new BeanPropertyRowMapper<>(Song.class);

    public List<Song> listSongs(Limit limit) {
        return jdbcTemplate.query(LIST_SONGS, songRowMapper,
                limit.getOffset(), limit.getCount());
    }

    public Song getSong(int songId) {
        return jdbcTemplate.queryForObject(GET_SONG, songRowMapper,
                songId);
    }

    public Song getUserSong(int songId, int userId) {
        return jdbcTemplate.queryForObject(GET_USER_SONG, songRowMapper,
                songId, userId);
    }

    public void addSong(Song song) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(song);
        namedParameterJdbcTemplate.update(ADD_SONG, params);
    }

    public int updateSong(Song song) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(song);
        return namedParameterJdbcTemplate.update(UPDATE_SONG, params);
    }

    public int deleteSong(int songId, int userId) {
        return jdbcTemplate.update(DELETE_SONG, songId, userId);
    }
}