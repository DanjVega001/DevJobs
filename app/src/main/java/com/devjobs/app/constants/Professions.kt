package com.devjobs.app.constants

import android.util.Log
import java.text.Normalizer

class Professions {

    companion object {
        private val professions = listOf(
            "Desarrollador web",
            "Desarrollador Android",
            "Desarrollador iOS",
            "Ingeniero de software",
            "Ingeniero de sistemas",
            "Ingeniero de calidad de software",
            "Ingeniero de pruebas",
            "Ingeniero DevOps",
            "Arquitecto de software",
            "Diseñador de experiencia de usuario (UX)",
            "Diseñador de interfaz de usuario (UI)",
            "Ingeniero de datos",
            "Ingeniero de machine learning",
            "Científico de datos",
            "Analista de datos",
            "Administrador de bases de datos (DBA)",
            "Administrador de sistemas",
            "Especialista en seguridad informática",
            "Desarrollador de juegos",
            "Desarrollador de realidad virtual (VR)",
            "Desarrollador de realidad aumentada (AR)",
            "Desarrollador de aplicaciones móviles",
            "Ingeniero de software embebido",
            "Desarrollador de software empresarial",
            "Desarrollador full-stack",
            "Desarrollador back-end",
            "Desarrollador front-end",
            "Ingeniero de sistemas embebidos",
            "Desarrollador de firmware",
            "Analista de sistemas",
            "Consultor de TI",
            "Especialista en redes",
            "Especialista en soporte técnico",
            "Especialista en infraestructura de TI",
            "Ingeniero de automatización",
            "Ingeniero de telecomunicaciones",
            "Desarrollador de aplicaciones de escritorio",
            "Desarrollador de Java",
            "Desarrollador de Kotlin",
            "Desarrollador de Python",
            "Desarrollador de JavaScript",
            "Desarrollador de TypeScript",
            "Desarrollador de C#",
            "Desarrollador de .NET",
            "Desarrollador de PHP",
            "Desarrollador de Ruby",
            "Desarrollador de Go",
            "Desarrollador de Swift",
            "Desarrollador de Objective-C",
            "Desarrollador de Rust",
            "Desarrollador de Perl",
            "Desarrollador de HTML/CSS",
            "Desarrollador de SQL",
            "Desarrollador de GraphQL",
            "Desarrollador de Angular",
            "Desarrollador de React",
            "Desarrollador de Vue.js",
            "Desarrollador de Node.js",
            "Desarrollador de Express.js",
            "Desarrollador de Django",
            "Desarrollador de Flask",
            "Desarrollador de Laravel",
            "Desarrollador de Symfony",
            "Desarrollador de Spring Boot",
            "Desarrollador de ASP.NET",
            "Desarrollador de ASP.NET Core",
            "Desarrollador de Xamarin",
            "Desarrollador de Unity",
            "Ingeniero de seguridad informática",
            "Analista de seguridad",
        )

        fun getProfessions(query:String):List<String>{
            return professions.filter {
                    profession ->
                val professionFilter = unaccented(profession)
                professionFilter.lowercase().contains(regexQuery(unaccented(query)))
            }
        }

        private fun unaccented(query: String): String {
            var regex = "\\p{InCombiningDiacriticalMarks}+".toRegex()
            val temp = Normalizer.normalize(query, Normalizer.Form.NFD)
            return regex.replace(temp, "")
        }

        private fun regexQuery(filterQuery:String):Regex {
            return Regex("${filterQuery.lowercase()}")
        }
    }
}