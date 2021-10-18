using System;
using System.IO;

namespace Turtle
{
    class Program
    {
        static void Main(string[] args)
        {
            StreamReader fs = new StreamReader(@"D:\Term 3\Algoritm and Data Structure\Turtle\input.txt ");
            string s = fs.ReadLine();
            int Imax = Convert.ToInt16(s.Split(" ")[0]), Jmax = Convert.ToInt16(s.Split(" ")[1]);
            int[,] dp = new int[Imax, Jmax];
            for (int i = 0; i < Imax; i++)
            {
                for (int j = 0; j < Jmax; j++)
                {
                    if (i == 0 || j == 0)
                    {
                        dp[i, j] = 1;
                    }
                    else
                    {
                        dp[i, j] = dp[i - 1, j] + dp[i, j - 1] % 1000000007;
                    }
                }
            }
            using (var sw = File.AppendText(@"D:\Term 3\Algoritm and Data Structure\Turtle\output.txt "))
            {
                sw.WriteLine(dp[Imax - 1, Jmax - 1]);
            }
        }
    }
}
