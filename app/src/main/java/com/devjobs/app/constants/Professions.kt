package com.devjobs.app.constants

import java.text.Normalizer

class Professions {

    companion object {
        private val professions = listOf(
            "Desarrollador web", "Desarrollador Android", "Desarrollador IOS"
        )

        fun getProfessions (query:String):List<String>{
            return professions.filter {
                    profession ->
                val locationFilter = unaccented(profession)
                locationFilter.lowercase().contains(regexQuery(unaccented(query)))
            }
        }


        private fun unaccented(query: String): String {
            var regex = "\\p{InCombiningDiacriticalMarks}+".toRegex()

            val temp = Normalizer.normalize(query, Normalizer.Form.NFD)
            return regex.replace(temp, "")
        }

        private fun regexQuery(filterQuery:String):Regex {
            return Regex("^${filterQuery.lowercase()}")
        }
    }
}