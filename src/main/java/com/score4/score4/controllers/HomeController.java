package com.score4.score4.controllers;

import com.score4.score4.game.Connect4;
import com.score4.score4.models.Message;
import com.score4.score4.view.HtmlViewer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("scopes.xml");

    @RequestMapping("/")
    public String getMatrix(){
        Connect4 game=(Connect4) applicationContext.getBean("Connect4Singleton");
        String html= HtmlViewer.getMatrix(game.getMatrix());
        System.out.println(html);
        return html;
    }
    // example: /move?player=1&index=3
    @RequestMapping(value="/move", method = RequestMethod.GET)
    public String doConnect4Move(@RequestParam("player") int player,@RequestParam("index") int index){
        Connect4 game=(Connect4) applicationContext.getBean("Connect4Singleton");
        Message msg=game.setMark(index,player);
        System.out.println("Message:"+msg.isSuccessful());
        if(!msg.isSuccessful()||msg.isEnd())  return msg.getMessage();
        else return HtmlViewer.getMatrix(game.getMatrix());
    }




}
