package com.andres3105.fundamentoskotlin.Reto2

class cancion(var titulo: String, var artista: String, var año: Int, var reproducciones: Int, var popularidad: String = "")
class Album (){
    var canciones= mutableListOf<cancion>()
    var tipoMusica:String=""
    var numeroCanciones:Int=0

    fun agregarCancion(titulo: String, artista: String, año: Int, reporducciones: Int){
        var cancion=cancion(titulo,artista,año,reporducciones)
        canciones.add(cancion)
        numeroCanciones++
    }

    fun agregarTipoMusica(tipoMusica:String){
        this.tipoMusica=tipoMusica
    }

    fun cancionPopular(): cancion? {
        if (canciones.isEmpty()) return null
        return canciones.maxByOrNull { it.reproducciones }
    }

    fun mirarPopularidad(){
        canciones.forEach {cancion ->
            cancion.reproducciones.takeIf { it >= 1000 } ?.let {
                cancion.popularidad="Popular"
            } ?: run {
                cancion.popularidad="Poco popular"
            }
        }
    }

    fun mostrarDatos(){
        canciones.forEach { cancion ->
            println("${cancion.titulo}, interpretada por ${cancion.artista}, se lanzó en ${cancion.año} y tiene ${cancion.reproducciones} reproducciones. Por lo que es ${cancion.popularidad}")
        }
    }
}

fun main() {
    var Album=Album()
    Album.agregarTipoMusica("Pop")
    Album.agregarCancion("Heat Waves", "Glass Animals", 2022, 1500)
    Album.agregarCancion("As It Was", "Harry Styles", 2022, 500)
    Album.agregarCancion("Stay", "The Kid LAROI & Justin Bieber", 2022, 750)
    Album.agregarCancion("Easy On Me", "Adele", 2022, 3490)
    Album.agregarCancion("Shivers", "Ed Sheeran", 2022, 2950)
    Album.agregarTipoMusica("Rock")
    Album.agregarCancion("Purple Haze", "Jimi Hendrix", 1967, 29000)
    Album.agregarCancion("Whole Lotta Love", "Led Zeppelin", 1969, 2030)
    Album.agregarCancion("Sympathy for the Devil", "The Rolling Stones", 1968, 1360)
    Album.agregarCancion("Stairway to Heaven", "Led Zeppelin", 1971, 390)
    Album.agregarCancion("Bohemian Rhapsody", "Queen", 1975, 1662)
    Album.agregarTipoMusica("Jazz")
    Album.agregarCancion("Mood Indigo", "Duke Ellington & His Famous Orchestra", 1930, 3300)
    Album.agregarCancion("The Nearness Of You", "Norah Jones", 2002, 210)
    Album.agregarCancion("Misty", "Johnny Mathis", 1959, 2700)
    Album.agregarCancion("Cry Me A River", "Julie London", 1955, 5700)
    Album.agregarCancion("The Look of Love", "Diana Krall", 2001, 180)
    Album.mirarPopularidad()

    println("Esta es la cancion mas popular dentro del Album")
    val cancionPopular = Album.cancionPopular()
    if (cancionPopular != null) {
        println("La canción más popular es ${cancionPopular.titulo} con ${cancionPopular.reproducciones} reproducciones.")
        println()
    }
    println("Lista de canciones en el album")
    Album.mostrarDatos()

    do {
        println("¿Cuantas canciones tiene este album?")
        var cantCanciones= readLine()!!.toInt()
        if (cantCanciones==Album.numeroCanciones){
            println("Has acertado en el numero de canciones del Album")
        }else{
            println("No has acertado en el numero de canciones del Album")
        }
        println("¿Quieres otra oportunidad?")
        var decision= readLine()!!.toString().lowercase()
    }while (decision.equals("si"))
    println("Gracias por usar el programa")
}