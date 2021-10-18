using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;

//1. Если нет левого или правого сына то -1 а не 0
//2. Сделать правильный обход

namespace BinaryTree
{
    class Program
    {
        static void Main()
        {
            ArrayList arr = new ArrayList();
            StreamReader fs = new StreamReader("tst.in");
            string s = "";
            while (s != null)
            {
                s = fs.ReadLine();
                if (s != null)
                {
                    arr.Add(Convert.ToInt16(s));
                }
            }
            int a = arr.Count;
            Tree tr = new Tree();

            foreach (var item in arr)// заполняем arraylist
            {
                if (tr.Insert(Convert.ToInt32(item)))
                {
                    a--;
                }
                else
                {
                    a--;
                }
            }
            tr.CountHeightDifferLRA();
            tr.PrintHeightDifferLRA();
            tr.PrintMaxDifferHeightItems();
            tr.Delete(tr.DeleteLAR(arr.Count));
            //Console.WriteLine("After delete");
            tr.PrintALR();
            tr.FileALR();
            //Console.ReadKey();
        }
    }

    /// <summary>
    /// Класс "Бинарное поисковое дерево"
    /// </summary>
    public class Tree
    {
        public int countSum = 0;
        /// <summary>
        /// Класс "узел БПД"
        /// </summary>
        private class Item
        {
            /// <summary>
            /// info - значение, хранящееся в узле
            /// lSon, rSon, father - ссылки на левого, правого сына и отца
            /// </summary>
            public int info, highDiffer, maxLong; // highDiffer- модуль разности высот левого и правого поддерева для каждого элемента
            public Item lSon, rSon, father;
            /// <summary>
            /// Конструктор узла БПД
            /// </summary>
            /// <param name="x">значение, хранящееся в узле</param>
            public Item(int x)
            {
                info = x;
                lSon = rSon = father = null;
            }
        }

        /// <summary>
        /// ссылка на корень дерева
        /// </summary>
        private Item root;

        private List<Item> MaxDifferHeightList;

        /// <summary>
        /// конструктор дерева
        /// </summary>
        public Tree()
        {
            root = null;
            MaxDifferHeightList = new List<Item>();
        }

        /// <summary>
        /// внутренняя процедура поиска
        /// </summary>
        /// <param name="x">искомое значение</param>
        /// <param name="p">ели найдено - ссылка на соответствующий узел, иначе - ссылка на то место, где остановились</param>
        /// <returns>нашли или нет</returns>
        private bool Find(int x, out Item p)
        {
            p = root;
            Item q = p;
            while (q != null)
            {
                p = q;
                if (q.info == x)
                    return true;
                if (q.info < x)
                    q = q.rSon;
                else
                    q = q.lSon;
            }
            return false;
        }

        /// <summary>
        /// внешняя процедура поиска
        /// </summary>
        /// <param name="x">искомое значение</param>
        /// <returns>нашли или нет</returns>
        public bool Find(int x)
        {
            Item p;
            return Find(x, out p);
        }

        /// <summary>
        /// втавка в БДП
        /// </summary>
        /// <param name="x">вставляемое значение</param>
        /// <returns>смогли вставить или нет</returns>
        public bool Insert(int x)
        {
            Item r, p;
            if (root == null)
            {
                r = new Item(x);
                root = r;
                return true;
            }
            if (Find(x, out r))
            {
                return false;
            }
            p = new Item(x);
            p.father = r;
            if (r.info < x)
                r.rSon = p;
            else
                r.lSon = p;
            return true;
        }

        /// <summary>
        /// удалить вершину (оборвать все ссылки)
        /// </summary>
        /// <param name="x">удаляемая вершина</param>
        private void deleteItem(Item x)
        {
            if (x.father == null)
                if (x.lSon != null)
                {
                    root = x.lSon;
                    x.lSon.father = null;
                }
                else
                {
                    root = x.rSon;
                    if (x.rSon != null)
                        x.rSon.father = null;
                }
            else
            if (x.father.lSon == x)
                if (x.lSon != null)
                {
                    x.father.lSon = x.lSon;
                    x.lSon.father = x.father;
                }
                else
                {
                    x.father.lSon = x.rSon;
                    if (x.rSon != null)
                        x.rSon.father = x.father;
                }
            else
                if (x.lSon != null)
            {
                x.father.rSon = x.lSon;
                x.lSon.father = x.father;
            }
            else
            {
                x.father.rSon = x.rSon;
                if (x.rSon != null)
                    x.rSon.father = x.father;
            }
            x.father = x.lSon = x.rSon = null;
        }

