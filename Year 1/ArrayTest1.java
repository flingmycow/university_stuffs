public class ArrayTest1
{
    public static void main(String[] args)
    {
        useArray();
        useList();
    }

    private static void useList()
    {
        ArrayList<String> mm = new ArrayList<String>();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String str = input.nextLine().trim();

        mm.add(str);
        System.out.println(mm);

        for (int k = 0; k < mm.size(); k++)
        {
            System.out.println("mm(" + k + ") = " + mm.get(k));
        }
    }

    private static void useArray()
    {
        String[] mm = new String[10];

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String str = input.nextLine().trim();

        System.out.println("Enter an index: ");
        int index = input.nextInt();

        if (index < mm.length)
        {
            mm[index] = str;
        }

        for (int k = 0; k < mm.length; k++)
        {
            System.out.println("mm[" + k + "] = " + mm[k]);
        }
    }
}
