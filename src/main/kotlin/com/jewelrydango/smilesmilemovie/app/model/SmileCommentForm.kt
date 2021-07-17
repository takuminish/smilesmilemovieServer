package com.jewelrydango.smilesmilemovie.app.model

import java.io.Serializable

class SmileCommentForm: Serializable {

    var comment: String = "";
    var color: String = "";

    override fun toString(): String {
        return "${this.comment}, ${this.color}"
    }
}