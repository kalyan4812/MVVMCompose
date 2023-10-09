package com.example.mvvmcompose

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> String?.fromJson(): T? {
    kotlin.runCatching {
        return Gson().fromJson(this, object : TypeToken<T>() {}.type)
    }.onFailure {
        return null
    }
    return null
}

fun Any?.toJson(): String {
    return Gson().toJson(this)
}