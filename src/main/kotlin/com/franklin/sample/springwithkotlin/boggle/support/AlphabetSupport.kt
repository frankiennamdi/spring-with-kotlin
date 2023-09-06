package com.franklin.sample.springwithkotlin.boggle.support

import java.util.*

class AlphabetSupport(private val locale: Locale?) {

    fun getAlphabet(upperCase: Boolean): CharArray {
        val language: LocaleLanguage = LocaleLanguage.getLocalLanguage(locale)!!
        return getAlphabet(language, upperCase)
    }

    private fun getAlphabet(localeLanguage: LocaleLanguage?, flagToUpperCase: Boolean): CharArray {
        val language: LocaleLanguage = localeLanguage ?: LocaleLanguage.ENGLISH
        val firstLetter = language.getFirstLetter()
        val lastLetter = language.getLastLetter()
        val alphabetSize = lastLetter.code - firstLetter.code + 1
        var alphabet = CharArray(alphabetSize)
        for (index in 0 until alphabetSize) {
            alphabet[index] = (index + firstLetter.code).toChar()
        }
        if (flagToUpperCase) {
            alphabet = String(alphabet).uppercase(Locale.getDefault()).toCharArray()
        }
        return alphabet
    }

    companion object Factory {
        fun englishAlphabet(): AlphabetSupport {
            return AlphabetSupport(Locale.ENGLISH)
        }
    }
}