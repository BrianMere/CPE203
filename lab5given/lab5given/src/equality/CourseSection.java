package equality;

import java.time.LocalTime;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   @Override
   public boolean equals(Object o){
      if(o == null || o.getClass() != CourseSection.class){
         return false;
      }
      CourseSection p = (CourseSection) o;
      return p.prefix.equals(this.prefix) &&
      p.number.equals(this.number) &&
      p.enrollment == this.enrollment &&
      p.startTime.equals(this.startTime) &&
      p.endTime.equals(this.endTime);
   }

   @Override
   public int hashCode(){
      int hash = 0;
      final int PRIME = 31;
      hash = hash * PRIME + this.prefix.hashCode();
      hash = hash * PRIME + this.number.hashCode();
      hash = hash * PRIME + ((Integer)this.enrollment).hashCode();
      hash = hash * PRIME + this.startTime.hashCode();
      hash = hash * PRIME + this.endTime.hashCode();
      return hash;
   }

   // additional likely methods not defined since they are not needed for testing
}
