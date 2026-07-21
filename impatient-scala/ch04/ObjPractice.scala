package com.progscala3.objpractice

import conversions.Conversions.*
import MeasuringTypes.*

trait Display:
  def display(msg: String = ""): Unit = println(s"$msg $this")
  def describe(msg: String = ""): String = s"$msg $this"

enum MeasuringTypes(value: Double, name: String) extends Display:

  case Inches(
    value: Double,
    name: String = "inches"
  ) extends MeasuringTypes(value, name)

  case Centimeters(
    value: Double,
    name: String = "centimeters"
  ) extends MeasuringTypes(value, name)

  case Gallons(
    value: Double,
    name: String = "gallons"
  ) extends MeasuringTypes(value, name)

  case Liters(
    value: Double,
    name: String = "liters"
  ) extends MeasuringTypes(value, name)

  case Miles(
    value: Double,
    name: String = "ml") extends MeasuringTypes(value, name)

  case Kilometers(
    value: Double,
    name: String = "km") extends MeasuringTypes(value, name)

  override def toString(): String = s"$value $name"

package conversions:

  object Conversions:
    private val InchesToCm = 2.54
    private val GallonsToLiters = 4.54609
    private val MilesToKm = 1.60934

    def inchesToCentimeters(value: Inches): Centimeters =
      Centimeters(value.value * InchesToCm)

    // interesting showing that gallonsToLiters
    // can be used in the general package even
    // when declared as private
    private [objpractice] def gallonsToLiters(value: Gallons): Liters =
      Liters(value.value * GallonsToLiters)

    def milesToKilometers(value: Miles): Kilometers =
      Kilometers(value.value * MilesToKm)

@main def main(args: String*): Unit =
   inchesToCentimeters(Inches(23)).display("23 inches is ")
   println(gallonsToLiters(Gallons(20.53)).describe("20.53 gallons is equals to"))
   milesToKilometers(Miles(98)).display("98 miles =")
