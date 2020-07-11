




lsclass Point(val i: Int, val j: Int)
{
var x: Int = i
var y: Int = j
def moves(xd: Int, yd: Int) {
x = x + xd
y = y + yd
println ("New point in x location is: " + x);
println ("New point in y location is : " + y);
}
}
object Intellipaat {
def main(args: Array[String]) {
val pt1 = new Point(10, 0);  // object pt1
pt1.moves(20, 10);        // Move the point into another location
}
}


