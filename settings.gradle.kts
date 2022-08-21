rootProject.name = "expressions-parent"

include("expressions-paper")
include("expressions-velocity")
include("expressions-common")

project(":expressions-velocity").projectDir = file("velocity")
project(":expressions-paper").projectDir = file("paper")
project(":expressions-common").projectDir = file("common")
