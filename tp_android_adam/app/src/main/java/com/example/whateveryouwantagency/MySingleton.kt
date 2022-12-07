package com.example.whateveryouwantagency

import android.content.Context
import com.android.volley.toolbox.Volley
import com.android.volley.RequestQueue
import com.android.volley.Request
import java.time.Instant

class MySingleton constructor(context: Context){
    companion object{
        @Volatile
        private var INSTANCE: MySingleton?=null
        fun getInstance(context: Context){
            INSTANCE ?: synchronized(this){
                INSTANCE ?: MySingleton(context).also {
                    INSTANCE = it
                }
            }
        }
        private val requestQueue: RequestQueue by lazy {
            Volley.newRequestQueue(context.applicationContext)
        }
        fun <T> addToRequestQueue(req: Request<T>) {
            requestQueue.add(req)
        }
        }
    }
}