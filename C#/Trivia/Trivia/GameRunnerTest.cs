using System;
using System.IO;
using Xunit;

namespace Trivia
{
    public class GameRunnerTest
    {
        [Fact]
        public void RunGame()
        {
            using (var writer = File.CreateText(@"trivia-output.txt"))
            {
                Console.SetOut(writer);
                GameRunner.Run(new Random(11));
            }
        }
    }
}