package com.andres3105.fundamentoskotlin.Reto3

class Subasta {
    fun participantesOferta(articulo: Double) {
        var canOfertantes: Int = 5
        var ofertaGanadora = 0.0

        while (canOfertantes > 0) {
            print("¿DESEA OFERTAR A ESTE ARTICULO CON EL PRECIO DE $articulo? Si/No: ")
            var respuesta: String = readLine()!!.toString().lowercase()

            if (respuesta == "si") {
                print("Ingrese el precio a ofertar, debe ser mayor al precio base: ")
                var ofertaNueva: Double = readLine()!!.toDouble()
                println("La oferta actual es de $ofertaNueva")
                if (ofertaNueva > ofertaGanadora) {
                    ofertaGanadora = ofertaNueva
                    println("Oferta realizada exitosamente.")
                }else {
                    println("La oferta debe ser mayor que la oferta actual.")
                }
            } else {
                canOfertantes--
            }
        }

        if (ofertaGanadora > 0) {
            println("La oferta ganadora momentánea es $ofertaGanadora")
        } else {
            println("La oferta se vendió a la casa de subastas con el precio de $articulo")
        }
    }
}

fun main() {
    val subasta = Subasta()
    print("Ingrese el precio base del artículo: ")
    val precioBase: Double = readLine()!!.toDouble()
    subasta.participantesOferta(precioBase)
}