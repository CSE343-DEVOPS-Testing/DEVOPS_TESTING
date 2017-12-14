import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListingSubFilePath {
    public static class allFile{
        public String PackageName = "InitialDirectory";
        public List<String> fileNames = new ArrayList<String>();
        public List<allFile> packageNames = new ArrayList<allFile>( );

        public String toString()
        {
            String str = PackageName + "\n";

            try {

                for(int i = 0; i < fileNames.size(); ++i)
                {
                    str += fileNames.get(i) + "\n";
                }

                for(int i = 0; i < packageNames.size(); ++i)
                {
                    JSONObject js2 = new JSONObject();
                    str += packageNames.get(i) ;
                }

            }catch (Exception e)
            {

            }

            return str;
        }
    }

    public static List<File> listf(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Directory");
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        //System.out.println(fList);
        return resultList;
    }


    public static void listDirectory(String dirPath, int level, allFile af) {
        File dir = new File(dirPath);
        File[] firstLevelFiles = dir.listFiles();
        if (firstLevelFiles != null && firstLevelFiles.length > 0) {
            for (File aFile :  firstLevelFiles) {
                for (int i = 0; i < level; i++) {
                    //System.out.print("\t");
                }
                if (aFile.isDirectory()) {
                    allFile temp = new allFile();
                    temp.PackageName = aFile.getName();

                    af.packageNames.add(temp);
                    //System.out.println("[" + aFile.getName() + "]");
                    listDirectory(aFile.getAbsolutePath(), level + 1,af.packageNames.get(af.packageNames.size()-1));
                } else {
                    af.fileNames.add(aFile.getName());
                    //System.out.println(aFile.getName());
                }
            }
        }
    }
    public static void main(String[] args)
    {
        allFile af = new allFile ();
        ListingSubFilePath.listDirectory("C:\\Users\\muham\\Desktop\\package",0, af);

        JSONObject js = new JSONObject();
        System.out.println(af.toString());
    }
}
