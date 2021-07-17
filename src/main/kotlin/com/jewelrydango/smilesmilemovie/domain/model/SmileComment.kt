package com.jewelrydango.smilesmilemovie.domain.model

import org.apache.commons.lang3.RandomStringUtils
import java.io.Serializable

class SmileComment: Serializable {
     var _id: String = "";

     var _rev: String? = null;

     var comment: String = "";

     var color: String = "";

     var isViewed: Boolean = false;

    constructor(comment: String, color: String) {
        this._id = "smilesmilemovie:${RandomStringUtils.randomAlphanumeric(10)}"
        this.comment = comment;
        this.color = color;
        this.isViewed = false;
    }

    override fun toString(): String {
        return "{${this._id}, ${this.comment}, ${this.color}, ${isViewed}}"
    }
}