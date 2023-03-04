import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static final Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        BST tree = new BST();
        System.out.println("Por favor ingrese los nombres a introducir en el arbol: ");
        String names = lector.nextLine();
        String[] array = names.split(" ");
        ArrayList<String> alist = new ArrayList<>();
        Collections.addAll(alist, array);
        ArrayList<String> blist = new ArrayList<>();
        OrganizeTree(alist, tree, blist);
        System.out.println("La lista en orden descendente es: ");
        tree.inOrder();
        System.out.println("-----------------------");
        for(int i = 0; i < blist.size(); i++){
            System.out.print(blist.get(i) + ",");
        }
    }
    public static void OrganizeTree(ArrayList<String> alist, BST tree, ArrayList<String> blist) {
        if (alist.isEmpty()) {
            return;
        }

        if (alist.size() == 1) {
            Node n = new Node(alist.get(0));
            tree.add(n);
            blist.add(alist.get(0));
            return;
        }

        int mid = alist.size() / 2;
        Node node = new Node(alist.get(mid));
        tree.add(node);
        blist.add(alist.get(mid));

        ArrayList<String> leftList = new ArrayList<>();
        ArrayList<String> rightList = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftList.add(alist.get(i));
        }
        for (int i = mid + 1; i < alist.size(); i++) {
            rightList.add(alist.get(i));
        }
        OrganizeTree(leftList, tree, blist);
        OrganizeTree(rightList, tree, blist);

    }



}