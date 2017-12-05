// Scala course 1 5.1
def flatten(xs: List[Any]): List[Any] = {
  xs match {
    case List() => List()
    case xsh::xst =>
      xsh match {
        case li:List[Any] => flatten(li)++flatten(xst)
        case _:Any => List(xsh) ++ flatten(xst)
      }
  }
}
val res = flatten(List(List(1, 1, 1, List(22,22)), 2, List(3, List(5, 8))))

res.take(3)
res.drop(3)

// 5.2
def merge(xs: List[Int], ys: List[Int]): List[Int] =
  (xs, ys) match {
    case (List(), ys) => ys
    case(xs, List()) => xs
    case (xs, ys) =>
      if (xs.head < ys.head ) xs++merge(xs.tail,ys)
      else ys++merge(xs,ys.tail)
  }

def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => Nil
    case y :: ys => List(y*y):::squareList(ys)
  }

def squareList1(xs: List[Int]): List[Int] =
  xs map (y => y*y)

squareList(res.asInstanceOf[List[Int]])
squareList1(res.asInstanceOf[List[Int]])

res.asInstanceOf[List[Int]] filter (x => x > 3)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    xs partition ( y => y==x ) match {
      case (aa, bb) => List(aa) ++ pack(bb)
    }
}
pack(List("a", "a", "a", "b", "c", "c", "a"))

val dd =res.asInstanceOf[List[Int]] span (x => x!=1)

//List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
//encode(List("a", "a", "a", "b", "c", "c", "a"))






