package com.devjobs.app.core.constants

import java.text.Normalizer


class Locations {

    companion object {
        private val locations = listOf(
            // Argentina
            "Argentina", "Buenos Aires", "Córdoba", "Rosario", "Mendoza", "La Plata",
            // Bolivia
            "Bolivia", "La Paz", "Santa Cruz de la Sierra", "Cochabamba", "Sucre", "Tarija",
            // Chile
            "Chile", "Santiago", "Valparaíso", "Concepción", "La Serena", "Antofagasta",
            // Colombia
            "Colombia", "Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena",
            // Costa Rica
            "Costa Rica", "San José", "Alajuela", "Heredia", "Cartago", "Liberia",
            // Cuba
            "Cuba", "La Habana", "Santiago de Cuba", "Camagüey", "Holguín", "Santa Clara",
            // Ecuador
            "Ecuador", "Quito", "Guayaquil", "Cuenca", "Santo Domingo de los Tsáchilas", "Ambato",
            // El Salvador
            "El Salvador", "San Salvador", "Santa Ana", "San Miguel", "Soyapango", "Mejicanos",
            // España
            "España", "Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao",
            // Guatemala
            "Guatemala", "Ciudad de Guatemala", "Quetzaltenango", "Escuintla", "San Juan Sacatepéquez", "Villa Nueva",
            // Honduras
            "Honduras", "Tegucigalpa", "San Pedro Sula", "Choloma", "La Ceiba", "El Progreso",
            // México
            "México", "Ciudad de México", "Guadalajara", "Monterrey", "Puebla", "Tijuana",
            // Nicaragua
            "Nicaragua", "Managua", "León", "Masaya", "Matagalpa", "Chinandega",
            // Panamá
            "Panamá", "Ciudad de Panamá", "San Miguelito", "Tocumen", "David", "Arraiján",
            // Paraguay
            "Paraguay", "Asunción", "Ciudad del Este", "San Lorenzo", "Lambare", "Fernando de la Mora",
            // Perú
            "Perú", "Lima", "Arequipa", "Trujillo", "Chiclayo", "Piura",
            // República Dominicana
            "República Dominicana", "Santo Domingo", "Santiago de los Caballeros", "Santo Domingo Este", "Santo Domingo Oeste", "San Pedro de Macorís",
            // Uruguay
            "Uruguay", "Montevideo", "Salto", "Ciudad de la Costa", "Paysandú", "Las Piedras",
            // Venezuela
            "Venezuela", "Caracas", "Maracaibo", "Valencia", "Barquisimeto", "Maracay",
            // Brasil
            "Brasil", "São Paulo", "Rio de Janeiro", "Belo Horizonte", "Brasília", "Salvador"
        )


        fun getLocations(query:String):List<String>{
            return locations.filter {
                location ->
                val locationFilter = unaccented(location)
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