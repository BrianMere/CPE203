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
      return (p.prefix != null ? p.prefix.equals(this.prefix) : this.prefix == null) &&
              (p.number != null ? p.number.equals(this.number) : this.number == null) &&
               p.enrollment == this.enrollment &&
              (p.startTime != null ? p.startTime.equals(this.startTime) : this.startTime == null)&&
              (p.endTime != null ? p.endTime.equals(this.endTime) : this.endTime == null);
   }

   @Override
   public int hashCode(){
      int hash = 1;
      final int PRIME = 31;
      hash = hash * PRIME + (this.prefix != null ? this.prefix.hashCode() : 0);
      hash = hash * PRIME + (this.number != null ? this.number.hashCode() : 0);
      hash = hash * PRIME + this.enrollment;
      hash = hash * PRIME + (this.startTime != null ? this.startTime.hashCode() : 0);
      hash = hash * PRIME + (this.endTime != null ? this.endTime.hashCode() : 0);
      return hash;
   }

   // additional likely methods not defined since they are not needed for testing
}
