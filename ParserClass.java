import java.util.ArrayList;

public class ParserClass {

    public static String findMethodLine(String className){
        String methodLine = "";
        try {

            String pathX = className;
            Class pathClass = (Class.forName(pathX));
            Class c = pathClass;
            java.lang.reflect.Method[] m = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++){
                // System.out.println(m[i]);
                methodLine += m[i];
                methodLine += "\n";
            }

        } catch (Throwable e) {
            System.err.println(e);
        }

        return methodLine;

    }

    public static ArrayList<ArrayList<String>> lineParser(String parsedChar){

        ArrayList<ArrayList<String>> s = new ArrayList<ArrayList<String>>();
        ArrayList<String> subVec = new ArrayList<>();

        int closeIndex= parsedChar.indexOf(")");

        while(closeIndex != -1){

            subVec = new ArrayList<>();
            String tempString = parsedChar.substring(0,closeIndex+1);


            String privateControl = tempString.substring(0,tempString.indexOf(" "));

            if(!privateControl.equals("private")) {
                String parametersString = tempString.substring(tempString.indexOf("("), tempString.indexOf(")") + 1);
                String methodSign = tempString.substring(0,tempString.indexOf("("));
                String methodNameAndClassName = methodSign.substring(methodSign.lastIndexOf(" ")+1);
                String className = methodNameAndClassName.substring(0,methodNameAndClassName.indexOf("."));
                String methodName = methodNameAndClassName.substring(methodNameAndClassName.indexOf(".")+1);


                tempString = methodSign.substring(0,methodSign.lastIndexOf(" "));
                int spaceIndex = tempString.lastIndexOf(" ");
                String returnType = "";

                if(spaceIndex != -1)
                    returnType = tempString.substring(tempString.lastIndexOf(" ")+1);
                else
                    returnType = tempString.substring(0);


                subVec.add(className);
                subVec.add(returnType);
                subVec.add(methodName);

                int commaIndex = parametersString.indexOf(",");
                parametersString = parametersString.substring(1,parametersString.length()-1);
                if(commaIndex != -1){
                    String[] textStr = parametersString.split(",");
                    for(int i=0; i<textStr.length; i++)
                        subVec.add(textStr[i]);
                }
                else {
                   if(!parametersString.equals(""))
                       subVec.add(parametersString);
                }
                s.add(subVec);
            }

            int newLineIndex = parsedChar.indexOf("\n");
            if(newLineIndex != -1) {
                parsedChar = parsedChar.substring(newLineIndex + 1);
                closeIndex = parsedChar.indexOf(")");
            }
            else
                closeIndex = -1;

        }

        return s;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //String methodLine=null;
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        
        ArrayList<String> nameOfMethods = new ArrayList<String>();
        ArrayList<String> returnTypes = new ArrayList<String>(); 
        ArrayList<ArrayList<String>> parametersType = new ArrayList<ArrayList<String>>();
        ArrayList<String> subArrayList = new ArrayList<String>();
        
        String methodLine = findMethodLine("calculator");
        listOfLists = lineParser(methodLine);

        for(int i=0; i<listOfLists.size(); i++){
        	subArrayList = new ArrayList<>();
            System.out.println(listOfLists.get(i));
        	
        	nameOfMethods.add(listOfLists.get(i).get(2));
        	returnTypes.add(listOfLists.get(i).get(1));
        	
        	for(int j=3; j<listOfLists.get(i).size(); j++)		
        		subArrayList.add(listOfLists.get(i).get(j));
        	
        	parametersType.add(subArrayList);
        			
        }    
        
          System.out.println("\n"+nameOfMethods);   
          System.out.println(returnTypes+"\n");
          
          for(int i=0; i<parametersType.size(); i++)
				System.out.println(parametersType.get(i));
            
   
    }
}
