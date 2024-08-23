package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if (this == READ) then println("Opening document")
      else println("You don't have permission to open the document")

  }

  val somePermissions: Permissions = Permissions.READ

  // constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = bits match {
      case 4 => READ
      case 2 => WRITE
      case 1 => EXECUTE
      case 0 => NONE
    }
  }

  // standard API
  val somePermissionsOrdinal: Int = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values
  var readPermissions = Permissions.valueOf("READ")

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)
    println(allPermissions.mkString(", "))
    println(readPermissions)
  }

}
