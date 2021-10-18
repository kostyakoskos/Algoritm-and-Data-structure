using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;

namespace Frog
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> arr = new List<int>();
            StreamReader fs = new StreamReader(@"D:\Term 3\Frog\Frog\input.txt");
            string s = "";
            while (s != null)
            {
                s = fs.ReadLine();
                if (s != null)
                {
                    String[] words = s.Split(new char[] { ' ' });
                    for (int i = 0; i < words.Length; i++)
                    {
                        arr.Add(Convert.ToInt32(words[i]));
                    }
                }
            }
            if(arr[0] == 2 || arr[0] < 1)
            {
                using (var sw = File.AppendText(@"D:\Term 3\Frog\Frog\output.txt"))
                {
                    sw.WriteLine(-1);
                }
            }
            if(arr[0] == 1)
            {
                using (var sw = File.AppendText(@"D:\Term 3\Frog\Frog\output.txt"))
                {
                    sw.WriteLine(arr[1]);
                }
            }
            if(arr[0] == 3)
            {
                int Imax1 = arr[0];
                //*ввод с клавиатуры числа ступенек*

                int[] DP1 = new int[arr[0]];// массив размером с число ступенек

                for (int i = 0; i < Imax1; i++)//  0 1 2 3 4 5
                {
                    ///Ввод с клавиатуры стоимости ступеньки DP[i]	
                    DP1[i] = arr[i + 1];
                }
                
                using (var sw = File.AppendText(@"D:\Term 3\Frog\Frog\output.txt"))
                {
                    sw.WriteLine(DP1[0] + DP1[2]);
                }
            }
            if(arr[0] == 4)
            {
                using (var sw = File.AppendText(@"D:\Term 3\Frog\Frog\output.txt"))
                {
                    sw.WriteLine(arr[1] + arr[4]);
                }
            }
            if (arr[0] == 5)
            {
                using (var sw = File.AppendText(@"D:\Term 3\Frog\Frog\output.txt"))
                {
                    sw.WriteLine(arr[1] + arr[3] + arr[5]);
                }
            }
            if (arr[0] > 5)
            {
                int Imax = arr[0];
                //*ввод с клавиатуры числа ступенек*

                int[] DP = new int[arr[0]];// массив размером с число ступенек

                for (int i = 0; i < Imax; i++)//  0 1 2 3 4 5
                {
                    ///Ввод с клавиатуры стоимости ступеньки DP[i]	
                    DP[i] = arr[i + 1];
                }

                DP[2] += DP[0];
                DP[3] += DP[0];
                DP[4] += DP[2];
                for (int i = 5; i < arr[0]; i++)
                {
                    DP[i] += Math.Max(DP[i - 2], DP[i - 3]);
                }

                using (var sw = File.AppendText(@"D:\Term 3\Frog\Frog\output.txt"))
                {
                    sw.WriteLine(DP[Imax - 1]);
                }
                Console.WriteLine(DP[Imax - 1]);
                Console.ReadKey();
            }
            
        }
    }
}
