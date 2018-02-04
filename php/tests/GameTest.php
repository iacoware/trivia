<?php

include __DIR__.'/../GameShell.php';
use PHPUnit\Framework\TestCase;

class GoldenMasterTest extends TestCase
{
    const GOLDEN_MASTER = 'trivia-golden-master.txt';
    const CURRENT_OUTPUT = 'trivia-current-output.txt';

    public function _testUpdateGoldenMaster() {
        $this->runGameMultipleTimes(self::GOLDEN_MASTER);
    }

    public function testGameRun() {
        $this->runGameMultipleTimes(self::CURRENT_OUTPUT);

        $golden_master = file_get_contents(self::GOLDEN_MASTER);
        $current_output = file_get_contents(self::CURRENT_OUTPUT);
        $this->assertEquals($golden_master, $current_output);
    }

    public function runGameMultipleTimes($outputFile) {
        $ob_file = fopen($outputFile, 'w');
        $ob_file_callback = function($buffer) use ($ob_file) {
            fwrite($ob_file, $buffer);
        };
        ob_start($ob_file_callback);

        for($i = 0; $i < 20; $i++) {
            srand(11 * $i);
            run();
        }

        ob_end_flush();
    }
}
?>