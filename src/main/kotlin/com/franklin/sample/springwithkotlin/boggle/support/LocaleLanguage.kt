package com.franklin.sample.springwithkotlin.boggle.support

import java.util.*

enum class LocaleLanguage(locale: Locale?, firstLetter: Char, lastLetter: Char) {
    ENGLISH(Locale("en"), 'a', 'z');

    private var mLocale: Locale? = locale
    private var mFirstLetter = firstLetter
    private var mLastLetter = lastLetter

    fun getLocale(): Locale? {
        return mLocale
    }

    fun getFirstLetter(): Char {
        return mFirstLetter
    }

    fun getLastLetter(): Char {
        return mLastLetter
    }
    companion object Factory
    {
        fun getLocalLanguage(locale: Locale?): LocaleLanguage? {
            if (locale == null) return ENGLISH
            for (localeLanguage in values()) {
                if (localeLanguage.getLocale()!!.language == locale.language) return localeLanguage
            }
            return null
        }
    }
}
