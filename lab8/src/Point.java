final class Point
{
   public final double x;
   public final double y;
   public final int z;

   public Point(double x, double y, int z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public String toString()
   {
      return x + ", " + y + ", " + z;
   }

   public boolean equals(Object other)
   {
      return other instanceof Point &&
         ((Point)other).x == this.x &&
         ((Point)other).y == this.y &&
              ((Point)other).z == this.z;
   }

   public int hashCode()
   {
      int result = 17;
      result = result * 31 + ((Double) x).hashCode();
      result = result * 31 + ((Double) y).hashCode();
      result = result * 31 + z;
      return result;
   }

//   public boolean adjacent(Point p)
//   {
//      return (x == p.x && Math.abs(y - p.y) == 1) ||
//              (y == p.y && Math.abs(x - p.x) == 1);
//   }
}
