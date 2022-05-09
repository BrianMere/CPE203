package calculator;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.*;
import org.junit.rules.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases
{
   public static final double DELTA = 0.00001;
   private Bindings bindings = new VariableBindings();
   
   @Before
   public void init() 
   {
      bindings.addBinding("x", 2.5);
      bindings.addBinding("y", 10);
   }

   @Test
   public void test01_ExpressionsEvaluate()
   {
      IdentifierExpression x = new IdentifierExpression("x");
      IdentifierExpression y = new IdentifierExpression("y");
      AddExpression add = new AddExpression(x, y);
      SubtractExpression sub = new SubtractExpression(x, y);
      MultiplyExpression mult = new MultiplyExpression(x, y);
      DivideExpression div = new DivideExpression(x, y);

      assertEquals(12.5, add.evaluate(bindings), DELTA);
      assertEquals(-7.5, sub.evaluate(bindings), DELTA);
      assertEquals(25.0, mult.evaluate(bindings), DELTA);
      assertEquals(0.25, div.evaluate(bindings), DELTA);
   }

   @Test
   public void test02_ExpressionsToString()
   {
      IdentifierExpression x = new IdentifierExpression("x");
      IdentifierExpression y = new IdentifierExpression("y");
      AddExpression add = new AddExpression(x, y);
      SubtractExpression sub = new SubtractExpression(x, y);
      MultiplyExpression mult = new MultiplyExpression(x, y);
      DivideExpression div = new DivideExpression(x, y);

      assertEquals("(x + y)", add.toString());
      assertEquals("(x - y)", sub.toString());
      assertEquals("(x * y)", mult.toString());
      assertEquals("(x / y)", div.toString());
   }
}