package de.waschnick.happy.stars.controller;

import de.waschnick.happy.stars.business.star.control.StarImages;
import de.waschnick.happy.stars.business.star.entity.StarRepository;
import de.waschnick.happy.stars.business.universe.entity.UniverseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class InfoController {

    @Autowired
    private StarRepository starRepository;

    @Autowired
    private UniverseRepository universeRepository;

    @Autowired
    private StarImages starImages;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class VersionInfo {
        String version;
    }


    @RequestMapping(value = "count/star", method = RequestMethod.GET)
    public Long coutnStars() {
        return starRepository.count();
    }

    @RequestMapping(value = "count/universe", method = RequestMethod.GET)
    public Long coutnUniverse() {
        return universeRepository.count();
    }


    @RequestMapping(value = "image/star/{name}", method = RequestMethod.GET)
    public String imageUrl(@NotBlank @PathVariable String name) {
        return starImages.getImageUrlForName(name);
    }


    @RequestMapping(value = "version", method = RequestMethod.GET)
    public VersionInfo getVersion() {
        return new VersionInfo("alive!");
    }
}