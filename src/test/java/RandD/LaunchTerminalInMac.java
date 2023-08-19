package RandD;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchTerminalInMac {
    public static void main(String[] args) throws IOException {
        String osName=System.getProperty("os.name");
        System.out.println(osName);
        String macPath="";
        if (osName.contains("Windows")){
            		String dir="C:\\ChromeDataForMSD";
                    String cmdCommand = "chrome.exe -remote-debugging-port=9292 --no-first-run --no-default-browser-check --user-data-dir=" + dir;
		            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		            Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
        } else if (osName.contains("Mac")) {
            String command = "/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome --remote-debugging-port=9292 --user-data-dir="+macPath;
            String[] arguments = new String[]{"/bin/bash", "-c", command, "with", "args"};
            Process proc = new ProcessBuilder(arguments).start();
        }
    }
}
