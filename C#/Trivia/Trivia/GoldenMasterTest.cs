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
            using (var writer = File.CreateText(@"trivia-master.txt"))
            {
                Console.SetOut(writer);
                GameRunner.Run(new Random(11));
            }

            Assert.Equal(
                File.ReadAllText("trivia-master.txt"),
                File.ReadAllText("trivia-output.txt"));
        }
    }
}