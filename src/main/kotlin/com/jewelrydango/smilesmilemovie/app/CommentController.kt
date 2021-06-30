package com.jewelrydango.smilesmilemovie.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class CommentController {

    @RequestMapping("/")
    fun index(): String? {
        return "index"
    }
}