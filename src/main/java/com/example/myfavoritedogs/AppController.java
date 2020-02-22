package com.example.myfavoritedogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static com.example.myfavoritedogs.Main.downloadJsonFromURL;
import static com.example.myfavoritedogs.Main.jsonDownloadedToClass;

@Controller
public class AppController {

    List<Dog> seenDogs = new ArrayList<>();

    @Autowired
    private DogService service;

    @RequestMapping("/")
    public String showRandomDog(Model model) {
        String jsonDownloaded = downloadJsonFromURL("https://random.dog/woof.json");
        Dog dog = jsonDownloadedToClass(jsonDownloaded);
        seenDogs.add(dog);
        List<Dog> listDogs = service.listAll();
        model.addAttribute("listDogs", listDogs);
        model.addAttribute("dogModel", dog);
        return "index";
    }

        @RequestMapping(value="/save", method = RequestMethod.GET)
        public String saveDog(Model model) {
            service.save(seenDogs.get(seenDogs.size()-1));
            return "redirect:/"; }

        @RequestMapping("/reload")
        public String reloadDog() {
            return "redirect:/";
        }
}
