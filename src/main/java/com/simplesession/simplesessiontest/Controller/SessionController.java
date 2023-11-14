package com.simplesession.simplesessiontest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 */
@Controller
@RequestMapping("/session")
public class SessionController {
    @GetMapping("/print")
    public String printSession(HttpSession session, Model model){
        System.out.println("Session : " + session);
        System.out.println("Session Id : " + session.getId());

        Date current_Timestamp = new Date();

        model.addAttribute("session_value", session);
        model.addAttribute("session_id", session.getId());
        model.addAttribute("session_timestamp" , current_Timestamp);
        return "session/print";
    }
}
