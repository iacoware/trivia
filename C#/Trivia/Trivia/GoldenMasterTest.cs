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

        [Fact(Skip = "Run only when we need to update the golden master")]
        public void UpdateMaster()
        {
            MultipleRuns(TriviaMaster);
        }

        [Fact]
        public void RunGame()
        {
            MultipleRuns(TriviaOutput);

            Assert.Equal(
                File.ReadAllText(TriviaMaster),
                File.ReadAllText(TriviaOutput));
        }

        static void MultipleRuns(string outputFile)
        {
            var prevConsoleOut = Console.Out;

            try
            {
                for (int i = 0; i < 100; i++)
                {
                    using (var writer = File.CreateText(outputFile))
                    {
                        Console.SetOut(writer);
                        GameRunner.Run(new Random(i * 11));
                    }
                }
            }
            finally
            {
                Console.SetOut(prevConsoleOut);
            }
        }
    }
}