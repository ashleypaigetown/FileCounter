import java.io.*; public class CharacterFrequency {

public static void main(String[] args) 
		throws IOException {
	int[] letterCount = new int [127];
	int next;
	FileReader inputStream = new FileReader("wap.txt");
	PrintWriter outfile = new PrintWriter("textCh.out");
	
	next = inputStream.read();
	
	while (next != -1)
	{
		next = copyText(inputStream, outfile, next, letterCount);
		
		
		next = inputStream.read();
	}//end while loop
	
	writeTotal(outfile, letterCount);
	
	outfile.close();
}

static int copyText(FileReader infile, PrintWriter outfile, int next, int[] letterC) throws IOException
{
	while (next != (int) '\n')
	{
		outfile.print((char) (next));
		chCount((char) (next), letterC);
		next = infile.read();
	}
	
	outfile.println();
	return next;
}

static void chCount(char ch, int[] letterC)
{
	int index;
	
	//ch = Character.toUpperCase(ch); //step a 
	index = (int) ch - 32; //step b
	
	if (index >= 0 && index < 127)
		letterC[index]++; //step C
}

static void writeTotal(PrintWriter outfile, int[] letters)
{
	outfile.println();
	for (int i = 0; i < 127; i++)
		outfile.println((char) (i + 32) + " count = " + letters[i]);
}
}