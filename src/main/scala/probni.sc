import scala.runtime.Nothing$

6/3
val a = 2
def aqua(a:Int, b: =>Int) : Int = a + b
aqua(3,a)

def bunbar ( f1:(Int, =>Int)=>Int , c:Int): Int = f1(c,4)

bunbar(aqua,9)

if(true) 1 else false
3/1

//val xx:Nothing

//val yy = xx
