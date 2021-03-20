import java.io.File;

public class CreateFolder {
    public static void main(String[] args) {
        if(args.length != 4) {
            System.out.println("Usage: java CreateFolder folderName start end path");
            System.exit(1);
        }

        // pattern information of folders
        String folderNames = args[0];
        int start = Integer.valueOf(args[1]);
        int end = Integer.valueOf(args[2]);
        String path = args[3];

        createFolder(path, folderNames, start, end+1);

    }

    private static void createFolder(String path, String folderNames, int start, int end) {
       for(int i=start; i<end; i++) {
           File file = new File(path + "/" + folderNames + "_" + i);
           if(!file.exists())
               file.mkdir();
       }
    }
}
