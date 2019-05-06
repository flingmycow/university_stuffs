class BandCard 
{
   // ----- constants ------------------------------------------------------

   private final String name;
   private final int volume;
   private final int attitude;
   private final int cool;
   private final int eclecticism;
   private final int hair;


   // ----- constructor ----------------------------------------------------


   public BandCard(String name,
                   int volume,
                   int attitude,
                   int cool,
                   int eclecticism,
                   int hair)
   {
      this.name = name;
      this.volume = volume;
      this.attitude = attitude;
      this.cool = cool;
      this.eclecticism = eclecticism;
      this.hair = hair;
   }


   // ----- methods --------------------------------------------------------

   public String getName()
   {
      return name;
   }

   public int getVolume()
   {
      return volume;
   }

   public int getAttitude()
   {
      return attitude;
   }

   public int getCool()
   {
      return cool;
   }

   public int getEclecticism()
   {
      return eclecticism;
   }

   public int getHair()
   {
      return hair;
   }
 
   public static void main(String[] args)
   {
      BandCard bc = new BandCard("Goldfrapp", 5, 3, 7, 17, 12);

      // should be: "Goldfrapp"
      System.out.println(bc.getName());

      // should be: 5
      System.out.println(bc.getVolume());

      // should be: 3
      System.out.println(bc.getAttitude());

      // should be: 7
      System.out.println(bc.getCool());

      // should be: 17
      System.out.println(bc.getEclecticism());

      // should be: 12
      System.out.println(bc.getHair());
   }
}


public class List 
{
   private Node theList;


   public List()
   {
   	   theList = null;
   }


   public void add(BandCard b)
   {
      theList = new Node(b, theList);
   }


   public int length()
   {
      // stores the number of nodes found so far
      int len = 0;

      // this variable traverses each node in the list
      Node n = theList;

      // find the end of the list
      while (n != null)
      {
         // found a node, so count it and move on
         len++;
         n = n.tail();
      }

      return len;
   }


   public void addend(BandCard b)
   {
      if (theList == null)
      {
         theList = new Node(b);
      }
      else
      {
         // this variable traverses each node in the list
         Node n = theList;

         // find the last node in the list...
         while (n.tail() != null)
         {
            n = n.tail();
         }
         // ... and add b
         n .addend(b);
      }

   }
}




class Node
{

   private BandCard head;

   private Node tail;


   public Node(BandCard b)
   {
      head = b;
   }


   public Node(BandCard b, Node t)
   {
      head = b;
      tail = t;
   }


   public BandCard head()
   {
      return head;
   }

   public Node tail()
   {
      return tail;
   }

   public void addend(BandCard b)
   {
      tail = new Node(b);
   }
}
