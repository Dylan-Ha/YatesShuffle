package cs146F20.Ha.project1;
import java.io.*;
import java.util.Random;

public class YatesShuffle {
	
	//method that creates random permutation of array[]
	static String[] shuffle(String[] array, int n)
	{
		//creates "random" object
		Random ran = new Random();
		//setting seed to 20 so answers are the same
		ran.setSeed(20);
		//starts from last element
		for(int i = n-1; i>0; i--)
		{
			//chooses random index from 0 to i
			int j = ran.nextInt(i+1);
			//swaps element at i with element at j
			String temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
	}
	
	public static void main(String args[]) throws Exception
	{
		//creates two arrays with String elements, size 7515 because line 1 is not needed
		String[] pair = new String[7515];
		String[] shuffled = new String[7515];
		//creating variables to be used later
		String read;
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
		//shuffled elements in array "pair"
		shuffled = shuffle(pair,7515);
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
		//closes bw and fw
		bw.close();
		fw.close();
	}
}
