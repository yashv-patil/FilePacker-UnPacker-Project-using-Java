import java.io.*;
import javax.swing.*;

class FilePacker implements Runnable
{
    public void run()
    {
        JFrame frame = new JFrame("Java File Packer");

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel folderLabel = new JLabel("Folder Name that Exist:");
        folderLabel.setBounds(30, 50, 150, 30);

        JTextField folderText = new JTextField();
        folderText.setBounds(30, 80, 220, 30);

        JLabel fileLabel = new JLabel("Pack File Name:");
        fileLabel.setBounds(30, 130, 120, 30);

        JTextField fileText = new JTextField();
        fileText.setBounds(30, 160, 220, 30);

        JButton packButton = new JButton("Pack");
        packButton.setBounds(90, 220, 100, 35);

        packButton.addActionListener(e ->                               // Very Importent
        {
            String folderName = folderText.getText();
            String packFileName = fileText.getText();

            packFiles(folderName, packFileName);                        // Function Call 

            frame.dispose();
        });

        frame.add(folderLabel);
        frame.add(folderText);

        frame.add(fileLabel);
        frame.add(fileText);

        frame.add(packButton);

        frame.setVisible(true);
    }


    public void packFiles(String FolderName, String PackFileName)
    {
        int iRet = 0;
        int Size = 0;
        int i = 0;
        int j = 0;

        String header = "";

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        byte Buffer[] = new byte[1024];
        byte bHeader[] = null;

        File fobjfolder = new File(FolderName);

        if((fobjfolder.exists()) && (fobjfolder.isDirectory()))
        {
            System.out.println("Folder Exist");

            File fobjpack = new File(PackFileName);

            try
            {
                fobjpack.createNewFile();

                foobj = new FileOutputStream(fobjpack);

                File fArr[] = fobjfolder.listFiles();

                System.out.println("Number of files in Folder: " + fArr.length);

                for(i = 0; i < fArr.length; i++)
                {
                    // Open current file
                    fiobj = new FileInputStream(fArr[i]);

                    // Create header
                    header = header + fArr[i].getName();
                    header = header + " ";
                    header = header + fArr[i].length();

                    // Make header 100 characters
                    Size = 100 - header.length();

                    for(j = 1; j <= Size; j++)
                    {
                        header = header + " ";
                    }

                    bHeader = header.getBytes();

                    // Write header
                    foobj.write(bHeader);

                    // Read file data and write into packed file
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer, 0, iRet);
                    }

                    fiobj.close();

                    // Reset header for next file
                    header = "";
                }

                foobj.close();

                System.out.println("Packing completed successfully!");
            }
            catch(IOException iobj)
            {
                System.out.println(iobj);
            }
        }
        else
        {
            System.out.println("There is no such folder");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new FilePacker());
    }
}