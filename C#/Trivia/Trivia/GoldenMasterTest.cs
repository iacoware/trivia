using System;
using System.IO;
using Xunit;

namespace Trivia
{
    public class GoldenMasterTest
    {
        const string TriviaMaster = "trivia-master.txt";
        const string TriviaOutput = "trivia-output.txt";

        public GoldenMasterTest()
        {
            File.Delete(TriviaOutput);
        }

        [Fact]
        public void RunGame()
        {
            for (int i = 0; i < 100; i++)
            {
                //using (var writer = File.CreateText(TriviaMaster))
                using (var writer = File.CreateText(TriviaOutput))
                {
                    Console.SetOut(writer);
                    GameRunner.Run(new Random(i * 11));
                }
            }

            Assert.Equal(
                File.ReadAllText(TriviaMaster),
                File.ReadAllText(TriviaOutput));
        }
    }
}