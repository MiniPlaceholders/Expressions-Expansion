rootProject.name = "expressions-parent"

include("expressions-paper")
include("expressions-velocity")
include("expressions-krypton")
include("expressions-common")

project(":expressions-velocity").projectDir = file("velocity")
project(":expressions-paper").projectDir = file("paper")
project(":expressions-krypton").projectDir = file("krypton")
project(":expressions-common").projectDir = file("common")
