import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.*;
import javax.swing.*;

class FileUnpacker implements Runnable
{
   public void run()
    {
        JFrame frame = new JFrame("Java File Un-Packer");

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel packfileLabel = new JLabel("Pack File Name:");
        packfileLabel.setBounds(30, 130, 120, 30);

        JTextField packfileText = new JTextField();
        packfileText.setBounds(30, 160, 220, 30);

        JButton unpackButton = new JButton("Unpack");
        unpackButton.setBounds(90, 220, 100, 35);

        unpackButton.addActionListener(e ->
        {
            String packFileName = packfileText.getText();

            try
            {
                fileUnpacker(packFileName);
            }
            catch(Exception iobj)
            {
                System.out.println(iobj);
            }

            frame.dispose();
        });

        frame.add(packfileLabel);
        frame.add(packfileText);

        frame.add(unpackButton);

        frame.setVisible(true);
    }

    public void fileUnpacker(String packFileName) throws Exception
    {
        File fpackobj = null;
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;
        byte Header []= new byte[100];
        String strHeader = null;
        String Tokens []= null;
        File NewFile = null;
        byte Buffer[] = null;
        int iRet = 0;

        fpackobj = new File(packFileName);

        if(fpackobj.exists())
        {
            fiobj = new FileInputStream(fpackobj);

            while ((iRet = fiobj.read(Header, 0, 100)) != -1)
            {

                strHeader = new String(Header);

                System.out.println("Header is :"+strHeader);

                strHeader = strHeader.trim();
                strHeader = strHeader.replaceAll("\\s+", " ");

                Tokens = strHeader.split(" ");
                
                System.out.println("File Name :"+Tokens[0]);
                System.out.println("File Size :"+Tokens[1]);

                NewFile = new File(Tokens[0]);
                NewFile.createNewFile();

                foobj = new FileOutputStream(NewFile);

                Buffer = new byte[Integer.parseInt(Tokens[1])];
                
                // read data 
                fiobj.read(Buffer, 0, Integer.parseInt(Tokens[1]));

                // write
                foobj.write(Buffer, 0, Integer.parseInt(Tokens[1]));

                foobj.close();
            } // end of while

            fiobj.close();
        }
        else
        {
            System.out.println("Thers is no such pack file ");
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new FileUnpacker());
    } 
}