        /// <summary>
        /// Удалить вершину по значению
        /// </summary>
        /// <param name="x">удаляемое значение</param>
        /// <returns>смогли удалить или нет</returns>
        public bool Delete(int x)
        {
            Item r, p;
            if (!Find(x, out r))
                return false;
            if ((r.lSon == null) || (r.rSon == null))
            {
                deleteItem(r);
                return true;
            }
            p = r.lSon;
            while (p.rSon != null)
                p = p.rSon;
            r.info = p.info;
            deleteItem(p);
            return true;
        }

        List<int> asd = new List<int>();

        public void FileALR()// action left right
        {
            //Console.WriteLine("Дерево прямым левым обходом:");
            // PrintItemALR(this.root);
            //Console.WriteLine();
            using (var sw = File.AppendText("tst.out"))
            {
                foreach (int mp in asd)
                {
                    sw.WriteLine(mp);
                }
            }
        }

        public void PrintALR()// action left right
        {
            //Console.WriteLine("Дерево прямым левым обходом:");
            PrintItemALR(this.root);
            //Console.WriteLine();
        }

        private void PrintItemALR(Item item)
        {
            // Action
            //Console.Write(item.info + " ");
            asd.Add(item.info);
            if (item.lSon != null)
            {
                PrintItemALR(item.lSon);
            }
            if (item.rSon != null)
            {
                PrintItemALR(item.rSon);
            }
        }

        public void PrintLRA()// left right action
        {
            //Console.WriteLine("Дерево обратным левым обходом:");
            PrintItemLRA(this.root);
            //Console.WriteLine();
        }

        private void PrintItemLRA(Item item)
        {
            if (item.lSon != null)
            {
                PrintItemLRA(item.lSon);
            }
            if (item.rSon != null)
            {
                PrintItemLRA(item.rSon);
            }
            // Action
            //Console.Write(item.info + " ");
        }

        public void PrintHeightDifferLRA()// left right action
        {
            //Console.WriteLine("Разница высот узлов обратным левым обходом:");
            PrintItemHeightDifferLRA(this.root);
            //Console.WriteLine();
        }

        private void PrintItemHeightDifferLRA(Item item)
        {
            if (item.lSon != null)
            {
                PrintItemHeightDifferLRA(item.lSon);
            }
            if (item.rSon != null)
            {
                PrintItemHeightDifferLRA(item.rSon);
            }
            // Action
            //Console.Write(item.info + " " + item.maxLong + "\r\n");
        }

        public void CountHeightDifferLRA()
        {
            CountItemHeightDifferLRA(this.root);
        }

        private void CountItemHeightDifferLRA(Item item)
        {
            if (item.lSon != null)
            {
                CountItemHeightDifferLRA(item.lSon);
            }
            if (item.rSon != null)
            {
                CountItemHeightDifferLRA(item.rSon);
            }
            // Action
            if (item.lSon == null && item.rSon == null)
            {
                item.highDiffer = 0;
                item.maxLong = 0;
            }
            else
            {
                if (item.lSon == null && item.rSon != null)
                {
                    item.highDiffer = item.rSon.highDiffer + 1;
                    item.maxLong = item.rSon.highDiffer + 1;
                }
                if (item.rSon == null && item.lSon != null)
                {
                    item.highDiffer = item.lSon.highDiffer + 1;
                    item.maxLong = item.lSon.highDiffer + 1;
                }
                if (item.lSon != null && item.rSon != null)
                {
                    item.maxLong = Math.Max(item.rSon.highDiffer, item.lSon.highDiffer);
                    item.highDiffer = Math.Abs(item.rSon.highDiffer - item.lSon.highDiffer);
                }
            }
            if ((MaxDifferHeightList.Count == 0 || MaxDifferHeightList.First().highDiffer == item.highDiffer) && item.maxLong == 2)
            {
                MaxDifferHeightList.Add(item);
            }
            else
            {
                //if (MaxDifferHeightList.First().highDiffer < item.highDiffer)
                //{
                //    MaxDifferHeightList.Clear();
                //    MaxDifferHeightList.Add(item);
                //}
                if (2 == item.maxLong)
                {
                    //MaxDifferHeightList.Clear();
                    MaxDifferHeightList.Add(item);
                }
            }
        }

