package TestingServlet;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	//	String files = ListingSubFilePath.giveAllPaths("/home/serhan/Desktop/asd/");
		
		List<String> list = new ArrayList<String>();
		//String[] allFiles = files.split("\n");
		//for(String file: allFiles)
		//	list.add(file);																																																								
		MainController.listFilesAndFilesSubDirectories("/home/serhan/Desktop/asd",list);
		req.setAttribute("mymessage", list);
		//resp.sendRedirect("/Testing/index.jsp");
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}
    public static void listFilesAndFilesSubDirectories(String directoryName,List<String> list){

        File directory = new File(directoryName);

        //get all the files from a directory

        File[] fList = directory.listFiles();

        for (File file : fList){

            if (file.isFile()){
            	if(file.getAbsolutePath().contains(".class"))
            		list.add(file.getAbsolutePath());

            } else if (file.isDirectory()){

                listFilesAndFilesSubDirectories(file.getAbsolutePath(),list);

            }

        }

    }
	

}