import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class create_test_code {
	private String expected;
	private String class_name;
	private String test_fuction_name;
	private ArrayList<Object> paramaters;
	private String params_return_types;
	private ArrayList<Object> params_types;
	private final String CLASSNAME = "test_den";
	private static final String FILENAME = "test_den.java";
	
	public create_test_code(String class_name, String test_fuction_name, String params_return_type, ArrayList<Object> params,
		 ArrayList<Object> params_type,String ex) {
		this.expected = ex;
		this.class_name = class_name;
		this.test_fuction_name = test_fuction_name;
		this.paramaters = params;
		this.params_return_types = params_return_type;
		this.params_types = params_type;
		
	}
	
	
	private void write_test_file() {
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "import static org.junit.Assert.*;\r\n"+"import java.io.BufferedWriter;\r\n" + 
					"import java.io.FileWriter;\r\n" + 
					"import java.io.IOException\n;" + 
					"public class "+CLASSNAME+"{ \n" +
			"public static void main(String[] args){\n" + class_name + " obj = new " + class_name +"();\n"
			+params_return_types+" result = obj."+test_fuction_name+"(";
			
			String content2 = "";
			System.out.println(paramaters.size());
			for (int i=0; i<paramaters.size(); ++i) {
				//params_types.get(i)
				content2 += "("+params_types.get(i)+")";
				
				if (params_types.get(i) == "int" || params_types.get(i) =="double"||
						params_types.get(i) == "Integer" || params_types.get(i) =="Double")
					content2 +=paramaters.get(i) ;
				else  //string falan
					content2 += "\"" +paramaters.get(i).toString() +"\"";
				
					
				
				if(i != paramaters.size()-1)
					content2 +=",";
				
			}
			content2 +=");\n"+
			"\rBufferedWriter bw = null;\r\n" + 
			"		FileWriter fw = null;\r\n" + 
			"\r\n" + 
			"		try {\r\n" + 
			"			String content = \"\";\r\n" + 
			"			if(result.equals("+ expected + "))\n"+"				content = \"The test is pass\\n\";\r\n" + 
					"			else\r\n" + 
					"				content = \"The test is fail, expected:"+expected+" result:\"+result+\"\\n\";\r\n" + 
					"			\r\n" + 
					"			fw = new FileWriter(\"test_result.txt\");\r\n" + 
					"			bw = new BufferedWriter(fw);\r\n" + 
					"			bw.write(content);\r\n" + 
					"\r\n" + 
					"			System.out.println(\"Done\");\r\n" + 
					"\r\n" + 
					"		} catch (IOException e) {\r\n" + 
					"\r\n" + 
					"			e.printStackTrace();\r\n" + 
					"\r\n" + 
					"		} finally {\r\n" + 
					"\r\n" + 
					"			try {\r\n" + 
					"\r\n" + 
					"				if (bw != null)\r\n" + 
					"					bw.close();\r\n" + 
					"\r\n" + 
					"				if (fw != null)\r\n" + 
					"					fw.close();\r\n" + 
					"\r\n" + 
					"			} catch (IOException ex) {\r\n" + 
					"\r\n" + 
					"				ex.printStackTrace();\r\n" + 
					"\r\n" + 
					"			}\r\n" + 
					"\r\n" + 
					"		}}}";
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.write(content2);
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		
		
	}
	
	public static void main(String[] args){
		
		ArrayList<Object>	params = new ArrayList<Object>();
		params.add("5");
		params.add("-10");
		
		ArrayList<Object>	type = new ArrayList<Object>();
		type.add("int");
		type.add("int");


		create_test_code e = new create_test_code("calculator","sum","int",params,type,"-5" );
		e.write_test_file();

		
	}
	
	
	
}
