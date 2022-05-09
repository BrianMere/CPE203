import java.util.List;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   @Override
   public boolean equals(Object o){
      if(o == null || o.getClass() != Student.class){
         return false;
      }
      Student p = (Student) o;
      return p.surname != null && p.surname.equals(this.surname) &&
      p.givenName != null && p.givenName.equals(this.givenName) &&
      p.age == this.age &&
      p.currentCourses != null && p.currentCourses.equals(this.currentCourses);
   }

   @Override
   public int hashCode(){
      int hash = 1;
      final int PRIME = 31;
      hash = hash * PRIME + (this.surname != null ? this.surname.hashCode() : 0);
      hash = hash * PRIME + (this.givenName != null ? this.givenName.hashCode() : 0);
      hash = hash * PRIME + ((Integer)this.age).hashCode();
      hash = hash * PRIME + (this.currentCourses != null ? this.currentCourses.hashCode() : 0);
      return hash;
   }
}
