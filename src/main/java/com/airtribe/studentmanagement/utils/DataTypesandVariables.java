package main.java.com.airtribe.studentmanagement.utils;

public class DataTypesandVariables {
    private static int staticCounter = 0;
    private static double staticPi = 3.14159;
    private static String staticMessage = "This is a static variable";

    private int instanceId;
    private String instanceName;

    public DataTypesandVariables() {
        this.instanceId = ++staticCounter;
        this.instanceName = "Instance " + instanceId;
    }


    public static void main(String[] args) {
        DataTypesandVariables demo = new DataTypesandVariables();

        demo.demonstratePrimitiveTypes();
        demo.demonstrateImplicitCasting();
        demo.demonstrateExplicitCasting();
        demo.demonstrateStaticVsInstance();
        demo.demonstrateVariableScope();



        System.out.println("========== SUMMARY ==========");
        System.out.println("Primitive Types: byte, short, int, long, float, double, char, boolean");
        System.out.println("Implicit Casting: Automatic when converting to larger type");
        System.out.println("Explicit Casting: Required when converting to smaller type (may lose data)");
        System.out.println("Static Variables: Belong to class, shared by all instances");
        System.out.println("Instance Variables: Belong to object, each object has its own copy");
        System.out.println("Local Variables: Limited to method/block scope");
    }

    public void demonstratePrimitiveTypes() {
        System.out.println("========== PRIMITIVE DATA TYPES ==========");
        byte byteValue = 127;
        System.out.println("byte: " + byteValue + " (Size: 8 bits, Range: -128 to 127)");

        short shortValue = 32767;
        System.out.println("short: " + shortValue + " (Size: 16 bits, Range: -32,768 to 32,767)");


        int intValue = 2147483647;
        System.out.println("int: " + intValue + " (Size: 32 bits, Range: -2^31 to 2^31-1)");


        long longValue = 9223372036854775807L;
        System.out.println("long: " + longValue + " (Size: 64 bits, Range: -2^63 to 2^63-1)");


        float floatValue = 3.14159f;
        System.out.println("float: " + floatValue + " (Size: 32 bits, IEEE 754)");

        double doubleValue = 3.141592653589793;
        System.out.println("double: " + doubleValue + " (Size: 64 bits, IEEE 754)");

        char charValue = 'A';
        System.out.println("char: " + charValue + " (Size: 16 bits, Unicode)");

        boolean booleanValue = true;
        System.out.println("boolean: " + booleanValue + " (Size: JVM-dependent, Values: true/false)");

        System.out.println();
    }

    public void demonstrateImplicitCasting() {
        System.out.println("========== IMPLICIT TYPECASTING (Widening) ==========");

        byte b = 100;
        short s = b;        // byte → short (implicit)
        int i = s;          // short → int (implicit)

        System.out.println("byte: " + b);
        System.out.println("byte → short: " + s);
        System.out.println("short → int: " + i);

        // char to int (implicit)
        char ch = 'A';
        int charToInt = ch;
        System.out.println("char 'A' → int: " + charToInt + " (Unicode value)");
        System.out.println();
    }

    public void demonstrateExplicitCasting() {
        System.out.println("========== EXPLICIT TYPECASTING (Narrowing) ==========");

        double d = 123.456;
        float f = (float) d;    // double → float (explicit)
        long l = (long) f;       // float → long (explicit)

        System.out.println("double: " + d);
        System.out.println("double → float: " + f);
        System.out.println("float → long: " + l + " (decimal part lost)");

        int largeInt = 300;
        byte smallByte = (byte) largeInt;
        System.out.println("\nData Loss Example:");
        System.out.println("int 300 → byte: " + smallByte + " (overflow occurred)");

        int intValue = 65;
        char charValue = (char) intValue;
        System.out.println("int 65 → char: " + charValue + " (Unicode character)");

        System.out.println();
    }

    public void demonstrateStaticVsInstance() {
        System.out.println("========== STATIC vs INSTANCE VARIABLES ==========");

        // Access static variable without creating object
        System.out.println("Static variable (accessed via class): " + DataTypesandVariables.staticCounter);
        System.out.println("Static variable (accessed via class): " + DataTypesandVariables.staticMessage);

        // Access instance variable - requires object
        System.out.println("Instance variable: " + this.instanceId);
        System.out.println("Instance variable: " + this.instanceName);

        // Create multiple instances to show difference
        DataTypesandVariables obj1 = new DataTypesandVariables();
        DataTypesandVariables obj2 = new DataTypesandVariables();
        DataTypesandVariables obj3 = new DataTypesandVariables();

        System.out.println("\nAfter creating 3 objects:");
        System.out.println("obj1.instanceId: " + obj1.instanceId);
        System.out.println("obj2.instanceId: " + obj2.instanceId);
        System.out.println("obj3.instanceId: " + obj3.instanceId);
        System.out.println("staticCounter (shared): " + staticCounter);
        System.out.println("All objects share the same staticCounter value!");

        System.out.println();
    }

    public void demonstrateVariableScope() {
        System.out.println("========== VARIABLE SCOPE ==========");

        // LOCAL VARIABLE - scope limited to this method
        int localVar = 10;
        String localMessage = "I am a local variable";

        System.out.println("Local variable in method: " + localVar);
        System.out.println("Local message: " + localMessage);

        // INSTANCE VARIABLE - accessible throughout the object
        System.out.println("Instance variable (this.instanceId): " + this.instanceId);
        System.out.println("Instance variable (this.instanceName): " + this.instanceName);

        // STATIC VARIABLE - accessible throughout the class
        System.out.println("Static variable (staticCounter): " + DataTypesandVariables.staticCounter);
        System.out.println("Static variable (staticPi): " + DataTypesandVariables.staticPi);
        System.out.println("Static variable (staticMessage): " + DataTypesandVariables.staticMessage);
        System.out.println();
    }



}


