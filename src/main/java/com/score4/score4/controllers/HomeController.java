package com.score4.score4.controllers;

import com.score4.score4.game.Connect4;
import com.score4.score4.models.Message;
import com.score4.score4.view.HtmlViewer;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    Connect4 game = new Connect4(3,5,3);

    @RequestMapping("/")
    public String getHelloWorld(){
        String html= HtmlViewer.getMatrix(game.getMatrix());
        System.out.println(html);
        return html;
    }
    // /move?player=1&index=3
    @RequestMapping(value="/move", method = RequestMethod.GET)
    public @ResponseBody
    String getItem(@RequestParam("player") int player,@RequestParam("index") int index){
        Message msg=game.setMark(index,player);
        System.out.println("Message:"+msg.isSuccessful());
        if(!msg.isSuccessful()||msg.isEnd())  return msg.getMessage();
        else return HtmlViewer.getMatrix(game.getMatrix());
    }




}
