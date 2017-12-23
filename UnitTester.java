import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UnitTester {

    private String className;
    private String funcName;
    private String[] parameter = new String[10];
    private String[] paramType = new String[10];
    private String expected;
    private int numOfParam;

    public UnitTest(String className, String funcName, String[] parameter, String[] paramType, String expected, int numOfParam) {
        this.className = className;
        this.funcName = funcName;
        this.parameter = parameter;
        this.paramType = paramType;
        this.expected = expected;
        this.numOfParam = numOfParam;
    }

    void test(){
        
        for (int i=0; i<paramType.length; i++){
            if(paramType[i] == null){}
            else if (paramType[i].toLowerCase().contains("string")){
                StringBuilder sb = new StringBuilder(parameter[i]);
                sb.insert(0,"\"");
                parameter[i] = sb.toString() + "\"";
            }
            else if (paramType[i].toLowerCase().contains("char")){
                StringBuilder sb = new StringBuilder(parameter[i]);
                sb.insert(0,"'");
                parameter[i] = sb.toString() + "'";
            }
        }


        PrintWriter writer = new PrintWriter("/home/melih/Downloads/SoftwareEngineering-2/CalcTest.java", "UTF-8");

        writer.write("import org.junit.Test;\n" +
            "\n" +
            "import static org.junit.Assert.*;\n" +
            "\n" +
            "public class CalcTest {\n" +
            "    @Test\n" +
            "    public void main() {\n");
        writer.write("       " + className + " " + className.toLowerCase() + " = new " + className + "();\n" +
        "       assertEquals(" + expected + "," + className.toLowerCase() + "." + funcName + "(");
        for (int i=0; i<numOfParam-1; i++){
            writer.write(parameter[i] + ", " );
        }
        writer.write(parameter[numOfParam-1] + ")); \n");
        writer.write("\t}\n" +
        "\n" +
        "}");

        writer.close();

        ProcessBuilder builder = new ProcessBuilder(
                "xterm", "-e", "cd \"/home/melih/Downloads/Software Engineering-2\" &&" +
                " javac -cp .:\"/home/melih/Downloads/SoftwareEngineering-2/*\": CalcTest.java &&" +
                " java -cp .:\"/home/melih/Downloads/SoftwareEngineering-2/*\": org.junit.runner.JUnitCore CalcTest >Tests.txt ");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }
}

