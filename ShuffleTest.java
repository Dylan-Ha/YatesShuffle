package cs146F20.Ha.project1;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.Test;
import java.io.*;

class ShuffleTest {

	@Test
	public void Test1()
	{
		
		String expectedLine;
		try
		{
			//creates file readers for the target file and the file with the shuffled elements
			
			FileReader frOut = new FileReader("data/Target3.txt");
			BufferedReader brOut = new BufferedReader(frOut);
			FileReader frIn = new FileReader("data/HaDylanShuffled.txt");
			BufferedReader brIn = new BufferedReader(frIn);
			
			//compares the elements line per line and checks if they are the same
			while((expectedLine = brIn.readLine())!=null)
			{
				String actualLine = brOut.readLine();
				assertEquals(expectedLine, actualLine);	
			}
			brOut.close();
			brIn.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	//copy and pasted from my main method
	@Test
	public void Test2() throws IOException
	{
		
		//creates one array and a YatesShuffle object so method shuffle can be called
		String[] pair = new String[7515];
		YatesShuffle shuf = new YatesShuffle();
		//creating variables to be used later
		String read;
		long a = 0;
		long b,c,d;
		long input,shuffle,output;
		a = System.currentTimeMillis();
		FileWriter fw = null;
		BufferedWriter bw = null;
		//try-catch in case files do not exist
		try
		{
			int i = 0;
			//creates a filewriter and bufferedwriter, bufferedwriter takes filewriter as variables
			
			fw = new FileWriter("data/HaDylanShuffled.txt");
			bw = new BufferedWriter(fw);
			//creates filereader and bufferedreader,bufferedreader takes filereader as variables
			FileReader fr = new FileReader("data/ErdosCA.txt");
			BufferedReader br = new BufferedReader(fr);
			//skips the first line 
			br.readLine();
			//adds elements to the array "pair" as long as bufferedreader keeps reading lines
			while((read = br.readLine())!=null)
			{
				
				pair[i]=read;
				i++;
			}
			
			//closes br and fr
			br.close();
			fr.close();
			
		}
		//throws exception if files do not exist
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		b = System.currentTimeMillis();
		//shuffled elements in array "pair"
		
		String [] shuffled = shuf.shuffle(pair,7515);
		
		c = System.currentTimeMillis();
		//appends data into new file
		for(String s: shuffled)
		{
			
			try
			{
				bw.append(s);
				bw.newLine();
				
			}
			//throws exception if conditions not met
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		d = System.currentTimeMillis();
		//closes bw and fw
		bw.close();
		fw.close();
		//input is the difference between the start and finish of the reading of the file
		//shuffle is the difference between the start and finish of the shuffling
		//output is the difference between the start and finish of putting the elements in the new file
		input = b-a;
		shuffle = c-b;
		output = d-c;
		System.out.println("Input: " + input);
		System.out.println("Shuffle: " + shuffle);
		System.out.println("Output: " + output);
	}
}
	


