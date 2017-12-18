import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ParserClass {

    public static class MethodPrinter {

        static ArrayList<String> nameOfMethods = new ArrayList<String>();
        static ArrayList<String> returnTypes = new ArrayList<String>();
        static ArrayList<ArrayList<String>> parametersType = new ArrayList<ArrayList<String>>();

        public static void main(String[] args) throws Exception {
            // creates an input stream for the file to be parsed
            FileInputStream in = new FileInputStream("C:\\Users\\murat\\Desktop\\FitState.java");

            CompilationUnit cu;
            try {
                // parse the file
                cu = JavaParser.parse(in);
            } finally {
                in.close();
            }
            // visit and print the methods names
            cu.accept(new MethodVisitor(), null);

            System.out.println(nameOfMethods);
            System.out.println(returnTypes);
            System.out.println(parametersType);
        }

        /**
         * Simple visitor implementation for visiting MethodDeclaration nodes.
         */
        public static class MethodVisitor extends VoidVisitorAdapter {

            @Override
            public void visit(MethodDeclaration n, Object arg) {
                // here you can access the attributes of the method.
                // this method will be called for all methods in this
                // CompilationUnit, including inner class methods
                ArrayList<String> controlModifier = new ArrayList<String>();
                ArrayList<String> subArrayList = new ArrayList<String>();

                controlModifier.add(n.getModifiers().toString());


                int controlIndex = controlModifier.get(0).indexOf(" ");
                String controlModifierString = "";
                if(controlIndex != -1)
                    controlModifierString = controlModifier.get(0).substring(1,controlModifier.get(0).indexOf(" ")-1);

                if(controlModifierString.equals("PRIVATE")) {
                    ;
                }
                else {

                    nameOfMethods.add(n.getName().toString());
                    returnTypes.add(n.getType().toString());
                    for(int i=0; i<n.getParameters().size(); i++){
                        subArrayList.add(String.valueOf(n.getParameters().get(i)));
                    }
                    parametersType.add(subArrayList);

                    /*System.out.println(n.getType());
                    System.out.println(n.getName());
                    System.out.println(n.getParameters());*/
                }
            }
        }
    }
}
