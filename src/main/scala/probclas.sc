

abstract class IntSet {
  def include(x:Int):IntSet
  def contains(x:Int):Boolean
}

object Empty extends IntSet {
  def include(x:Int):IntSet = new NonEmpty(x, Empty, Empty)

  def contains(x:Int):Boolean = false
  override def toString = { "." }

}

class NonEmpty (elem:Int, left:IntSet, right:IntSet) extends IntSet {

  def include(x:Int):IntSet =
    if( x < elem ) new NonEmpty( elem, left include x, right)
    else if( x > elem ) new NonEmpty( elem, left, right include x )
    else this

  def contains(x:Int):Boolean = {
    if( x < elem) left.contains(x)
    else if( x > elem ) right.contains(x)
    else true
  }

  override def toString =  "{" + left + elem + right + "}"

}

//object probclas{
  val ww:Int = 3
  val prvi = new NonEmpty( 33, Empty, Empty)
  val drugi = prvi include 11
  val treci = prvi include 7
  val treci2 = drugi include 9
  val treci3 = treci2 include 14
//}