        public void PrintMaxDifferHeightItems()
        {
            if (MaxDifferHeightList.Count == 0)
            {
                //Console.WriteLine("Пустой список. Для вывода результата нжно сначало запустить подсчёт!");
            }
            else
            {
                //Console.WriteLine("Список узлов с максимальным модулем разности высот поддеревьев:");
                foreach (var el in MaxDifferHeightList)
                {
                    //Console.WriteLine("Элемент " + el.info + ", модуль разности высот = " + el.highDiffer);
                }
            }
        }

        public void Delete(int x, bool isLeftDel)
        {
            Func<Item, Item> findMethod = FindForRightDel;
            if (isLeftDel) findMethod = FindForLeftDel;
            root = DeleteRecursively(root, x, findMethod, isLeftDel);
        }

        private Item DeleteRecursively(Item v, int x, Func<Item, Item> findMethod, bool isLeftDel)
        {
            if (v == null) return null;
            if (x < v.info)
            {
                v.lSon = DeleteRecursively(v.lSon, x, findMethod, isLeftDel);
                return v;
            }

            if (x > v.info)
            {
                v.rSon = DeleteRecursively(v.rSon, x, findMethod, isLeftDel);
                return v;
            }

            // v.info == x
            if (v.lSon == null)
                return v.rSon;
            if (v.rSon == null)
                return v.lSon;

            //both subtrees are present
            var findedKey = findMethod(isLeftDel ? v.lSon : v.rSon).info;
            v.info = findedKey;
            var result = DeleteRecursively(isLeftDel ? v.lSon : v.rSon, findedKey, findMethod, isLeftDel);
            if (isLeftDel)
            {
                v.lSon = result;
            }
            else
            {
                v.rSon = result;
            }

            return v;
        }

        private Item FindForRightDel(Item v)
        {
            if (v.lSon != null) return FindForRightDel(v.lSon);
            return v;
        }

        private Item FindForLeftDel(Item v)
        {
            if (v.rSon != null) return FindForLeftDel(v.rSon);
            return v;
        }

        //public int DeleteNumber(int a)
        //{
        //    Console.WriteLine("Удаляем номер: ");
        //    return 0;
        //}
        static int counterNumDelete = 0, count = 0;
        public int DeleteLAR(int a)
        {
            //Console.WriteLine("Удаляемая вершина:");
            return PrintItemLAR(this.root, a);
        }

        private int PrintItemLAR(Item item, int a)
        {
            //foreach (Item res in MaxDifferHeightList)
            //{
            //    Console.WriteLine(res.info + "!");
            //}

            //Console.ReadKey();
            if (MaxDifferHeightList.Count % 2 == 1)
            {
                if (item.lSon != null)
                {
                    PrintItemLAR(item.lSon, a);
                }
                counterNumDelete++;
                if (MaxDifferHeightList.Count % 2 == 1)
                {
                    if (counterNumDelete >= a / 2 && count == 0 && MaxDifferHeightList.Contains(item))
                    {
                        count = item.info;
                        //Console.WriteLine(item.info + " ");
                        counterNumDelete = -int.MaxValue;
                        return count;
                    }
                }
                //else
                //{
                //    if (counterNumDelete > a / 2 && count == 0 && MaxDifferHeightList.Contains(item))
                //    {
                //        count = item.info;
                //        //Console.WriteLine(item.info + " ");
                //        counterNumDelete = -int.MaxValue;
                //        return count;
                //    }
                //}
                // Action
                //Console.Write(item.info + " ");
                if (item.rSon != null)
                {
                    PrintItemLAR(item.rSon, a);
                }
                return count;
            }
            return -100;
        }
    }
}

