import java.io.*;
import java.util.Scanner;

import list.*;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Scanner input = new Scanner(System.in);


        try {
            File file = new File("out/namefile.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                String splitter[] = data.split(":", 2);
                ll.add(splitter[0], splitter[1]);
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ll.InsertionSort();
        // tampilan program
        System.out.print("\nLinkedList Program \n1. Judul artikel editor \n2. Searching editor  \n3. Tampilkan semua nama editor \nPilihan Anda : ");
        int pilih = input.nextInt();
        String editor;
        switch (pilih) {
            case 1:
                System.out.print("Masukkan Nama Editor : ");
                input.nextLine();
                editor = input.nextLine();
                ll.displayWithTitle(editor);
                break;
            case 2:
                System.out.print("Masukkan Nama Editor : ");
                input.nextLine();
                editor = input.nextLine();
                ll.searchContainsEditor(editor);
                break;
            case 3:
                ll.displayWithoutTitle();
                break;
        }
        input.close();
    }
}