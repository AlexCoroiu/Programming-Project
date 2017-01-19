package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Tui {
	
	default int port() {
		return readInt("Port: ");
	}	
	
	default String readString(String text) {
        System.out.print(text);
        String answer = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            answer = in.readLine();
        } catch (IOException e) {
        }

        return (answer == null) ? "" : answer;
    }
	
	default int readInt(String text) {
        System.out.print(text);
        String line = "";
        int answer = 0;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            line = in.readLine();
            answer = Integer.parseInt(line);
        } catch (IOException e) {        	
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + line
            		           + " is not an integer");
            readInt(text);
        }
        return answer;
    }
}
