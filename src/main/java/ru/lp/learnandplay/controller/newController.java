package ru.lp.learnandplay.controller;

public class newController {
   @GetMapping("/")
    public String getWelcomePage() {
        return "home";
    }

    @GetMapping("/entry")
    public String getEntryPage() {
        return "entry";
    }
    @GetMapping("/g")
    @ResponseBody
    public test getG() {
        return new test("1",1);
    }
}
