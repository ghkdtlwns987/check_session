package com.simplesession.simplesessiontest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;

/**
 *
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/print")
    public String printSession(HttpSession session, Model model){

        Date current_Timestamp = new Date();
        System.out.println("Session : " + session);
        System.out.println("Session Id : " + session.getId());
        System.out.println("TimeStamp : " + current_Timestamp);

        model.addAttribute("session_value", session);
        model.addAttribute("session_id", session.getId());
        model.addAttribute("session_timestamp" , current_Timestamp);
        return "session/print";
    }

    @GetMapping("/refresh")
    public String refershSession(HttpSession session, Model model){
        session.invalidate();
        return "session/done";
    }

    @GetMapping("/getAllSession")
    public String getAllSession(HttpSession session, Model model){
        int number = 0;
        Enumeration<?> attrName = session.getAttributeNames();
        while (attrName.hasMoreElements()) {
            String attr = (String) attrName.nextElement();
            System.out.println(session.getAttribute(attr));
            model.addAttribute("count", attr);
        }

        return "session/all";
    }

    @GetMapping("/health_check")
    public String healthCheck(){
        return "ok";
    }
}
