package com.progscala3.valueclass

@main def main(args: String*): Unit =
  val person = Person("John Doe", EmailAddress("john.doe@example.com"))
  println(person)
  println(person.email.user)

class Person(val name: String, val email: EmailAddress):
  override def toString: String = s"Person($name, $email)"

  // using a value class in scala
class EmailAddress(val address: String) extends AnyVal:
  def isValid: Boolean = address.contains("@")
  def domain: String = address.split("@").last
  def user: String = address.split("@").head
  override def toString(): String = s"EmailAddress($address)"
