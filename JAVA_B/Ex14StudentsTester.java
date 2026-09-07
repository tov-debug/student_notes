 

public class StudentsTester
{
    public static void main()
    {
        MatrixList ml = new MatrixList();
        ml = new MatrixList(new int[1][1]);
        int i = ml.getDataIJ (0, 0);
        ml.setDataIJ (0, 0, 0);
        System.out.println(ml);
        System.out.println("If there is a @ sign in the line above\n" +
            "(and not just a single 0)\n" +    
            "it means you didn't implement the toString method.");
        boolean b1 = ml.isDescending();
        int j = ml.howManyNegative();

        System.out.println("\n============================\n" +
            "If you see this message,\n" +
            "it means your software worked fine with this tester,\n" +
            "which only means you wrote all the expected methods\n" +
            "with the right interface.\n" +
            "It DOES NOT MEAN your software does exactly what it is\n" +
            "expected to do.\n" +
            "To check that, you will have to write your own tester\n" +
            "which must include all sorts of scenarios.\n" +
            "The bugs your tester doesn't find - will be found\n" +
            "by your instructor's tester, and will cost you\n" +
            "points in your grade.");

    }
}
