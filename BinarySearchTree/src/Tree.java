import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {
	private T val;
	private Tree left;
	private Tree right;
	private Tree parent;
	private List<T> listForPrint = new ArrayList<>();
    public List<Tree> MaxDifferHeightList = new ArrayList<>();
    
    public int highDiffer = 0;
    
	public T val() {
		return val;
	}

	public Tree left() {
		return left;
	}

	public Tree right() {
		return right;
	}

	public Tree parent() {
		return parent;
	}

	public Tree(T val, Tree parent) {
		this.val = val;
		this.parent = parent;
	}

	public void add(T... vals) {
		for (T v : vals) {
			add(v);
		}
	}

	public void add(T val) {
		if (val.compareTo(this.val) < 0) {
			if (this.left == null) {
				this.left = new Tree(val, this);
			} else if (this.left != null)
				this.left.add(val);
		} else {
			if (this.right == null) {
				this.right = new Tree(val, this);
			} else if (this.right != null)
				this.right.add(val);
		}
	}

	private Tree<T> _search(Tree<T> tree, T val) {
		if (tree == null)
			return null;
		switch (val.compareTo(tree.val)) {
		case 1:
			return _search(tree.right, val);
		case -1:
			return _search(tree.left, val);
		case 0:
			return tree;
		default:
			return null;
		}
	}

	public Tree<T> search(T val) {
		return _search(this, val);
	}

	public boolean remove(T val) {
		// Проверяем, существует ли данный узел
		Tree<T> tree = search(val);
		if (tree == null) {
			// Если узла не существует, вернем false
			return false;
		}
		Tree<T> curTree;
		// Если удаляем корень
		if (tree == this) {
			if (tree.right != null) {
				curTree = tree.right;
			} else
				curTree = tree.left;
			while (curTree.left != null) {
				curTree = curTree.left;
			}
			T temp = curTree.val;
			this.remove(temp);
			tree.val = temp;
			return true;
		}
		// Удаление листьев
		if (tree.left == null && tree.right == null && tree.parent != null) {
			if (tree == tree.parent.left)
				tree.parent.left = null;
			else {
				tree.parent.right = null;
			}
			return true;
		}
		// Удаление узла, имеющего левое поддерево, но не имеющее правого поддерева
		if (tree.left != null && tree.right == null) {
			// Меняем родителя
			tree.left.parent = tree.parent;
			if (tree == tree.parent.left) {
				tree.parent.left = tree.left;
			} else if (tree == tree.parent.right) {
				tree.parent.right = tree.left;
			}
			return true;
		}
		// Удаление узла, имеющего правое поддерево, но не имеющее левого поддерева
		if (tree.left == null && tree.right != null) {
			// Меняем родителя
			tree.right.parent = tree.parent;
			if (tree == tree.parent.left) {
				tree.parent.left = tree.right;
			} else if (tree == tree.parent.right) {
				tree.parent.right = tree.right;
			}
			return true;
		}
		// Удаляем узел, имеющий поддеревья с обеих сторон
		if (tree.right != null && tree.left != null) {

			//curTree = tree.right;
			
//			while (curTree.left != null) {
//				curTree = curTree.left;
//			}
			
			curTree = tree.left;
			curTree = curTree.left;
			
			
			
			// Если самый левый элемент является первым потомком
//			if (curTree.parent == tree) {
//				curTree.left = tree.left;
//				tree.left.parent = curTree;
//				curTree.parent = tree.parent;
//				if (tree == tree.parent.left) {
//					tree.parent.left = curTree;
//				} else if (tree == tree.parent.right) {
//					tree.parent.right = curTree;
//				}
//				return true;
//			}
//			// Если самый левый элемент НЕ является первым потомком
//			else {
//				if (curTree.right != null) {
//					curTree.right.parent = curTree.parent;
//				}
//				curTree.parent.left = curTree.right;
//				curTree.right = tree.right;
//				curTree.left = tree.left;
//				tree.left.parent = curTree;
//				tree.right.parent = curTree;
//				curTree.parent = tree.parent;
//				if (tree == tree.parent.left) {
//					tree.parent.left = curTree;
//				} else if (tree == tree.parent.right) {
//					tree.parent.right = curTree;
//				}
//				return true;
//			}
		}
		return false;
	}

	private void _print(Tree<T> node) {
		if (node == null)
			return;
		_print(node.left);
		listForPrint.add(node.val);
		System.out.print(node + " ");
		if (node.right != null)
			_print(node.right);
	}

	public void print() {
		listForPrint.clear();
		_print(this);
		System.out.println();
	}
	
	private void _printLRA(Tree<T> node) {
		if (node == null)
			return;
		listForPrint.add(node.val);
		System.out.print(node + " ");
		
		if (node.left != null)
			_printLRA(node.left);
		
		if (node.right != null)
			_printLRA(node.right);
	}

	public void printLRA() {
		listForPrint.clear();
		_printLRA(this);
		System.out.println();
	}
	
	 public void CountHeightDifferLRA()
     {
         CountItemHeightDifferLRA(this);
     }
	 
     private void CountItemHeightDifferLRA(Tree<T> node) {
    	 if (node.left != null) {
             CountItemHeightDifferLRA(node.left);
         }
    	 if(node.right != null) {
    		 CountItemHeightDifferLRA(node.right);
    	 }
    	 if (node.left == null && node.right == null)
         {
             node.highDiffer = 0;
         }
    	 else
         {
             if (node.left == null && node.right != null)
             {
                 node.highDiffer = node.right.highDiffer + 1;
             }
             if (node.right == null && node.left != null)
             {
                 node.highDiffer = node.left.highDiffer + 1;
             }
             if (node.left != null && node.right != null)
             {
                 node.highDiffer = Math.abs(node.right.highDiffer - node.left.highDiffer);
             }
             if (node.left != null && node.right != null && node == this)
             {
                 node.highDiffer = Math.abs(node.right.highDiffer - node.left.highDiffer) + 1;
             }
         }
         if (MaxDifferHeightList.size() == 0 || MaxDifferHeightList.First().highDiffer == node.highDiffer)
         {
             MaxDifferHeightList.add(node);
         }
         else
         {
             if (MaxDifferHeightList.First().highDiffer < node.highDiffer)
             {
                 MaxDifferHeightList.clear();
                 MaxDifferHeightList.add(node);
             }
         }
     }
	
	@Override
	public String toString() {
		return val.toString();
	}
}
