package com.helloblog;

import com.helloblog.database.User;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.helloblog.App.str;

@Controller
public class Maincontroller extends Forscheduled{

    @Autowired
    SqlSession session;

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                forcheckupdate(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public List<User> forcheckupdate(ArrayList<String> url) throws Exception {
        List<User> list = new ArrayList<>();
        int num = 0;
        for (String s : url) {
            num++;
            Connection conn = Jsoup.connect(s);
            conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64;sx64; rv:54.0) Gecko/20100101 Firefox/54.0");
            Document doc = conn.get();


            Element element = doc.select(".site-piclist_pic_link").first();
            String contextstr = element.html();

            try {
                User user = session.selectOne("getname", num);
                user.getName();
                if (!user.getName().equals(contextstr)) {
                    user.setName(contextstr);
                    user.setUrl(s);
                    list.add(user);
                    session.insert("intoname", user);
                }
            } catch (Exception e) {
                User user = new User();
                user.setName(contextstr);
                session.insert("realinto", user);
            }
        }
        return list;
    }


    @GetMapping("/gorun")
    public String gorun() {
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0 0 0-12 * * ?"));
        return "isok";
    }

    @GetMapping("/stoprun")
    public String stoprun() {
        if (future != null) {
            future.cancel(true);
        }
        return "isok";
    }


    @GetMapping({"/", "/index"})
    public String index(Map<String, Object> map) {

        try {
            map.put("checkupdate", forcheckupdate(str));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }

}