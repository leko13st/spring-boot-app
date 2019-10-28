package com.example.SpringTest;

        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.Arrays;
        import java.util.List;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public void greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
    }

    @GetMapping("/greeting1")
    public void greeting1(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
    }
}