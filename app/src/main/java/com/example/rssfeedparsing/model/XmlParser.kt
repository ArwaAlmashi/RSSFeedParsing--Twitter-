package com.example.rssfeedparsing.model

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.net.URL

class XmlParser {
    private var tweets = arrayListOf<Tweet>()
    private var text = ""

    private var title = ""

    fun parse(): ArrayList<Tweet> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            val url = URL("https://rss.app/feeds/0iRnvmjTHSE6rxLs.xml")
            parser.setInput(url.openStream(), null)
            var evenType = parser.eventType
            while (evenType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (evenType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("title", true) -> {
                            title = text
                            tweets.add(Tweet(title))
                        }
                        else -> {}
                    }
                    else -> {}
                }
                evenType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return tweets
    }
}