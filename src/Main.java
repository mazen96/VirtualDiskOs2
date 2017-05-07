import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Virtual File system.\n");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int blockSize;
		while(true)
		{
			System.out.print("Please Enter an even value for block size :: ");
			blockSize = sc.nextInt();
			if(blockSize % 2 == 0)
			{
				System.out.println();
				break;
			}
			System.out.println("\nERROR! Provided value is odd.");
		}
		
		Disk theDisk = new Disk(blockSize);
		
		@SuppressWarnings("unused")
		String ignore = sc.nextLine(); // :@@@@
		
		while(true)
		{
			System.out.print(">> ");
			String input = sc.nextLine();
			String [] inputArray = input.split(" ");
			
			if(inputArray[0].equals("CFile"))
			{
				theDisk.CreateFile(inputArray[1], inputArray[3], Integer.parseInt(inputArray[2]));
			}
			else if(inputArray[0].equals("CFolder"))
			{
				theDisk.CreateFolder(inputArray[1], inputArray[2]); // CFolder Folder1 VFSD: !! not !! CFolder Folder1 VFSD:\
			}
			else if(inputArray[0].equals("DeleteFile"))
			{
				theDisk.DeleteFile(inputArray[1]);
			}
			else if(inputArray[0].equals("DeleteFolder"))
			{
				theDisk.DeleteFolder(inputArray[1], inputArray[2]);
			}
			else if(inputArray[0].equals("DisplayDiskStatus"))
			{
				theDisk.DisplayDiskStatus();
			}
			else if(inputArray[0].equals("DisplayDiskStructure"))
			{
				theDisk.DisplayTreeStructure(); // check this function after testing !!!!!!!
			}
			else if(inputArray[0].equals("Exit"))
			{
				System.out.println("Terminating Program ...");
				System.exit(0);
			}
			else
			{
				System.out.println("Provided Command is not valid !!!");
			}
		}
		
	}
	


}
