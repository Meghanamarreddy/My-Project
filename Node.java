import java.util.Scanner;
class node
{
 node left;
 node right;
 String name;
 String number;
 String email;
 public node(String name, String no, String email) {
 left = null;
 right = null;
 this.name = name;
 this.number = no;
 this.email = email;
 }
}
class BinaryTree {
 Scanner sc = new Scanner(System.in);
 public static node root;
 String name;
 String no;
 String email;
 private char s;
 int ch;
 BinaryTree() {
 root = null;
 }
 int flag = 0;
 String checknumber(String number)
 {
 while (number.length() != 10) {
 System.out.println("\nThe Contact Number Must 10 Digit!...\n");
 System.out.println("PLEASE ENTER VALID NUMBER!...");
 number = sc.next();
 }
 return number;
 }
 public void create()
 {
 Scanner sc = new Scanner(System.in);
 int ch, flag = 0, flag1 = 0;
 node ptr, any;
 do {
 System.out.println("\nEnter the Name : ");
 name = sc.next();
 System.out.println("\nEnter the phone no: ");
 no = sc.next();
 no=checknumber(no);
 any = root;
11
 while (any != null) {
 if (any.number.compareTo(no) == 0) {
 flag = 1;
break;
 }
 if ((any.number).compareTo(no) > 0) {
 any = any.left;
 } else {
 any = any.right;
 }
 }
 if (flag == 1) {
 System.out.println("This Number is Already Present in Phonebook!...");
 System.out.println("Enter Some Different Number!...");
 no=sc.next();
 no=checknumber(no);
 }
 System.out.println("\nEnter the Email id : ");
 email = sc.next();
 int m = email.length() - 1;
 while (m != -1) {
 if (email.charAt(m) == '@') {
 flag1 = 1;
 }
 if (email.charAt(m) == '.') {
 flag1 = 2;
break;
 }
 m--;
 }
 if (flag1 != 2) {
 System.out.println("Enter Valid Email address :");
 email = sc.next();
 }
 node temp = new node(name, no, email);
 if (root == null) {
 root = temp;
 }
 else {
 ptr = root;
 while (flag == 0) {
 if ((temp.name).compareTo(ptr.name) > 0) {
 if (ptr.right != null) {
 ptr = ptr.right;
 } else {
 ptr.right = temp;
 flag = 1;
 }
 }
if ((temp.name).compareTo(ptr.name) < 0) {
 if (ptr.left != null) {
 ptr = ptr.left;
 } else {
 ptr.left = temp;
 flag = 1;
 }
 }
 }
12
 }
 flag = 0;
 System.out.println("");
 System.out.println("Do you want to Add any Phone Record (0/1): ");
 ch = sc.nextInt();
 } while (ch != 0);
 }
 public void insert() {
 create();
 }
 public void update() {
 int flag = 0;
 node ptr;
 System.out.println("Enter a Contact Name you want to update");
 Scanner scan = new Scanner(System.in);
 String key = scan.next();
 ptr = root;
 while (ptr != null) {
 if ((ptr.name).compareTo(key) == 0) {
 flag = 1;
 break;
 }
 if ((ptr.name).compareTo(key) > 0) {
 ptr = ptr.left;
 } else {
 ptr = ptr.right;
 }
 }
 if (flag == 1) {
 System.out.println("Enter New Number : ");
 String new1;
 new1 = sc.next();
 ptr.number = new1;
 }
 }
 public void search() {
 int flag = 0;
 node ptr;
 System.out.println("Enter a Name tobe searched");
 String key = sc.next();
 ptr = root;
 while (ptr != null)
 {
 if (ptr.name.compareTo(key) == 0) {
 flag = 1;
 System.out.println("\n\t-----RECORD FOUND-----");

 System.out.println("-----------------------------------------------");
 System.out.println("NAME\t| CONTACT NUMBER |\tEMAIL");
 System.out.println("-----------------------------------------------");
 System.out.println("" + ptr.name + "\t " + ptr.number + "\t " +
ptr.email);
13
 break;
 }
 if ((ptr.name).compareTo(key) > 0) {
 ptr = ptr.left;
 } else {
 ptr = ptr.right;
 }
 }
 if (flag == 0) {
 System.out.println("-----RECORD NOT FOUND-----");
 }
 }
 public void delete() {
 int flag = 0;
 node ptr, parent = null;
 System.out.println("Enter a Contact name you want to delete");
 Scanner scan = new Scanner(System.in);
 String key = scan.next();
 ptr = root;
 while (ptr != null) {
 if ((ptr.name).compareTo(key) == 0)
 {
 flag = 1;
 break;
 }
 if ((ptr.name).compareTo(key) > 0)
 {
 parent = ptr;
 ptr = ptr.left;
 }
 else
 {
 parent = ptr;
 ptr = ptr.right;
 }
 }
 System.out.println(ptr.name);
 if (flag == 1) {
 if (ptr.left != null && ptr.right == null) {
 if (parent.left == ptr) {
 parent.left = ptr.left;
 } else {
 parent.right = ptr.left;
 }
 }
 if (ptr.left == null && ptr.right != null) {
 if (parent.left == ptr) {
 parent.left = ptr.right;
 } else {
 parent.right = ptr.right;
 }
 }
 if (ptr.left != null && ptr.right != null) {
 node p;
 p = ptr.left;
 System.out.println("ptr= " + ptr.name);
14
 while (p.right != null) {
 parent = p;
 p = p.right;
 }
 ptr.name = p.name;
 ptr.number = p.number;
 if (p.left != null) {
 parent.right = p.left;
 } else {
 ptr.left = null;
 }
 }
 if (ptr.left == null && ptr.right == null) {
 if (parent.left == ptr) {
 parent.left = null;
 } else {
 parent.right = null;
 }
 }
 }
 }
 public void inorder(node root)
 {
 if (root != null) {
 inorder(root.left);

 System.out.println("" + root.name + "\t " + root.number + "\t " +
root.email);
 inorder(root.right);
 }
 }
 public void display() {
 inorder(root);
 }
}
