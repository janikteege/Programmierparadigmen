//Zusammenarbeit von Janik Teege und Nele Hüsemann


object CharacterTree {
  def print_tree(height: Int, level: Int = 1) : Unit = {
    // TODO: This function should print out the standard character tree
    //
    //    *
    //   ***
    //  *****
    // *******
    //*********
    //    *
    if (height == level) {
        println(" " * (height - 2) + "*")
        return
    }
    println(" " * (height - 1 - level) + "*" * (2 * (level - 1) + 1))
    print_tree(height, level + 1)
  }
  
  def print_tree_char(height: Int, char: Char, level: Int = 1) : Unit = {
    // TODO: This function should print out the custom char character tree
    //
    //    o
    //   ooo
    //  ooooo
    // ooooooo
    //ooooooooo
    //    *
    if (height == level) {
        println(" " * (height - 2) + "*")
        return
    }
    println(" " * (height - 1 - level) + char.toString() * (2 * (level - 1) + 1))
    print_tree_char(height, char, level + 1)
    
  }

  def main(args: Array[String]) = {
    var foo: Int = 14
    print_tree(foo)
    print_tree_char(foo, 'o');
  }
}