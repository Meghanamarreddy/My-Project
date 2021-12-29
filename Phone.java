import java.util.Scanner;
public class Phone {
 public static void main(String s[]) {
 BinaryTree b = new BinaryTree();
 Scanner sc = new Scanner(System.in);
 int ch, ch1;
 System.out.print("\n**********WELCOME TO OUR PHONEBOOK**********\n");
 do {

 System.out.print("\n 1. Search \n 2. Insertion/Creation \n 3.
All Contacts Information \n 4. Removal \n 5. Change a Phonenumber \n 6. Exit \n");
15

 System.out.println("ENTER YOUR CHOICE:-");
 ch = sc.nextInt();
 switch (ch) {
 case 1:b.search();
 break;
 case 2:b.create();
 break;
 case 3:System.out.println("-----------------------------------------------
");
 System.out.println("NAME\t| CONTACT NUMBER |\tEMAIL");
 System.out.println("-----------------------------------------------
");
 b.display();
 System.out.println("-----------------------------------------------
");
 break;
 case 4:b.delete();
 break;
 case 5:b.update();
 break;
 case 6:System.out.println("EXITING FROM THE PHONEBOOK!...");
 break;
 }
 System.out.println("");
 System.out.println("Do you want to continue?(0/1)--OPERATIONS--");
 ch1 = sc.nextInt();
 } while (ch1==1);
 }
}
