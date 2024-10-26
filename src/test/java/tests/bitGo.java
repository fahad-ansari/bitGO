package tests;
import baseTest.baseTest;
import org.testng.annotations.Test;
import pages.blocksPage;

public class bitGo extends baseTest{

@Test
    public void Task1(){
    blocksPage bP = launchApp();
    bP.checkContainsValue();
}

@Test
    public void Task2(){
    blocksPage nP = launchApp();
    nP.fetchTranscations();
}



}
