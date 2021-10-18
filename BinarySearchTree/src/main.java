
public class main {
    public static void main(String[] args) {
        //Создадим дерево с корневым элементом 33
        Tree<Integer> tree = new Tree<>(10, null);
        tree.add(5, 11, 12, 6, 3);
        //Распечатаем элементы дерева
       // tree.print();
        tree.printLRA();
        //Удалим корень
        tree.remove(5);
       // tree.print();
        tree.printLRA();
        //Проверяем элементы дерева
        System.out.println(tree);
        System.out.println(tree.left());
        System.out.println(tree.left().left());
        System.out.println(tree.right().left());
      }
}
