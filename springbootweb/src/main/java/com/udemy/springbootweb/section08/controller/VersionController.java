package com.udemy.springbootweb.section08.controller;

import com.udemy.springbootweb.section08.bean.Name;
import com.udemy.springbootweb.section08.bean.Version1;
import com.udemy.springbootweb.section08.bean.Version2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    /* URI Versioning */
    @GetMapping("/v1/version")
    public Version1 version1Uri() {
        return new Version1("version1");
    }

    @GetMapping("/v2/version")
    public Version2 version2Uri() {
        return new Version2(new Name("version", "2"));
    }

    /* Parameter Versioning */
    @GetMapping(path = "/version", params = "version=1")
    public Version1 version1Parameter() {
        return new Version1("version1");
    }

    @GetMapping(path = "/version", params = "version=2")
    public Version2 version2Parameter() {
        return new Version2(new Name("version", "2"));
    }

    /* Custom Header Versioning */
    @GetMapping(path = "/version/header", headers = "X-API-VERSION=1")
    public Version1 version1RequestHeader() {
        return new Version1("version1");
    }

    @GetMapping(path = "/version/header", headers = "X-API-VERSION=2")
    public Version2 version2RequestHeader() {
        return new Version2(new Name("version", "2"));
    }

    /* Media Type(Accept) Versioning */
    @GetMapping(path = "/version/accept", produces = "application/version.app-v1+json")
    public Version1 version1RequestAccept() {
        return new Version1("version1");
    }

    @GetMapping(path = "/version/accept", produces = "application/version.app-v2+json")
    public Version2 version2RequestAccept() {
        return new Version2(new Name("version", "2"));
    }

}
