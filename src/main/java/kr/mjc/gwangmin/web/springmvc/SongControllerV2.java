package kr.mjc.gwangmin.web.springmvc;

import jakarta.servlet.http.HttpServletRequest;
import kr.mjc.gwangmin.web.HttpUtils;
import kr.mjc.gwangmin.web.dao.Song;
import kr.mjc.gwangmin.web.dao.SongDao;
import kr.mjc.gwangmin.web.dao.Limit;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.server.ResponseStatusException;

/**
 * Servlet API를 사용하지 않는 컨트롤러
 */
@Controller
@AllArgsConstructor
public class SongControllerV2 {
    private static final String CURRENT_SONG_LIST = "CURRENT_SONG_LIST";
    private final SongDao songDao;

    @GetMapping("/song/songList")
    public void songList(HttpServletRequest req, Limit limit, Model model) {
        // 현재 목록을 세션에 저장
        req.getSession().setAttribute(CURRENT_SONG_LIST,
                HttpUtils.getRequestURLWithQueryString(req));

        req.setAttribute("songList", songDao.listSongs(limit));
    }

    @GetMapping("/song/songForm")
    public void mapDefault() {
    }

    @PostMapping("song/addSong")
    public String addSong(Song song,
                             @SessionAttribute("me_userId") int userId,
                             @SessionAttribute("me_name") String name) {
        song.setUserId(userId);
        song.setName(name);
        songDao.addSong(song);
        return "redirect:/app/song/songList";
    }

    @GetMapping("/song/song")
    public void song(int songId, Model model) {
        model.addAttribute("song", songDao.getSong(songId));
    }

    @GetMapping("/song/songEdit")
    public void songEdit(int songId,
                            @SessionAttribute("me_userId") int userId, Model model) {
        Song song = getUserSong(songId, userId);
        model.addAttribute("song", song);
    }

    @PostMapping("/song/updateSong")
    public String updateSong(Song song,
                                @SessionAttribute("me_userId") int userId) {
        getUserSong(song.getSongId(), userId);
        song.setUserId(userId);
        songDao.updateSong(song);
        return "redirect:/app/song/song?songId=" + song.getSongId();
    }

    @GetMapping("/song/deleteSong")
    public String deleteSong(int songId,
                                @SessionAttribute("me_userId") int userId,
                                @SessionAttribute(CURRENT_SONG_LIST) String currentSongList) {
        getUserSong(songId, userId);
        songDao.deleteSong(songId, userId);
        return "redirect:" + currentSongList;
    }

    /**
     * 게시글의 권한 체크
     *
     * @throws ResponseStatusException 권한이 없을 경우
     */
    private Song getUserSong(int songId, int userId) {
        try {
            return songDao.getUserSong(songId, userId);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}