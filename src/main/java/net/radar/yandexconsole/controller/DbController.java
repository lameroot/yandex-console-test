package net.radar.yandexconsole.controller;

import lombok.extern.slf4j.Slf4j;
import net.radar.yandexconsole.model.Profile;
import net.radar.yandexconsole.repository.ProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/db")
@Slf4j
public class DbController {

    @Resource
    private ProfileRepository profileRepository;

    @RequestMapping(value = "/save")
    public @ResponseBody Profile save(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "age", required = false) Integer age) {
        Profile profile = new Profile()
                .setName(name)
                .setAge(age);
        log.info("Save [{}]", profile);
        return profileRepository.save(profile);
    }

    @RequestMapping(value = "/get")
    public @ResponseBody List<Profile> getByName(@RequestParam(name = "name") String name) {
        log.info("Find by name: [{}]", name);
        return profileRepository.findByName(name);
    }

    @RequestMapping(value = "/count")
    public @ResponseBody Long count() {
        log.info("Count");
        return profileRepository.count();
    }
}
