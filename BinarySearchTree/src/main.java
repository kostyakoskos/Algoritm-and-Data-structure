
public class main {
    public static void main(String[] args) {
        //�������� ������ � �������� ��������� 33
        Tree<Integer> tree = new Tree<>(10, null);
        tree.add(5, 11, 12, 6, 3);
        //����������� �������� ������
       // tree.print();
        tree.printLRA();
        //������ ������
        tree.remove(5);
       // tree.print();
        tree.printLRA();
        //��������� �������� ������
        System.out.println(tree);
        System.out.println(tree.left());
        System.out.println(tree.left().left());
        System.out.println(tree.right().left());
      }
}
