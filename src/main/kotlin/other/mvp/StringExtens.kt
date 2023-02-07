package other.mvp

import org.jetbrains.kotlin.idea.completion.handlers.isCharAt

/**
 *@Description
 *@author          阿土
 *@create          2023-02-07 14:22
 */

fun String.first2up() = this.substring(0,1).uppercase() + this.substring(1)
