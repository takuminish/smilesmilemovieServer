package com.jewelrydango.smilesmilemovie.app.model

import java.io.Serializable
import javax.validation.constraints.NotBlank

class SaveSmileCommentRequest: Serializable {

    @field:NotBlank
    val comment: String = "";

    @field:NotBlank
    val color: String = "";

    override fun toString(): String {
        return "${this.comment}, ${this.color}"
    }
}