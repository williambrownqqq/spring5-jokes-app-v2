package com.zanchenko.alexey.spring5jokesappv2.controllers;

import com.zanchenko.alexey.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mark it as a controller
public class JokeController {
    private final JokeService jokeService; // And then I set up a final property for the joke service, created a constructor, which will initialize
    // the joke service. So remember best practice is to code to an interface for Dependency Injection.
    //А потом я настроил финальное свойство для сервиса шуток, создал конструктор, который будет инициализировать сервис шуток. Поэтому помните, что передовой практикой является кодирование интерфейса для внедрения зависимостей.
    @Autowired // if we mark this as @Autowired, Spring is going to aitomatically inject that
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
    @RequestMapping({"/",""}) // We are going to invoke this method for the request to be processed. // Мы собираемся вызвать этот метод для обработки запроса.
    public String showJoke(Model model){ // "/","" THIS is going to go in for ther root
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
        //that tells Thymeleaf to look for a basically a template
        //
        //file under templates called index.
    }
    //Remember, the model's effectively a map implementation, so we are adding in a property with the string
    //
    //of joke and then the joke string so that we'll be able to reference that from our view.
    //омните, что модель фактически является реализацией карты, поэтому мы добавляем свойство со строкой шутки, а затем строку шутки, чтобы мы могли ссылаться на нее с нашей точки зрения.
}
